package Model.Statements;

import Exceptions.DictException;
import Exceptions.DivByZeroException;
import Exceptions.WrongOpException;
import Model.ADT.IMyDict;
import Model.ADT.IMyHeap;
import Model.ADT.IMyStack;
import Model.Expressions.IExpression;
import Model.PrgState;
import Model.Types.IType;
import Model.Types.IntType;
import Model.Types.StringType;
import Model.Value.IValue;
import Model.Value.IntValue;
import Model.Value.StringValue;

import java.io.BufferedReader;
import java.io.IOException;

public class readFile implements IStmt{
    IExpression expression;
    String var_name;

    public readFile(IExpression exp, String var_name){
        this.expression = exp;
        this.var_name = var_name;
    }

    public IMyDict<String, IType> typecheck(IMyDict<String, IType> typeEnv) throws Exception{
        expression.typecheck(typeEnv);
        return typeEnv;
    }

    public PrgState execute(PrgState prg) throws WrongOpException, DivByZeroException, DictException{
        IMyStack<IStmt> stk = prg.getStk();
        IMyDict<String, IValue> symbolTable = prg.getSymTable();
        IMyDict<StringValue, BufferedReader> FileTable = prg.getFileTable();
        IMyHeap<IValue> heap = prg.getHeap();
        //pop the stmt
        if(!symbolTable.isDefined(this.var_name) || !symbolTable.lookUp(this.var_name).getType().equals(new IntType())) throw new WrongOpException("Exception on readFile");
        if(!this.expression.eval(symbolTable, heap).getType().equals(new StringType())) throw new WrongOpException ("Error on readFile: Wrong operand!");
        IValue val = this.expression.eval(symbolTable, heap);
        StringValue str = (StringValue) val;
        if(!FileTable.isDefined(str)) throw new DictException("Error on readFile-exec: Not defined!");
        BufferedReader objReader = FileTable.lookUp(str);
        try {
            int int_value;
            if (objReader.readLine() == null) int_value = 0;
            else int_value = Integer.parseInt(objReader.readLine());

            IValue v = new IntValue(int_value);
            symbolTable.update(var_name, v);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }
}
