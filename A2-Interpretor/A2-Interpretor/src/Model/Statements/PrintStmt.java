package Model.Statements;

import Exceptions.DivByZeroException;
import Exceptions.WrongOpException;
import Model.Expressions.IExpression;
import Model.PrgState;

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
}
