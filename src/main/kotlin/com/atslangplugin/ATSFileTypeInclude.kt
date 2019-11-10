package com.atslangplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.NonNls

import javax.swing.*

object ATSFileTypeInclude : LanguageFileType(ATSLanguage) {

    @NonNls
    override fun getName(): String {
        return "hats file"
    }

    override fun getDescription(): String {
        return ATSBundle.message("filetype.hats.description")
    }

    @NonNls
    override fun getDefaultExtension(): String {
        return "hats"
    }

    override fun getIcon(): Icon? {
        return ATSIcons.INCLUDE_FILE
    }
}
