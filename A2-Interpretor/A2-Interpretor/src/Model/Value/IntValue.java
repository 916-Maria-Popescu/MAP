package Model.Value;

import Model.Types.IType;
import Model.Types.IntType;

public class IntValue implements IValue{
    int value;

    public IntValue(){this.value = 0;}
    public IntValue(int v){this.value = v;}

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != this.getClass())
            return false;
        IntValue o_value = (IntValue) o;
        return o_value.value == this.value;
    }

    @Override
    public String toString(){return Integer.toString(this.value);}

    @Override
    public IType getType(){return new IntType();}


    public int getValue(){return this.value;}


    public IValue deepCopy(){return new IntValue(this.value);}
}
