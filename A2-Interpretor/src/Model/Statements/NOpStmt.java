package Model.Statements;

import Model.ADT.IMyDict;
import Model.PrgState;
import Model.Types.IType;

public class NOpStmt implements IStmt{

    @Override
    public String toString(){
        return "no operation";
    }
    public PrgState execute(PrgState state){return null;}
    public IMyDict<String, IType> typecheck(IMyDict<String, IType> typeEnv) throws Exception{

        return typeEnv;
    }
}
