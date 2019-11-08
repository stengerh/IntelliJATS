package com.atslangplugin.psi.impl

import com.atslangplugin.ATSFileTypeDynamic
import com.atslangplugin.ATSFileTypeInclude
import com.atslangplugin.ATSFileTypeStatic
import com.atslangplugin.ATSLanguage
import com.atslangplugin.psi.ATSFile
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.InvalidVirtualFileAccessException
import com.intellij.psi.FileViewProvider

class ATSFileImpl(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ATSLanguage), ATSFile {

    private var myFileTypeInstance: LanguageFileType

    init {

        var extension = ""
        val i = this.name.lastIndexOf('.')
        if (i > 0) {
            extension = this.name.substring(i + 1)
        }
        when (extension) {
            "dats" -> myFileTypeInstance = ATSFileTypeDynamic.INSTANCE
            "sats" -> myFileTypeInstance = ATSFileTypeStatic.INSTANCE
            "hats" -> myFileTypeInstance = ATSFileTypeInclude.INSTANCE
            else ->
                // This is probably not exactly what we need:
                throw InvalidVirtualFileAccessException(this.name)
        }
    }

    override fun getFileType(): FileType {
        return myFileTypeInstance
    }

    override fun toString(): String {
        return myFileTypeInstance.name
    }


}
