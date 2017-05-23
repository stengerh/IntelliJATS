package com.atslangplugin


import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon


class ATSColorSettingsPage : ColorSettingsPage {

    override fun getIcon(): Icon? {
        return ATSIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return ATSSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return """
//
fun copyinto
  {n:nat} .<n>.
(
  xs: !list_vt (a, n), p: ptr
) :<!wrt> void = let
in
//
case+ xs of
| @list_vt_cons
    (x, xs1) => let
    val (
    ) = \${'$'}UN.ptr0_set<a> (addr@(x), \${'$'}UN.ptr0_get<a> (p))
    val () = copyinto (xs1, ptr0_succ<a> (p))
  in
    fold@ (xs)
  end // end of [list_vt_cons]
| list_vt_nil ((*void*)) => ()
//
end // end of [copyinto]
//
implement
array_quicksort\${'$'}cmp<a>
  (x1, x2) = list_vt_quicksort\${'$'}cmp<a> (x1, x2)
// end of [array_quicksort\${'$'}cmp]
//
prval () = lemma_list_vt_param (xs)
//
val n = list_vt_length (xs)
//
val [l:addr]
  (pfat, pfgc | p0) = array_ptr_alloc<a> ((i2sz)n)
//
extern praxi
__out (pf: !array_v (a?, l, n) >> array_v (a, l, n)): void
extern praxi
__into (pf: !array_v (a, l, n) >> array_v (a?, l, n)): void
//
val () = copyout (xs, p0)
prval () = __out (pfat)
val () = array_quicksort<a> (!p0, (i2sz)n)
prval () = __into (pfat)
val () = copyinto (xs, p0)
//
val () = array_ptr_free {a} (pfat, pfgc | p0)
//
in
  xs
end // end of [list_vt_quicksort]

(* ****** ****** *)"""
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? = null

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "ATS"
    }

    companion object {
        private val DESCRIPTORS = arrayOf(
                AttributesDescriptor("Block comments", ATSSyntaxHighlighter.ATS_BLOCK_COMMENT),
                AttributesDescriptor("Braces", ATSSyntaxHighlighter.ATS_BRACES),
                AttributesDescriptor("Brackets", ATSSyntaxHighlighter.ATS_BRACKETS),
                AttributesDescriptor("Commas", ATSSyntaxHighlighter.ATS_COMMA),
                AttributesDescriptor("Directives", ATSSyntaxHighlighter.ATS_DIRECTIVES),
                AttributesDescriptor("Identifiers", ATSSyntaxHighlighter.ATS_IDENTIFIER),
                AttributesDescriptor("Line comments", ATSSyntaxHighlighter.ATS_LINE_COMMENT),
                AttributesDescriptor("Keywords", ATSSyntaxHighlighter.ATS_KEYWORD),
                AttributesDescriptor("Local variables", ATSSyntaxHighlighter.ATS_LOCAL_VARIABLE),
                AttributesDescriptor("Numbers", ATSSyntaxHighlighter.ATS_NUMBER),
                AttributesDescriptor("Operators", ATSSyntaxHighlighter.ATS_OPERATION_SIGN),
                AttributesDescriptor("Parentheses", ATSSyntaxHighlighter.ATS_PARENTHESES),
                AttributesDescriptor("Semicolons", ATSSyntaxHighlighter.ATS_SEMICOLON),
                AttributesDescriptor("Strings", ATSSyntaxHighlighter.ATS_STRING),
                AttributesDescriptor("Type declarations", ATSSyntaxHighlighter.ATS_TYPE_DECLARATIONS),
                AttributesDescriptor("Val, Fun declarations", ATSSyntaxHighlighter.ATS_VAL_DECLARATIONS)
        )
    }
}
