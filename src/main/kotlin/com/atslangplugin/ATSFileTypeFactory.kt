package com.atslangplugin

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.fileTypes.*

import java.util.ArrayList


class ATSFileTypeFactory : FileTypeFactory() {

    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        val matcherList = ArrayList<FileNameMatcher>()

        val ATSSourceExtensions = ArrayList<String>(3)
        ATSSourceExtensions.add(0, ATSFileTypeDynamic.INSTANCE.defaultExtension)
        ATSSourceExtensions.add(1, ATSFileTypeStatic.INSTANCE.defaultExtension)
        ATSSourceExtensions.add(2, ATSFileTypeInclude.INSTANCE.defaultExtension)

        for (s in ATSSourceExtensions) {
            matcherList.add(ExtensionFileNameMatcher(s))
        }

        fileTypeConsumer.consume(ATSFileTypeDynamic.INSTANCE,
                *matcherList.toTypedArray())
        matcherList.clear()
        // Could now include support for other file matching procedures,
        // like exact file names
    }
}