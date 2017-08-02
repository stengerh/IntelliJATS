package com.atslangplugin.annotators

import com.atslangplugin.annotators.CompilerHelper.recursivePath
import com.atslangplugin.annotators.CompilerHelper.runCommand
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.ExternalAnnotator
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile
import java.io.File


data class InitialInfo(val dir: File, val name: String)

data class ErrorMsg(
        val file: String,
        val startLine: Int, val startCol: Int,
        val endLine: Int, val endCol: Int,
        val message: String, val full: String) {

    companion object {
        val regex = Regex("(.*): \\d+\\(line=(\\d+), offs=(\\d+)\\) -- \\d+\\(line=(\\d+), offs=(\\d+)\\):(.*)")


        //this is inelegant and kind of a mess, but that's what happens when you use java regex
        fun fromLines(error: String): List<ErrorMsg> {
            val lines = error.split("\n")

            var list = emptyList<ErrorMsg>()

            for (line in lines) {
                val data = regex.matchEntire(line)
                if (data != null) {
                    try {

                        val msg = ErrorMsg(
                                data.groupValues[1],
                                data.groupValues[2].toInt(),
                                data.groupValues[3].toInt(),
                                data.groupValues[4].toInt(),
                                data.groupValues[5].toInt(),
                                data.groupValues[6],
                                error
                        )
                        list += msg

                    } catch (e: NumberFormatException) {
                        //TODO: investigate these parse errors
                    }
                } else {
                    //if there was a previous error add the line to it, otherwise ignore it
                    if (!list.isEmpty()) {
                        val oldmsg = list.last()

                        val newmsg = ErrorMsg(oldmsg.file,
                                oldmsg.startLine,
                                oldmsg.startCol,
                                oldmsg.endLine,
                                oldmsg.endCol,
                                oldmsg.message + "\n" + line,
                                oldmsg.full + "\n" + line
                        )
                        list = list.subList(0, list.lastIndex) + newmsg
                    }
                }
            }

            return list
        }


        fun fromString(error: String): ErrorMsg? {

            val data = regex.matchEntire(error)

            if (data != null) {
                try {
                    return ErrorMsg(
                            data.groupValues[1],
                            data.groupValues[2].toInt(),
                            data.groupValues[3].toInt(),
                            data.groupValues[4].toInt(),
                            data.groupValues[5].toInt(),
                            data.groupValues[6],
                            error
                    )

                } catch (e: NumberFormatException) {
                    //TODO: investigate these parse errors
                }

            }
            return null
        }
    }
}

// May be required to avoid file deadlocks, since intellij auto-saves
// TODO my guess is it only runs when the parse tree changes, need better parse trees, or just way more specific parse trees
class CompilerExternalAnnotator : ExternalAnnotator<InitialInfo, String>() {

    override fun collectInformation(file: PsiFile, editor: Editor, hasErrors: Boolean): InitialInfo? {
        //run the compiler even if "hasErrors==true" since the lexer can flag spurious errors
        return collectInformation(file)
    }


    override fun collectInformation(file: PsiFile): InitialInfo? {

        val dir = file.containingDirectory

        if (dir is PsiDirectory) {
            val fullDir = recursivePath(dir)
            return InitialInfo(File(fullDir), file.name)
        }
        return null
    }

    override fun doAnnotate(collectedInfo: InitialInfo): String? {

        Thread.sleep(1000) //often the file has not been saved to disk. (this can also cuase race conditions)
        //  TODO: find a more robust way to wait until the file is saved

        //TODO: use psi nonsense to get the file "type" so that it is consistent with the IDE interface
        if (collectedInfo.name.endsWith(".dats")) {
            // TODO: thses strings and the ats compiler path and config should probably be configurable
            val errors = ("""patsopt --typecheck  --debug --dynamic """ + collectedInfo.name).runCommand(collectedInfo.dir)
            return errors
        } else if (collectedInfo.name.endsWith(".sats")) {
            val errors = ("patsopt --typecheck  --debug --static " + collectedInfo.name).runCommand(collectedInfo.dir)
            return errors
        }

        return null
    }


    override fun apply(file: PsiFile, annotationResult: String, holder: AnnotationHolder) {
        //TODO: move this up to the "slow" function

        val project = file.project

        //TODO: what makes sure the file hasn't changed since collectInformation?
        val document = PsiDocumentManager.getInstance(project).getDocument(file)

        if (document is Document) {

            val m = ErrorMsg.fromLines(annotationResult)
            //TODO: need to check line validity, since things can get out of sync (see other plugins)

            for ((errorFile,
                    startLine, startCol,
                    endLine, endCol,
                    message, _) in m) {

                //TODO: this is inexact if a file depends on another file with the same name at a different location, than this will not work
                //TODO: highlight location in the original file, or the location it was imported
                if (errorFile.endsWith(file.name)) {

                    val range = TextRange(
                            document.getLineStartOffset(startLine - 1) + startCol - 1,
                            document.getLineStartOffset(endLine - 1) + endCol - 1)

                    holder.createErrorAnnotation(range, message)
                }
            }
        }
    }
}