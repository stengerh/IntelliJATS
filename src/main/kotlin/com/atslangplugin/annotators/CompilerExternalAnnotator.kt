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

//TODO: type of error?
data class ErrorMsg(
        val file: String,
        val startLine: Int, val startCol: Int,
        val endLine: Int, val endCol: Int,
        val message: String, val full: String) {

    companion object {
        val regex = Regex("(.*): \\d+\\(line=(\\d+), offs=(\\d+)\\) -- \\d+\\(line=(\\d+), offs=(\\d+)\\):(.*)")//(//n+)\\(.*")

        fun fromString(error: String): ErrorMsg? {

            val data = regex.matchEntire(error)
            data?.let { data ->
                //                if (data.groupValues.size == 6) {

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
//                }

            }
            return null
        }
    }
}

// May be required to avoid file deadlocks, since intellij autosaves
// TODO my guess is it only runs when the parse tree changes, need better parstrees, or just way more specific parse trees
class CompilerExternalAnnotator : ExternalAnnotator<InitialInfo, String>() {

    override fun collectInformation(file: PsiFile, editor: Editor, hasErrors: Boolean): InitialInfo? {
        //run the compiler even if there are errors
        return collectInformation(file)
    }


    override fun collectInformation(file: PsiFile): InitialInfo? {
        println("collectInformation")

        val dir = file.getContainingDirectory()

        if (dir is PsiDirectory) {
            val fullDir = recursivePath(dir)
            println(" do it!")
            return InitialInfo(File(fullDir), file.name)
        }
        println(" null")
        return null
    }

    override fun doAnnotate(collectedInfo: InitialInfo): String? {

        Thread.sleep(1000) //often the file has not been saved to disc.  TODO: find a more robust way to wait until the file is saved

//TODO: need to extend the regex to support --typecheck errors

//TODO: use psi nonsense to get the file "type" so that it is consistent with the IDE interface
        if (collectedInfo.name.endsWith(".dats")) {
//            println("run compiler dynamic")
            val errors = ("""patsopt --jsonize-2 --debug --dynamic """ + collectedInfo.name).runCommand(collectedInfo.dir)
//            println(errors)
//            println("   done compiler")
            return errors
        } else if (collectedInfo.name.endsWith(".sats")) {
//            println("run compiler static")
            val errors = ("""patsopt --jsonize-2 --debug --static """ + collectedInfo.name).runCommand(collectedInfo.dir)
//            println(errors)
//            println("   done compiler")
            return errors
        }
        println("  null")
        return null
    }


    override fun apply(file: PsiFile, annotationResult: String, holder: AnnotationHolder) {
        println("apply")

        println(annotationResult)


        //TODO: move this up to the slow function
        val errors = annotationResult.splitToSequence("\r\n", "\n", "\r")

        //TODO:

        val project = file.getProject()

        //TODO: what mkes sure the file hasn't changed since collectInformation
        val document = PsiDocumentManager.getInstance(project).getDocument(file)

        println(document)

        if (document is Document) {

            val m = errors.map { ErrorMsg.fromString(it) }.filterNotNull()
//TODO: need to check line valitity, since things can get out of sync


            //TODO: this regex may not be exact
            m.forEach {
                error ->

                println(error.file)
                println(error.file.endsWith(file.name))
                //TODO: this is inexact if a file depends on another file with the same name at a different location this will not work
                //TODO: hilight location in the origional file, or the location it was imported
                if (error.file.endsWith(file.name)) {

                    val range = TextRange(
                            document.getLineStartOffset(error.startLine - 1) + error.startCol - 1,
                            document.getLineStartOffset(error.endLine - 1) + error.endCol - 1)

                    println(range)
                    println(error)

                    holder.createErrorAnnotation(range, error.message
//                            + "\n" + error.full //TODO: make the full errors configurable
                    )
                }
            }
        }

    }


}