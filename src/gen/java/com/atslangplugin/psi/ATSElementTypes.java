// This is a generated file. Not intended for manual editing.
package com.atslangplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.atslangplugin.psi.impl.*;

public interface ATSElementTypes {

  IElementType CHAR_LITERAL = new ATSElementType("CHAR_LITERAL");
  IElementType DUMMY = new ATSElementType("DUMMY");
  IElementType FLOAT_LITERAL = new ATSElementType("FLOAT_LITERAL");
  IElementType INT_LITERAL = new ATSElementType("INT_LITERAL");
  IElementType LITERAL = new ATSElementType("LITERAL");
  IElementType STRING_LITERAL = new ATSElementType("STRING_LITERAL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == CHAR_LITERAL) {
        return new ATSCharLiteralImpl(node);
      }
      else if (type == DUMMY) {
        return new ATSDummyImpl(node);
      }
      else if (type == FLOAT_LITERAL) {
        return new ATSFloatLiteralImpl(node);
      }
      else if (type == INT_LITERAL) {
        return new ATSIntLiteralImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new ATSStringLiteralImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
