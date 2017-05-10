package com.atslangplugin

import com.intellij.openapi.fileTypes.ExtensionFileNameMatcher
import com.intellij.openapi.fileTypes.FileNameMatcher
import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import java.util.*


class ATSFileTypeFactory : FileTypeFactory() {

    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        val matcherList = ArrayList<FileNameMatcher>()

        //dats
        matcherList.add(ExtensionFileNameMatcher(ATSFileTypeDynamic.INSTANCE.defaultExtension))
        //sats
        matcherList.add(ExtensionFileNameMatcher(ATSFileTypeStatic.INSTANCE.defaultExtension))
        //hats
        matcherList.add(ExtensionFileNameMatcher(ATSFileTypeInclude.INSTANCE.defaultExtension))

        //TODO: these should be properly separate classes, rather than instances of the same class?
        fileTypeConsumer.consume(ATSFileTypeDynamic.INSTANCE,
                *matcherList.toTypedArray())
        matcherList.clear()
        // Could now include support for other file matching procedures,
        // like exact file names
    }
}
