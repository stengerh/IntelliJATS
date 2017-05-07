package com.atslangplugin

import com.intellij.lexer.FlexAdapter

import java.io.Reader


class ATSLexerAdapter : FlexAdapter(ATSLexer(null as Reader?)) {

    private var myFlex: ATSLexer? = null

    init {
        myFlex = this.flex as ATSLexer
    }

    val yyline: Int
        get() = myFlex!!.yyline
    val yycolumn: Int
        get() = myFlex!!.yycolumn
}
