package Model.Expressions;
import Exceptions.DivByZeroException;
import Exceptions.WrongOpException;
import Model.ADT.IMyDict;
import Model.ADT.IMyHeap;
import Model.Types.IntType;
import Model.Value.BoolValue;
import Model.Value.IValue;
import Model.Value.IntValue;

public class RelationalExp implements IExpression {
    IExpression e1;
    IExpression e2;
    String op;

    public RelationalExp(String s, IExpression ee1, IExpression ee2){
        op = s;
        e1 = ee1;
        e2 = ee2;
    }
    public IValue eval(IMyDict<String, IValue> tbl, IMyHeap<IValue> heap) throws DivByZeroException, WrongOpException {
        IValue v1, v2;
        v1 = e1.eval(tbl, heap);
        if(v1.getType().equals(new IntType())){
            v2 = e2.eval(tbl, heap);
            if(v2.getType().equals(new IntType())){
                IntValue i1 = (IntValue)v1;
                IntValue i2 = (IntValue)v2;
                int n1, n2;
                n1 = i1.getValue();
                n2 = i2.getValue();
                if(op.equals(">")) return new BoolValue(n1 > n2);
                if(op.equals(">=")) return  new BoolValue(n1 >= n2);
                if(op.equals("<")) return new BoolValue(n1<n2);
                if(op.equals("<=")) return new BoolValue(n1<=n2);
                if(op.equals("==")) return new BoolValue(n1==n2);
                if(op.equals("!=")) return new BoolValue(n1!=n2);
            }
            else
                throw new WrongOpException("second op s not an int");
        }
        else
            throw new WrongOpException("first op is not an int");
        //check
        return v1;
    }

    @Override
    public String toString(){
        if(op.equals(">")) return e1.toString() + " > " + e2.toString();
        if(op.equals(">=")) return e1.toString() + " >= " + e2.toString();
        if(op.equals("<=")) return e1.toString() + " <= " + e2.toString();
        if (op.equals("<")) return e1.toString() + " < " +e2.toString();
        if (op.equals("==")) return e1.toString() + " == " + e2.toString();
        if (op.equals("!=")) return e1.toString() + " != " + e2.toString();
        else return "";
    }
}
