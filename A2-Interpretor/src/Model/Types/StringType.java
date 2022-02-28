package Model.Types;

import Model.Value.IValue;
import Model.Value.StringValue;

public class StringType implements IType{
    @Override

    public IValue defaultValue(){ return new StringValue();}
    public IType deepCopy(){return new StringType();}
}
