/* This file was generated by SableCC ( http://sablecc.org ). */

package language_mpire;

public class NStmt_Printstr
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$0 e$0;
  private final NStr eStr;

  @Override
  public int getLine() {
    return this.line;
  }

  @Override
  public int getPos() {
    return this.pos;
  }

  @Override
  public String getText() {
    return null;
  }

  @Override
  public void apply(Walker walker) {
    walker.inStmt_Printstr(this);
    walker.caseStmt_Printstr(this);
    walker.outStmt_Printstr(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$0.apply(walker);
    this.eStr.apply(walker);
  }

  NStmt_Printstr(int line, int pos, N$0 p$0, NStr pStr) {
    this.line = line;
    this.pos = pos;
    this.e$0 = p$0;
    this.eStr = pStr;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Printstr;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Printstr;
  }

  public NStr get_Str() {
    return this.eStr;
  }

  N$0 internalGet$0() {
    return this.e$0;
  }

  NStr internalGetStr() {
    return this.eStr;
  }
}