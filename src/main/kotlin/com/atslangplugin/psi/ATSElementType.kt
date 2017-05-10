package com.atslangplugin.psi

import com.atslangplugin.ATSLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls


class ATSElementType(@NonNls debugName: String) : IElementType(debugName, ATSLanguage)
