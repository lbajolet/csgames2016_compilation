/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.intermediate.syntax3.node;

import org.sablecc.sablecc.intermediate.syntax3.analysis.*;

@SuppressWarnings("nls")
public final class TParserInvestigatorKeyword extends Token
{
    public TParserInvestigatorKeyword()
    {
        super.setText("parser_investigator");
    }

    public TParserInvestigatorKeyword(int line, int pos)
    {
        super.setText("parser_investigator");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TParserInvestigatorKeyword(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTParserInvestigatorKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TParserInvestigatorKeyword text.");
    }
}