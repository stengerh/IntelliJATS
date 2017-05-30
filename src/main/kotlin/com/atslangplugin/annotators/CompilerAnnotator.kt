package com.atslangplugin.annotators

import com.atslangplugin.annotators.CompilerHelper.recursivePath
import com.atslangplugin.annotators.CompilerHelper.runCommand
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import java.io.File


class CompilerAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is PsiFile) {
            val dir = element.getContainingDirectory()

            if (dir is PsiDirectory) {

                val fullDir = recursivePath(dir)
                val fullPath = fullDir + element.name

                //TODO: descriminate on file type


                val f = File(fullDir)
                val errors = ("""patsopt --jsonize-2 -d """ + element.name).runCommand(f)

                holder.createErrorAnnotation(TextRange(10, 13), "test: " + fullPath + "\n" + errors)

            }

        }
    }


}