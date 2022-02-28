package Model.Types;

import Model.Value.BoolValue;
import Model.Value.IValue;

public class BoolType implements IType{

    @Override
    public IValue defaultValue(){return new BoolValue(false);}

    //@Override
    public IType deepCopy() {return new BoolType();}

    @Override
    public boolean equals(Object o){return o != null && o.getClass() == this.getClass();}

    @Override
    public String toString(){return "bool";}
}
