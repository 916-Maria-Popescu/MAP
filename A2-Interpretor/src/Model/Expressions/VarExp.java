package Model.Expressions;

import Model.ADT.IMyDict;
import Model.ADT.IMyHeap;
import Model.Types.IType;
import Model.Value.IValue;
import Model.Value.IntValue;

public class VarExp implements IExpression{
    String id;
    public VarExp(String id){
        this.id = id;
    }
    public IType typecheck(IMyDict<String, IType> typeEnv) throws Exception{
        return typeEnv.lookUp(id);
    }
    public IValue eval(IMyDict<String, IValue> tbl, IMyHeap<IValue> heap){
        return tbl.lookUp(id);
    }
    public String toString() {return id;}
}
