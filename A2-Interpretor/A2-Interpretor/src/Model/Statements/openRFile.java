package Model.Statements;

import Exceptions.DictException;
import Exceptions.DivByZeroException;
import Exceptions.WrongOpException;
import Model.ADT.IMyDict;
import Model.ADT.IMyHeap;
import Model.ADT.IMyStack;
import Model.Expressions.IExpression;
import Model.PrgState;
import Model.Types.StringType;
import Model.Value.IValue;
import Model.Value.StringValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class openRFile implements  IStmt {
    IExpression exp;
    public openRFile(IExpression e) {
        this.exp = e;
    }
    public PrgState execute(PrgState prg) throws DictException, DivByZeroException, WrongOpException {
        IMyStack<IStmt> stk = prg.getStk();
        IMyDict<String, IValue> symbolTable = prg.getSymTable();
        IMyDict<StringValue, BufferedReader> FileTable = prg.getFileTable();
        IMyHeap<IValue> heap = prg.getHeap();
        //
        if (this.exp.eval(symbolTable, heap).getType().equals(new StringType())) throw new WrongOpException("This is not s StringType!");
        IValue string = this.exp.eval(symbolTable, heap);
        StringValue str = (StringValue) string;
        if (FileTable.isDefined(str)) throw new DictException("Already defined!");
        try {
            BufferedReader objReader = new BufferedReader(new FileReader(str.getValue()));
            FileTable.add(str, objReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
