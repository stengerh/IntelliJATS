package com.atslangplugin

import com.intellij.lang.Commenter


class ATSCommenter : Commenter {
    override fun getLineCommentPrefix(): String? {
        return "//"
    }

    override fun getBlockCommentPrefix(): String? {
        return "(*"
    }

    override fun getBlockCommentSuffix(): String? {
        return "*)"
    }

    //TODO: what are these?
    override fun getCommentedBlockCommentPrefix(): String? {
        return "/*"
    }

    override fun getCommentedBlockCommentSuffix(): String? {
        return "*/"
    }
}