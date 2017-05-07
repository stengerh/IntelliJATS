package com.atslangplugin

import com.intellij.openapi.fileTypes.LanguageFileType

import javax.swing.*


class ATSFileTypeDynamic private constructor() : LanguageFileType(ATSLanguage.INSTANCE) {

    override fun getName(): String {
        return "dats file"
    }

    override fun getDescription(): String {
        return "Dynamic Applied Type System (ATS) language file"
    }

    override fun getDefaultExtension(): String {
        return "dats"
    }

    override fun getIcon(): Icon? {
        return ATSIcons.FILE
    }

    companion object {
        val INSTANCE = ATSFileTypeDynamic()
    }
}
