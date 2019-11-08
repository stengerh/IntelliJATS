package com.atslangplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon


object ATSFileTypeStatic : LanguageFileType(ATSLanguage) {

    override fun getName(): String {
        return "sats file"
    }

    override fun getDescription(): String {
        return "Applied Type System (ATS) Static Files"
    }

    override fun getDefaultExtension(): String {
        return "sats"
    }

    override fun getIcon(): Icon? {
        return ATSIcons.FILE
    }
}
