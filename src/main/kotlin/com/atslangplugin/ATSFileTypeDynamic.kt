package com.atslangplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.NonNls
import javax.swing.Icon


object ATSFileTypeDynamic : LanguageFileType(ATSLanguage) {

    @NonNls
    override fun getName(): String {
        return "dats file"
    }

    override fun getDescription(): String {
        return ATSBundle.message("filetype.dats.description")
    }

    @NonNls
    override fun getDefaultExtension(): String {
        return "dats"
    }

    override fun getIcon(): Icon? {
        return ATSIcons.DYNAMIC_FILE
    }
}
