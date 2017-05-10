package com.atslangplugin.psi;

import com.atslangplugin.ATSFileTypeDynamic;
import com.atslangplugin.ATSFileTypeInclude;
import com.atslangplugin.ATSFileTypeStatic;
import com.atslangplugin.ATSLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.vfs.InvalidVirtualFileAccessException;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class ATSFile extends PsiFileBase {

    public ATSFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ATSLanguage.INSTANCE);

        String extension = "";
        int i = this.getName().lastIndexOf('.');
        if (i > 0) {
            extension = this.getName().substring(i + 1);
        }
        switch (extension) {
            case "dats":
                myFileTypeInstance = ATSFileTypeDynamic.Companion.getINSTANCE();
                break;
            case "sats":
                myFileTypeInstance = ATSFileTypeStatic.Companion.getINSTANCE();
                break;
            case "hats":
                myFileTypeInstance = ATSFileTypeInclude.Companion.getINSTANCE();
                break;
            default:
                // This is probably not exactly what we need:
                throw new InvalidVirtualFileAccessException(this.getName());
        }
    }

    private LanguageFileType myFileTypeInstance;

    @NotNull
    @Override
    public FileType getFileType() {
        return myFileTypeInstance;
    }

    @Override
    public String toString() {
        return myFileTypeInstance.getName();
    }


}
