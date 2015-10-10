/* This file was generated by SableCC ( http://sablecc.org ). */

package language_mpire;

public class NStmt_Stmts
    extends NStmt {

  private final int line;
  private final int pos;
  private final N$1 e$1;
  private final NProg eProg;
  private final N$2 e$2;

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
    walker.inStmt_Stmts(this);
    walker.caseStmt_Stmts(this);
    walker.outStmt_Stmts(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$1.apply(walker);
    this.eProg.apply(walker);
    this.e$2.apply(walker);
  }

  NStmt_Stmts(int line, int pos, N$1 p$1, NProg pProg, N$2 p$2) {
    this.line = line;
    this.pos = pos;
    this.e$1 = p$1;
    this.eProg = pProg;
    this.e$2 = p$2;
  }

  @Override
  public Type getType() {
    return Type.T_Stmt_Stmts;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Stmt;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Stmt_Stmts;
  }

  public NProg get_Prog() {
    return this.eProg;
  }

  N$1 internalGet$1() {
    return this.e$1;
  }

  NProg internalGetProg() {
    return this.eProg;
  }

  N$2 internalGet$2() {
    return this.e$2;
  }
}
