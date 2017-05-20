package com.atslangplugin.psi

import com.atslangplugin.ATSLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls


class ATSTokenType(@NonNls debugName: String) : IElementType(debugName, ATSLanguage) {
    override fun toString(): String {
        return "ATSTokenType." + super.toString()
    }
}


sealed class CreateSubscriptionResult {
    class Success(val subscription: Int): CreateSubscriptionResult()
    class Failure(val errors: List<String>): CreateSubscriptionResult()
}