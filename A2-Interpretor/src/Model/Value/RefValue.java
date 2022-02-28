package Model.Value;

import Model.Types.IType;
import Model.Types.RefType;


public class RefValue implements IValue{
    int address;
    IType locationType;

    public RefValue(int add, IType loc){
        this.address = add;
        this.locationType = loc;
    }
    public int getAddress(){return this.address;}
    public IType getType(){return new RefType(locationType);}
    public String toString(){return "("+ Integer.toString(address) + " ," + locationType.toString() +")";}
}
