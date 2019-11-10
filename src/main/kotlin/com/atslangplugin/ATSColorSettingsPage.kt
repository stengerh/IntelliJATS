package com.atslangplugin


import com.atslangplugin.ATSBundle.message
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon


class ATSColorSettingsPage : ColorSettingsPage {

    override fun getIcon(): Icon? {
        return ATSIcons.LOGO
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
        return message("options.display.name");
    }

    companion object {
        private val DESCRIPTORS = arrayOf(
                AttributesDescriptor(message("options.attribute.descriptor.comment.block"), ATSSyntaxHighlighter.ATS_BLOCK_COMMENT),
                AttributesDescriptor(message("options.attribute.descriptor.comment.doc"), ATSSyntaxHighlighter.ATS_DOC_COMMENT),
                AttributesDescriptor(message("options.attribute.descriptor.comment.line"), ATSSyntaxHighlighter.ATS_LINE_COMMENT),
                AttributesDescriptor(message("options.attribute.descriptor.comment.rest"), ATSSyntaxHighlighter.ATS_REST_COMMENT),
                AttributesDescriptor(message("options.attribute.descriptor.braces"), ATSSyntaxHighlighter.ATS_BRACES),
                AttributesDescriptor(message("options.attribute.descriptor.brackets"), ATSSyntaxHighlighter.ATS_BRACKETS),
                AttributesDescriptor(message("options.attribute.descriptor.comma"), ATSSyntaxHighlighter.ATS_COMMA),
                AttributesDescriptor(message("options.attribute.descriptor.directive"), ATSSyntaxHighlighter.ATS_DIRECTIVES),
                AttributesDescriptor(message("options.attribute.descriptor.identifier"), ATSSyntaxHighlighter.ATS_IDENTIFIER),
                AttributesDescriptor(message("options.attribute.descriptor.keyword"), ATSSyntaxHighlighter.ATS_KEYWORD),
                AttributesDescriptor(message("options.attribute.descriptor.variable"), ATSSyntaxHighlighter.ATS_LOCAL_VARIABLE),
                AttributesDescriptor(message("options.attribute.descriptor.number"), ATSSyntaxHighlighter.ATS_NUMBER),
                AttributesDescriptor(message("options.attribute.descriptor.operator"), ATSSyntaxHighlighter.ATS_OPERATION_SIGN),
                AttributesDescriptor(message("options.attribute.descriptor.parentheses"), ATSSyntaxHighlighter.ATS_PARENTHESES),
                AttributesDescriptor(message("options.attribute.descriptor.semicolon"), ATSSyntaxHighlighter.ATS_SEMICOLON),
                AttributesDescriptor(message("options.attribute.descriptor.string"), ATSSyntaxHighlighter.ATS_STRING),
                AttributesDescriptor(message("options.attribute.descriptor.declaration.type"), ATSSyntaxHighlighter.ATS_TYPE_DECLARATIONS),
                AttributesDescriptor(message("options.attribute.descriptor.declaration.val"), ATSSyntaxHighlighter.ATS_VAL_DECLARATIONS)
        )
    }
}
