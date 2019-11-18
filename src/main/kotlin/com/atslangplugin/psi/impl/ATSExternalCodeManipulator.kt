package com.atslangplugin.psi.impl

import com.atslangplugin.psi.ATSExternalCode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil

class ATSExternalCodeManipulator : AbstractElementManipulator<ATSExternalCode>() {

    override fun getRangeInElement(element: ATSExternalCode): TextRange {
        val text = element.text
        val startMatch = START.find(text)
        val startOffset = when {
            startMatch != null -> startMatch.range.last + 1
            else -> 0
        }
        val endMatch = END.find(text, startOffset)
        val endOffset = when {
            endMatch != null -> endMatch.range.first
            else -> text.length
        }
        return TextRange(startOffset, endOffset)
    }

    override fun handleContentChange(element: ATSExternalCode, range: TextRange, newContent: String?): ATSExternalCode {
        val paddingEnd = when (newContent?.lastOrNull()) {
            '\r', '\n' -> ""
            else -> "\n"
        }
        val oldText = element.text
        val newText = oldText.substring(0, range.startOffset) + newContent + paddingEnd + oldText.substring(range.endOffset)
        val type = element.containingFile.fileType
        val fromText = PsiFileFactory.getInstance(element.project).createFileFromText("__." + type.defaultExtension, type, newText)
        val newElement = PsiTreeUtil.getParentOfType<ATSExternalCode>(fromText.findElementAt(0), element.javaClass, false)
                ?: error(type.toString() + " " + type.defaultExtension + " " + newText)
        return element.replace(newElement) as ATSExternalCode
    }

    private companion object {
        val START = Regex("^%\\{[#^$]?(?:\\r|\\n|\\r\\n)?")
        val END = Regex("^%}", RegexOption.MULTILINE)
    }
}