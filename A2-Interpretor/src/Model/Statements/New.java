package Model.Statements;
import Exceptions.DivByZeroException;
import Exceptions.WrongOpException;
import Model.ADT.IMyDict;
import Model.ADT.IMyHeap;
import Model.Expressions.IExpression;
import Model.PrgState;
import Model.Types.IType;
import Model.Types.RefType;
import Model.Value.IValue;

public class New implements IStmt{
    IExpression expression;
    String variable;

    public New(IExpression e, String s){
        this.expression =e;
        this.variable = s;
    }
    @Override
    public PrgState execute(PrgState prg) throws DivByZeroException, WrongOpException {
        IMyDict<String, IValue> symTable = prg.getSymTable();
        IMyHeap<IValue> heap = prg.getHeap();
        if(!symTable.isDefined(this.variable)){
            throw new WrongOpException("Exception on New Stmt: variable not defined!");
        }
        IValue var_value = symTable.lookUp(this.variable);
        if(!(var_value.getType() instanceof RefType)){
            throw new WrongOpException("Exception on New Stmt: value type is not RefType!");
        }
        //check if the type of th exp is the same as the locationType from var
        IValue expr_value = expression.eval(symTable, heap);
        //if(expr_value.getType()){
        //    throw new WrongOpException("Exception on New Stmt: type of the exp is not the same as the type from the location");
        //}
        heap.allocate(expr_value);
        return null;
    }

    public IMyDict<String, IType> typecheck(IMyDict<String, IType> typeEnv) throws Exception{
        expression.typecheck(typeEnv);
        return typeEnv;
    }
    @Override
    public String toString(){
        String s = "";
        s += "new ( " + variable + "," + expression.toString() + ")";
        return s;
    }

}
