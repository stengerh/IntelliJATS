package com.atslangplugin.annotators

import com.atslangplugin.ATSBundle
import com.atslangplugin.ATSSyntaxHighlighter
import com.atslangplugin.psi.ATSCharLiteral
import com.atslangplugin.psi.ATSFloatLiteral
import com.atslangplugin.psi.ATSIntLiteral
import com.atslangplugin.psi.ATSStringLiteral
import com.intellij.lang.annotation.Annotation
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class AtsLiteralAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is ATSIntLiteral -> annotateIntLiteral(element, holder)
            is ATSFloatLiteral -> annotateFloatLiteral(element, holder)
            is ATSStringLiteral -> annotatorStringLiteral(element, holder)
            is ATSCharLiteral -> annotateCharLiteral(element, holder)
        }
    }

    private fun annotateIntLiteral(element: ATSIntLiteral, holder: AnnotationHolder) {
        val text = element.text

        if (POSSIBLE_OCT_LITERAL.matches(text) && !VALID_OCT_LITERAL.matches(text)) {
            holder.createErrorAnnotation(element, ATSBundle.message("syntax.error.int.oct.invalid"))
        }

        if (EMPTY_HEX_LITERAL.matches(text)) {
            holder.createErrorAnnotation(element, ATSBundle.message("syntax.error.int.hex.empty"))
        }

        val suffix = INT_SUFFIX.find(text)
        if (suffix != null && !SUPPORTED_INT_SUFFIX.matches(suffix.value)) {
            val elementOffset = element.textOffset
            val suffixRange = TextRange(suffix.range.first, suffix.range.last + 1)
            holder.createErrorAnnotation(suffixRange.shiftRight(elementOffset), ATSBundle.message("syntax.error.int.suffix.unsupported"))
        }
    }

    private fun annotateFloatLiteral(element: ATSFloatLiteral, holder: AnnotationHolder) {
        val text = element.text

        if (EMPTY_FLOAT_EXPONENT.matches(text)) {
            holder.createErrorAnnotation(element, ATSBundle.message("syntax.error.float.exp.empty"))
        }

        val suffix = FLOAT_SUFFIX.find(text)
        if (suffix != null && !SUPPORTED_FLOAT_SUFFIX.matches(suffix.value)) {
            val elementOffset = element.textOffset
            val suffixRange = TextRange(suffix.range.first, suffix.range.last + 1)
            holder.createErrorAnnotation(suffixRange.shiftRight(elementOffset), ATSBundle.message("syntax.error.float.suffix.unsupported"))
        }
    }

    private fun annotatorStringLiteral(element: ATSStringLiteral, holder: AnnotationHolder) {
        val text = element.text

        if (text.length > 1 && (text.last() != '"' || isEscapedChar(text, text.lastIndex))) {
            holder.createErrorAnnotation(element, ATSBundle.message("syntax.error.string.unclosed"))
        }

        val textFragments = getTextFragments(element)
        annotateEscapeSequences(element, textFragments, holder)
    }

    private fun annotateCharLiteral(element: ATSCharLiteral, holder: AnnotationHolder) {
        val text = element.text

        if (EMPTY_CHAR_LITERAL.matches(text)) {
            holder.createErrorAnnotation(element, ATSBundle.message("syntax.error.char.empty"))
        }

        if (text.length > 1 && (text.last() != '\'' || isEscapedChar(text, text.lastIndex))) {
            holder.createErrorAnnotation(element, ATSBundle.message("syntax.error.char.unclosed"))
        }

        val textFragments = getTextFragments(element)

        if (textFragments.size > 1) {
            holder.createErrorAnnotation(element, ATSBundle.message("syntax.error.char.too.long"))
        }

        annotateEscapeSequences(element, textFragments, holder)
    }

    private fun isEscapedChar(text: String, index: Int): Boolean {
        val count = (0 until index)
                .reversed()
                .takeWhile { text[it] == '\\' }
                .count()
        return (count % 2) == 1
    }

    private fun annotateEscapeSequences(element: PsiElement, textFragments: List<Pair<TextRange, String>>, holder: AnnotationHolder) {
        val elementOffset by lazy { element.textOffset }
        textFragments.forEach { (fragmentRange, fragmentText) ->
            if (fragmentText.first() == '\\' && fragmentText.length > 1) {
                if (VALID_ESCAPE_SEQUENCE.matches(fragmentText)) {
                    holder.createInfoAnnotation(elementOffset, fragmentRange) {
                        textAttributes = ATSSyntaxHighlighter.ATS_VALID_STRING_ESCAPE
                    }
                } else {
                    when (fragmentText[1]) {
                        'x', 'X' -> holder.createErrorAnnotation(elementOffset, fragmentRange, ATSBundle.message("syntax.error.escape.hex.invalid")) {
                            textAttributes = ATSSyntaxHighlighter.ATS_INVALID_STRING_ESCAPE
                        }
                        else -> holder.createErrorAnnotation(elementOffset, fragmentRange, ATSBundle.message("syntax.error.escape.oct.invalid")) {
                            textAttributes = ATSSyntaxHighlighter.ATS_INVALID_STRING_ESCAPE
                        }
                    }
                }
            }
        }
    }

    private fun AnnotationHolder.createInfoAnnotation(elementOffset: Int, rangeInElement: TextRange, init: Annotation.() -> Unit): Annotation {
        val annotation = this.createInfoAnnotation(rangeInElement.shiftRight(elementOffset), null)
        annotation.init()
        return annotation
    }

    private fun AnnotationHolder.createErrorAnnotation(elementOffset: Int, rangeInElement: TextRange, message: String, init: Annotation.() -> Unit): Annotation {
        val annotation = this.createErrorAnnotation(rangeInElement.shiftRight(elementOffset), message)
        annotation.init()
        return annotation
    }

    private fun getTextFragments(element: ATSCharLiteral): List<Pair<TextRange, String>> {
        return getTextFragments(element.text)
    }

    private fun getTextFragments(element: ATSStringLiteral): List<Pair<TextRange, String>> {
        return getTextFragments(element.text)
    }

    private fun getTextFragments(text: String): List<Pair<TextRange, String>> {
        val fragments = FRAGMENT.findAll(text)
        return fragments
                .map { fragment ->
                    Pair(TextRange(fragment.range.first, fragment.range.last + 1), fragment.value)
                }
                .toList()
    }

    private companion object {
        val POSSIBLE_OCT_LITERAL = Regex("0[0-9]+")
        val VALID_OCT_LITERAL = Regex("0[0-7]+")

        val EMPTY_HEX_LITERAL = Regex("0[Xx]")

        val INT_SUFFIX = Regex("[LlUu]+$")
        val SUPPORTED_INT_SUFFIX = Regex("u|l|ul|lu|ll|ull|llu", RegexOption.IGNORE_CASE)

        val EMPTY_FLOAT_EXPONENT = Regex("[0-9.]+[Ee][+-]?[^0-9]*")

        val FLOAT_SUFFIX = Regex("[FfLl]+$")
        val SUPPORTED_FLOAT_SUFFIX = Regex("[FfLl]")

        val EMPTY_CHAR_LITERAL = Regex("''")

        // Note: ATS2-0.3.2 actually accepts decimal digits for octal escape sequences but still interprets them in base 8
        // Note: ATS2-0.3.13 rejects non-octal digits in octal escape sequences; digits 8 and 9 do not end the escape sequence
        val FRAGMENT = Regex("[^'\\\\]|\\\\(x[0-9a-fA-F]{1,2}|[0-9]{1,3}|[^x0-9]|\\r|\\n|\\r\\n|)")

        val VALID_ESCAPE_SEQUENCE = Regex("\\\\([abfnrtv\\\\'\"?]|x[0-9a-fA-F]{1,2}|[0-7]{1,3}|\\r|\\n|\\r\\n)")
    }
}
