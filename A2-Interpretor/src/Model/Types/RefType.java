package Model.Types;
import Model.Value.IValue;
import Model.Value.RefValue;

public class RefType implements IType {
    IType inner;
    static int address = 1;
    public RefType(IType t){
        this.inner = t;
    }

    public IType getInner(){return this.inner;}

    @Override
    public boolean equals(Object o){
        if(o instanceof RefType)
            return inner.equals(((RefType) o).getInner());
        else return false;
    }

    public String toString(){return "Ref(" +inner.toString()+")";}
    public IValue defaultValue() { return new RefValue(address++,inner);}

}
