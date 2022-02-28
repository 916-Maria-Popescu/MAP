package Model.Statements;
import Exceptions.DivByZeroException;
import Exceptions.WrongOpException;
import Model.ADT.IMyStack;
import Model.Expressions.IExpression;
import Model.PrgState;
import Model.Value.BoolValue;

public class WhileStmt implements IStmt{
    IExpression exp;
    IStmt doStmt;

    public WhileStmt(IExpression exp1, IStmt doStmt1){
        this.exp = exp1;
        this.doStmt = doStmt1;
    }

    @Override
    public PrgState execute(PrgState prg) throws DivByZeroException, WrongOpException {

        IMyStack<IStmt> stk = prg.getStk();
            BoolValue bool = (BoolValue) exp.eval(prg.getSymTable(), prg.getHeap());
            if(bool.getValue()){
                stk.push(this);
                stk.push(doStmt);
            }

        return null;
    }

    @Override
    public String toString(){
        String s = "while ( " + exp.toString() + " ) " + doStmt.toString();
        return s;
    }
}


