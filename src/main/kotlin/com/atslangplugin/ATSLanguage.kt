package com.atslangplugin


import com.intellij.lang.Language


class ATSLanguage private constructor() : Language("ATS") {
    companion object {
        val INSTANCE = ATSLanguage()
    }
}
