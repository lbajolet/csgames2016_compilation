/* This file was generated by SableCC ( http://sablecc.org ). */

package language_minilang;

public class Walker {

  public void inInt(NInt node) {
    defaultIn(node);
  }

  public void inStr(NStr node) {
    defaultIn(node);
  }

  public void inStmt_Print(NStmt_Print node) {
    defaultIn(node);
  }

  public void inStmt_Stmts(NStmt_Stmts node) {
    defaultIn(node);
  }

  public void inExpr_Int(NExpr_Int node) {
    defaultIn(node);
  }

  public void inExpr_Str(NExpr_Str node) {
    defaultIn(node);
  }

  public void defaultIn(Node node) {
  }

  public void caseInt(NInt node) {
    defaultCase(node);
  }

  public void caseStr(NStr node) {
    defaultCase(node);
  }

  public void caseStmt_Print(NStmt_Print node) {
    defaultCase(node);
  }

  public void caseStmt_Stmts(NStmt_Stmts node) {
    defaultCase(node);
  }

  public void caseExpr_Int(NExpr_Int node) {
    defaultCase(node);
  }

  public void caseExpr_Str(NExpr_Str node) {
    defaultCase(node);
  }

  public void defaultCase(Node node) {
    node.applyOnChildren(this);
  }

  public void outInt(NInt node) {
    defaultOut(node);
  }

  public void outStr(NStr node) {
    defaultOut(node);
  }

  public void outStmt_Print(NStmt_Print node) {
    defaultOut(node);
  }

  public void outStmt_Stmts(NStmt_Stmts node) {
    defaultOut(node);
  }

  public void outExpr_Int(NExpr_Int node) {
    defaultOut(node);
  }

  public void outExpr_Str(NExpr_Str node) {
    defaultOut(node);
  }

  public void defaultOut(Node node) {
  }
}