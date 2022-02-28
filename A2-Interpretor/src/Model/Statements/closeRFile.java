package Model.Statements;

import Exceptions.DivByZeroException;
import Exceptions.NotDefinedException;
import Exceptions.WrongOpException;
import Model.ADT.IMyDict;
import Model.ADT.IMyHeap;
import Model.ADT.IMyStack;
import Model.Expressions.IExpression;
import Model.PrgState;
import Model.Types.BoolType;
import Model.Types.IType;
import Model.Types.StringType;
import Model.Value.IValue;
import Model.Value.StringValue;

import java.io.BufferedReader;
import java.io.IOException;

public class closeRFile implements IStmt{
    IExpression exp;

    public closeRFile(IExpression expression){
        this.exp = expression;
    }

    public PrgState execute(PrgState prg) throws NotDefinedException, DivByZeroException, WrongOpException {
        IMyStack<IStmt> stk = prg.getStk();
        IMyDict<String, IValue> symbolTable = prg.getSymTable();
        IMyDict<StringValue, BufferedReader> FileTable = prg.getFileTable();
        IMyHeap<IValue> heap = prg.getHeap();
        //
        if(this.exp.eval(symbolTable, heap).getType().equals(new StringType())) throw new WrongOpException("Error on closeRFile-execute : Exp not string!");
        IValue val = exp.eval(symbolTable, heap);
        StringValue str = (StringValue) val;
        if(!FileTable.isDefined(str)) throw new NotDefinedException("Error on closeRFile-execute: FileTable key not defined");
        BufferedReader objReader = FileTable.lookUp(str);
        try {
            objReader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        FileTable.remove(str);
        return null;
    }

    public IMyDict<String, IType> typecheck(IMyDict<String, IType> typeEnv) throws Exception{
        exp.typecheck(typeEnv);
        return typeEnv;
    }
}
