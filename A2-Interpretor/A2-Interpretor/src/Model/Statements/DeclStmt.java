package Model.Statements;

import Exceptions.DictException;
import Model.ADT.IMyDict;
import Model.PrgState;
import Model.Types.IType;
import Model.Value.IValue;

public class DeclStmt implements  IStmt{
    String id;
    IType t;

    public DeclStmt(String n, IType ty){this.id = n; this.t = ty;}

    @Override
    public String toString(){return String.format("%s %s;",t.toString(),id);}
    @Override
    public PrgState execute(PrgState state) throws DictException {
        IMyDict<String, IValue> symTable = state.getSymTable();
        if (!symTable.isDefined(id)){
            symTable.add(id,t.defaultValue());
            return null;
        }
        throw new DictException("already declared in the symbols table");
    }
}
