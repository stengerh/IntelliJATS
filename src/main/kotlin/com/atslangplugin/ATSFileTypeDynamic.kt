package com.atslangplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon


object ATSFileTypeDynamic : LanguageFileType(ATSLanguage) {

    override fun getName(): String {
        return "dats file"
    }

    override fun getDescription(): String {
        return "Applied Type System (ATS) Dynamic Files"
    }

    override fun getDefaultExtension(): String {
        return "dats"
    }

    override fun getIcon(): Icon? {
        return ATSIcons.DYNAMIC_FILE
    }
}
