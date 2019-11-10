package com.atslangplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.NonNls
import javax.swing.Icon


object ATSFileTypeStatic : LanguageFileType(ATSLanguage) {

    @NonNls
    override fun getName(): String {
        return "sats file"
    }

    override fun getDescription(): String {
        return ATSBundle.message("filetype.sats.description")
    }

    @NonNls
    override fun getDefaultExtension(): String {
        return "sats"
    }

    override fun getIcon(): Icon? {
        return ATSIcons.STATIC_FILE
    }
}
