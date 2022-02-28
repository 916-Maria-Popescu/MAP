package Model.Statements;

import Exceptions.DivByZeroException;
import Exceptions.WrongOpException;
import Model.Expressions.IExpression;
import Model.PrgState;
import Model.Types.BoolType;
import Model.Value.BoolValue;
import Model.Value.IValue;


public class IfStmt implements IStmt{
    IExpression exp;
    IStmt thenS;
    IStmt elseS;

    public IfStmt(IExpression s, IStmt s1, IStmt s2){
        this.exp = s;
        this.thenS = s1;
        this.elseS = s2;
    }

    @Override
    public String toString(){
        return "(IF("+ exp.toString()+") THEN(" +thenS.toString()
                +")ELSE("+elseS.toString()+"))";
    }

    public PrgState execute(PrgState state) throws WrongOpException, DivByZeroException {
        IValue value = exp.eval(state.getSymTable(), state.getHeap());
        if(value.getType().equals(new BoolType())){
            BoolValue check = (BoolValue) value;
            if(check.getValue()) state.getStk().push(thenS);
            else state.getStk().push(elseS);

            return null;
        }
        else
            throw new WrongOpException("no boolean");
    }
}
