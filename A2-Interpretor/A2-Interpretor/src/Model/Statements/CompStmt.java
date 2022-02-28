package Model.Statements;

import Model.ADT.IMyStack;
import Model.PrgState;

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

    public String toString(){
        return "("+first.toString() + ";" + second.toString()+")";
    }
}
