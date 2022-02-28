package Model.Statements;

import Model.ADT.IMyDict;
import Model.ADT.IMyStack;
import Model.ADT.MyStack;
import Model.PrgState;
import Model.Types.IType;

public class ForkStmt implements IStmt{
    private IStmt stmt;
    public ForkStmt(IStmt stmt){this.stmt = stmt;}
    @Override
    public PrgState execute(PrgState state){
        PrgState forkProgram = new PrgState(state.getId()*10, new MyStack<>(), state.getSymTable().clone(), state.getOut(),state.getFileTable(), state.getHeap(), this.stmt);
        forkProgram.getStk().push(this.stmt);
        return forkProgram;
    }
    public IMyDict<String, IType> typecheck(IMyDict<String, IType> typeEnv) throws Exception{
        return stmt.typecheck(typeEnv);
    }

    @Override
    public String toString() {
        return "fork(" + this.stmt.toString() + ")";
    }

}
