package Model.Statements;

import Model.ADT.IMyDict;
import Model.ADT.IMyStack;
import Model.PrgState;
import Model.Types.IType;

public class CompStmt implements IStmt{
    IStmt first;
    IStmt second;

    public CompStmt(IStmt s1, IStmt s2){first = s1;second = s2;}
    public PrgState execute(PrgState state){
        IMyStack<IStmt> stk = state.getStk();
        stk.push(second);
        stk.push(first);
        return null;
    }
    public IMyDict<String, IType> typecheck(IMyDict<String, IType> typeEnv) throws Exception{
        return second.typecheck(first.typecheck(typeEnv));
    }

    public String toString(){
        return "("+first.toString() + ";" + second.toString()+")";
    }
}
