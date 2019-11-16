// This is a generated file. Not intended for manual editing.
package com.atslangplugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class ATSVisitor extends PsiElementVisitor {

  public void visitCharLiteral(@NotNull ATSCharLiteral o) {
    visitLiteral(o);
  }

  public void visitDummy(@NotNull ATSDummy o) {
    visitPsiElement(o);
  }

  public void visitExternalCode(@NotNull ATSExternalCode o) {
    visitPsiElement(o);
  }

  public void visitFloatLiteral(@NotNull ATSFloatLiteral o) {
    visitLiteral(o);
  }

  public void visitIntLiteral(@NotNull ATSIntLiteral o) {
    visitLiteral(o);
  }

  public void visitLiteral(@NotNull ATSLiteral o) {
    visitPsiElement(o);
  }

  public void visitStringLiteral(@NotNull ATSStringLiteral o) {
    visitLiteral(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
