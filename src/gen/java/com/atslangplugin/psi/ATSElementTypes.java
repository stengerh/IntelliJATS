// This is a generated file. Not intended for manual editing.
package com.atslangplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.atslangplugin.psi.impl.*;

public interface ATSElementTypes {

  IElementType DUMMY = new ATSElementType("DUMMY");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == DUMMY) {
        return new ATSDummyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
