package Model.Statements;

import Exceptions.DivByZeroException;
import Exceptions.WrongOpException;
import Model.ADT.IMyDict;
import Model.ADT.MyDict;
import Model.Expressions.IExpression;
import Model.PrgState;
import Model.Types.IType;

import java.lang.reflect.Type;

public class PrintStmt implements IStmt{
    IExpression exp;
    public PrintStmt(IExpression e){this.exp = e;}
    @Override
    public String toString(){return  "print(" +exp.toString()+")";}
    public PrgState execute(PrgState state) throws DivByZeroException, WrongOpException {
        //check
        state.getOut().add(exp.eval(state.getSymTable(), state.getHeap()).toString());
        return null;
    }
    public IMyDict<String, IType> typecheck(IMyDict<String, IType> typeEnv) throws Exception{
        exp.typecheck(typeEnv);
        return typeEnv;
    }
}








