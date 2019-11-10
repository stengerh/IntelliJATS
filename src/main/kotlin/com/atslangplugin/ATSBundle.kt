package com.atslangplugin

import com.intellij.CommonBundle
import com.intellij.reference.SoftReference
import org.jetbrains.annotations.PropertyKey
import java.lang.ref.Reference
import java.util.*

object ATSBundle {
    private const val BUNDLE = "messages.ATSBundle"

    private var bundleRef: Reference<ResourceBundle>? = null

    private fun bundle(): ResourceBundle {
        var bundle = SoftReference.dereference(bundleRef)
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(BUNDLE)
            bundleRef = SoftReference(bundle)
        }
        return bundle!!
    }

    fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any): String {
        return CommonBundle.message(bundle(), key, params)
    }
}