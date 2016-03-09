/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.intermediate.syntax3.node;

import org.sablecc.sablecc.intermediate.syntax3.analysis.*;

@SuppressWarnings("nls")
public final class AAcceptLexerAction extends PLexerAction
{
    private TString _token_;

    public AAcceptLexerAction()
    {
        // Constructor
    }

    public AAcceptLexerAction(
        @SuppressWarnings("hiding") TString _token_)
    {
        // Constructor
        setToken(_token_);

    }

    @Override
    public Object clone()
    {
        return new AAcceptLexerAction(
            cloneNode(this._token_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAcceptLexerAction(this);
    }

    public TString getToken()
    {
        return this._token_;
    }

    public void setToken(TString node)
    {
        if(this._token_ != null)
        {
            this._token_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._token_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._token_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._token_ == child)
        {
            this._token_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._token_ == oldChild)
        {
            setToken((TString) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}