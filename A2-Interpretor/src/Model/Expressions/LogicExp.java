package Model.Expressions;

import Exceptions.DivByZeroException;
import Exceptions.WrongOpException;
import Model.ADT.IMyDict;
import Model.ADT.IMyHeap;
import Model.Types.BoolType;
import Model.Types.IType;
import Model.Types.IntType;
import Model.Value.BoolValue;
import Model.Value.IValue;


public class LogicExp implements IExpression{
    IExpression e1, e2;
    int op;
    //1 = &&, 2 = ||, 3 = !
    public IValue eval(IMyDict<String, IValue> symTbl, IMyHeap<IValue> heap) throws WrongOpException, DivByZeroException{
        IValue v1, v2;
        v1=e1.eval(symTbl, heap);
        if(v1.getType().equals(new BoolType())){
            v2 = e2.eval(symTbl, heap);
            if(v2.getType().equals(new BoolType())){
                BoolValue b1 = (BoolValue) v1;
                BoolValue b2 = (BoolValue) v2;
                boolean n1,n2;
                n1=b1.getValue();
                n2=b2.getValue();
                if(op==1) return new BoolValue(n1 && n2);
                if(op==2) return new BoolValue(n1||n2);
            }
            else throw new WrongOpException("second op is not a boolean");
        }
        else throw new WrongOpException("second op is not a boolean");
        return v1;
    }

    public IType typecheck(IMyDict<String, IType> typeEnv) throws Exception{
        IType t1, t2;
        t1 = e1.typecheck(typeEnv);
        t2 = e2.typecheck(typeEnv);
        if (t1.equals(new BoolType())){
            if (t2.equals(new BoolType())){
                return new BoolType();
            }
            else throw new WrongOpException("second op is not a boolean");

        }
        else throw  new WrongOpException("first op is not a boolean");

    }

    @Override
    public String toString(){
        if(op==1) return e1.toString() + " and " + e2.toString();
        return e2.toString() + " or " + e2.toString();
    }


}
