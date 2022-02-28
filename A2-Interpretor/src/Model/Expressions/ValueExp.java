package Model.Expressions;

import Model.ADT.IMyDict;
import Model.ADT.IMyHeap;
import Model.Types.IType;
import Model.Value.IValue;

public class ValueExp implements  IExpression{
    IValue v;
    public ValueExp(IValue value){this.v = value;}

    public IValue eval(IMyDict<String, IValue> tbl, IMyHeap<IValue> heap){
        return v;
    }
    public IType typecheck(IMyDict<String, IType> typeEnv) throws Exception{
        return v.getType();
    }
    @Override
    public String toString(){return String.format("%s",v.toString());}
}
