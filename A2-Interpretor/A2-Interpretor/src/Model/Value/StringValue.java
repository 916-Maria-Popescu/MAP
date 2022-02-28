package Model.Value;

import Model.Types.IType;
import Model.Types.StringType;

import java.util.Objects;

public class StringValue implements IValue{
    String str;
    public StringValue(String str){this.str = str;}
    public StringValue(){this.str = "";}

    @Override
    public boolean equals(Object o){

        if(o == null || o.getClass() != this.getClass())
            return false;
        StringValue o_str = (StringValue) o;
        return Objects.equals(o_str.str, this.str);
    }

    @Override
    public IType getType(){return new StringType();}

    public String getValue(){return this.str;}

    //@Override
    public IValue deepCopy(){return new StringValue(this.str);}
}
