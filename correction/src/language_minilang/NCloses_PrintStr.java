/* This file was generated by SableCC ( http://sablecc.org ). */

package language_minilang;

public class NCloses_PrintStr
    extends NCloses {

  private final int line;
  private final int pos;
  private final N$1 e$1;
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
    walker.inCloses_PrintStr(this);
    walker.caseCloses_PrintStr(this);
    walker.outCloses_PrintStr(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$1.apply(walker);
    this.eStr.apply(walker);
  }

  NCloses_PrintStr(int line, int pos, N$1 p$1, NStr pStr) {
    this.line = line;
    this.pos = pos;
    this.e$1 = p$1;
    this.eStr = pStr;
  }

  @Override
  public Type getType() {
    return Type.T_Closes_PrintStr;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Closes;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Closes_PrintStr;
  }

  public NStr get_Str() {
    return this.eStr;
  }

  N$1 internalGet$1() {
    return this.e$1;
  }

  NStr internalGetStr() {
    return this.eStr;
  }
}
