/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.objectmacro.syntax3.node;

import java.util.*;
import org.sablecc.objectmacro.syntax3.analysis.*;

@SuppressWarnings("nls")
public final class ATextInsert extends PTextInsert
{
    private TIdentifier _name_;
    private final LinkedList<PStaticValue> _staticValues_ = new LinkedList<PStaticValue>();

    public ATextInsert()
    {
        // Constructor
    }

    public ATextInsert(
        @SuppressWarnings("hiding") TIdentifier _name_,
        @SuppressWarnings("hiding") List<PStaticValue> _staticValues_)
    {
        // Constructor
        setName(_name_);

        setStaticValues(_staticValues_);

    }

    @Override
    public Object clone()
    {
        return new ATextInsert(
            cloneNode(this._name_),
            cloneList(this._staticValues_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATextInsert(this);
    }

    public TIdentifier getName()
    {
        return this._name_;
    }

    public void setName(TIdentifier node)
    {
        if(this._name_ != null)
        {
            this._name_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._name_ = node;
    }

    public LinkedList<PStaticValue> getStaticValues()
    {
        return this._staticValues_;
    }

    public void setStaticValues(List<PStaticValue> list)
    {
        this._staticValues_.clear();
        this._staticValues_.addAll(list);
        for(PStaticValue e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._name_)
            + toString(this._staticValues_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._name_ == child)
        {
            this._name_ = null;
            return;
        }

        if(this._staticValues_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._name_ == oldChild)
        {
            setName((TIdentifier) newChild);
            return;
        }

        for(ListIterator<PStaticValue> i = this._staticValues_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PStaticValue) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}