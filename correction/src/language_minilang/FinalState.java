/* This file was generated by SableCC ( http://sablecc.org ). */

package language_minilang;

abstract class FinalState
    extends State {

  abstract Token getToken(Lexer lexer);

  StateType getStateType() {
    return State.StateType.FINAL;
  }
}
