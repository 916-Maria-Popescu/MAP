package Model.Statements;
import Exceptions.DivByZeroException;
import Exceptions.WrongOpException;
import Model.ADT.IMyDict;
import Model.ADT.IMyHeap;
import Model.Expressions.IExpression;
import Model.PrgState;
import Model.Types.BoolType;
import Model.Types.IType;
import Model.Value.IValue;
import Model.Value.IntValue;
import Model.Value.RefValue;

public class writeHeap implements IStmt{
    String name;
    IExpression expression;

    public writeHeap(String n, IExpression e){
        this.name = n;
        this.expression = e;
    }
    public IMyDict<String, IType> typecheck(IMyDict<String, IType> typeEnv) throws Exception{
        expression.typecheck(typeEnv);
        return typeEnv;
    }

    @Override
    public PrgState execute(PrgState prg) throws WrongOpException, DivByZeroException {
        IMyDict<String, IValue> symTable= prg.getSymTable();
        IMyHeap<IValue> heap = prg.getHeap();
        //check for exception
        IValue val = expression.eval(symTable, heap);
        IValue val_sym = symTable.lookUp(name);
        RefValue ref_val = (RefValue) val_sym;
        heap.update(ref_val.getAddress(), val);
        return null;
    }

    @Override
    public String toString(){
        String s = "";
        s += "heapWrite ( " + name + ", " + expression.toString() + " ) ";
        return s;
    }



}
