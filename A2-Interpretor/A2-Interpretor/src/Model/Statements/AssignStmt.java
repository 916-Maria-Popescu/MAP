package Model.Statements;

import Exceptions.DictException;
import Exceptions.DivByZeroException;
import Exceptions.NotDefinedException;
import Exceptions.WrongOpException;
import Model.ADT.IMyDict;
import Model.ADT.IMyHeap;
import Model.ADT.IMyStack;
import Model.Expressions.IExpression;
import Model.PrgState;
import Model.Types.IType;
import Model.Types.IntType;
import Model.Value.IValue;

public class AssignStmt implements IStmt{

    String id;
    IExpression exp;

    public AssignStmt(String i, IExpression e){this.id = i; this.exp = e;}

    @Override
    public String toString(){return this.id + "=" + this.exp.toString()+";";}

    @Override
    public PrgState execute(PrgState state) throws WrongOpException, NotDefinedException, DictException, DivByZeroException {
        IMyStack<IStmt> stk = state.getStk();
        IMyDict<String, IValue> symTable = state.getSymTable();
        IMyHeap<IValue> heap = state.getHeap();


        if(symTable.isDefined(id)){
            IValue v = exp.eval(symTable, heap);
            IType t = (symTable.lookUp(id).getType());
            if(v.getType().equals(t)) symTable.update(id, v);
            else throw new WrongOpException("the types of the variables do not match");
        }
        else throw new NotDefinedException("The elem is not defined in the symbol table");

        return null;
    }

}
