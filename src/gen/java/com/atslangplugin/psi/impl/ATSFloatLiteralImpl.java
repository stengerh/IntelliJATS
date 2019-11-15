// This is a generated file. Not intended for manual editing.
package com.atslangplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.atslangplugin.psi.ATSElementTypes.*;
import com.atslangplugin.psi.*;

public class ATSFloatLiteralImpl extends ATSLiteralImpl implements ATSFloatLiteral {

  public ATSFloatLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ATSVisitor visitor) {
    visitor.visitFloatLiteral(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ATSVisitor) accept((ATSVisitor)visitor);
    else super.accept(visitor);
  }

}
