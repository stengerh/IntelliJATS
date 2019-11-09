package com.atslangplugin

import com.intellij.openapi.fileTypes.LanguageFileType

import javax.swing.*

object ATSFileTypeInclude : LanguageFileType(ATSLanguage) {

    override fun getName(): String {
        return "hats file"
    }

    override fun getDescription(): String {
        return "Applied Type System (ATS) Include Files"
    }

    override fun getDefaultExtension(): String {
        return "hats"
    }

    override fun getIcon(): Icon? {
        return ATSIcons.INCLUDE_FILE
    }
}
