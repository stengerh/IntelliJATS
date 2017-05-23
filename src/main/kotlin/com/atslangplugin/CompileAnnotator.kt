package com.atslangplugin

import com.intellij.codeInsight.daemon.impl.ExternalToolPass
import com.intellij.codeInsight.daemon.impl.ExternalToolPassFactory
import com.intellij.lang.ExternalLanguageAnnotators
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.ExternalAnnotator
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import java.io.File
import java.io.IOException

class CompileAnnotator : ExternalAnnotator<String,String>() {

    //TODO: got to be a better way
    fun recursivePath(dir: PsiDirectory?): String {
        return dir?.let { dir ->
            val parent = dir.parentDirectory
            recursivePath(parent) + dir.name + File.separator
        } ?: ""
    }


    fun String.runCommand(workingDir: File): String? {
        try {
            val parts = this.split("\\s".toRegex())
            val proc = ProcessBuilder(*parts.toTypedArray())
                    .directory(workingDir)
//                    .redirectOutput(ProcessBuilder.Redirect.PIPE)
                    .redirectError(ProcessBuilder.Redirect.PIPE)
                    .start()
            return proc.inputStream.bufferedReader().readText()
        } catch(e: IOException) {
            //TODO: weak should phone home an error
            e.printStackTrace()
            return null
        }
    }

//    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
////        ExternalLanguageAnnotators
//        if (element is PsiFile) {
//            val dir = element.getContainingDirectory()
//
//            dir?.let { dir ->
//                val fullDir = recursivePath(dir)
//                val fullPath = fullDir + element.name
//
//                //TODO: descriminate on file type
//
//
//                val f = File(fullDir)
//                val errors = ("""patsopt --jsonize-2 -d """ + element.name).runCommand(f)
//
//                holder.createErrorAnnotation(TextRange(10, 13), "test: " + fullPath +"\n" + errors)
//            }
//        }
//    }
}