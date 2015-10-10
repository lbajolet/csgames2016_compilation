/* This file was generated by SableCC ( http://sablecc.org ). */

package language_minilang;

public class NEa_Par
    extends NEa {

  private final int line;
  private final int pos;
  private final N$4 e$4;
  private final NE eE;
  private final N$5 e$5;

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
    walker.inEa_Par(this);
    walker.caseEa_Par(this);
    walker.outEa_Par(this);
  }

  @Override
  public void applyOnChildren(Walker walker) {
    this.e$4.apply(walker);
    this.eE.apply(walker);
    this.e$5.apply(walker);
  }

  NEa_Par(int line, int pos, N$4 p$4, NE pE, N$5 p$5) {
    this.line = line;
    this.pos = pos;
    this.e$4 = p$4;
    this.eE = pE;
    this.e$5 = p$5;
  }

  @Override
  public Type getType() {
    return Type.T_Ea_Par;
  }

  @Override
  public ProductionType getProductionType() {
    return ProductionType.T_Ea;
  }

  @Override
  InternalType getInternalType() {
    return InternalType.T_Ea_Par;
  }

  public NE get_E() {
    return this.eE;
  }

  N$4 internalGet$4() {
    return this.e$4;
  }

  NE internalGetE() {
    return this.eE;
  }

  N$5 internalGet$5() {
    return this.e$5;
  }
}
