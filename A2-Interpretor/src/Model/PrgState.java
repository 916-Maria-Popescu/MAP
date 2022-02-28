package Model;

import Exceptions.*;
import Model.ADT.IMyDict;
import Model.ADT.IMyHeap;
import Model.ADT.IMyList;
import Model.ADT.IMyStack;
import Model.Statements.IStmt;
import Model.Types.StringType;
import Model.Value.IValue;
import Model.Value.StringValue;

import java.io.BufferedReader;

public class PrgState {
    IMyStack<IStmt> exeStack;
    IMyDict<String, IValue> symTable;
    IMyList<String> out;
    IMyDict<StringValue, BufferedReader> fileTable;
    IMyHeap<IValue> heap;
    IStmt originalProgram;
    int id;

    public PrgState(int id, IMyStack<IStmt> stk, IMyDict<String, IValue> symbolTable, IMyList<String> outList, IMyDict<StringValue, BufferedReader> fileTable1, IMyHeap<IValue> heap, IStmt prg){
        this.exeStack = stk;
        this.symTable = symbolTable;
        this.out = outList;
        this.originalProgram = prg;
        this.fileTable = fileTable1;
        this.heap = heap;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("\nID: %s" +
                        "\nEXE_STACK:\n%s" +
                        "\nSYM_TABLE:\n%s" +
                        "\nOUT:\n%s +" +
                        "\nFILE_TABLE: \n%s" +
                        "\nHEAP: \n%s" ,
                Integer.toString(id),
                exeStack.toString(),
                symTable.toString(),
                out.toString(),
                fileTable.toString(),
                heap.toString());
    }

    public PrgState oneStep() throws StackException, DictException, DivByZeroException, NotDefinedException, WrongOpException {
        if(exeStack.isEmpty()) throw new StackException("Empty stack!");
        IStmt crtStmt = exeStack.pop();
        return crtStmt.execute(this);
    }
    public Boolean isNotCompleted(){ return !this.exeStack.isEmpty();}
    public IMyHeap<IValue> getHeap(){return this.heap;}
    public IMyStack<IStmt> getStk(){return this.exeStack;}
    public IMyList<String> getOut(){return this.out;}
    public IMyDict<String, IValue> getSymTable(){return this.symTable;}
    public IMyDict<StringValue, BufferedReader> getFileTable(){return this.fileTable;}
}
