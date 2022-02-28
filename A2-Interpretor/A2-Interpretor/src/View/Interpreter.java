package View;
import Controller.Controller;
import Model.ADT.*;
import Model.Expressions.*;
import Model.PrgState;
import Model.Statements.*;
import Model.Types.BoolType;
import Model.Types.IntType;
import Model.Types.RefType;
import Model.Value.*;
import Repository.IRepo;
import Repository.Repo;
import java.io.BufferedReader;

public class Interpreter {

    public static void main(String[] args) {

        //----------------------------------------------------------------------------------------ex1
        IStmt ex1 = new CompStmt(new DeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))),
                        new PrintStmt(new VarExp("v"))));

        IMyStack<IStmt> stk1 = new MyStack<>();
        IMyDict<String, IValue> symTbl1 = new MyDict<>();
        IMyList<String> output1 = new MyList<>();
        IMyDict<StringValue, BufferedReader> fileTable1 = new MyDict<>();
        IMyHeap<IValue> heap1= new MyHeap<>();

        stk1.push(ex1);
        PrgState prg1 = new PrgState(1, stk1, symTbl1, output1, fileTable1, heap1,ex1);
        IRepo repo1 = new Repo(prg1, "log1.txt");
        Controller ctr1 = new Controller(repo1);
        ctr1.addProgram(prg1);


        //---------------------------------------------------------------------------------------------ex2
        IStmt ex2 = new CompStmt(new DeclStmt("a", new IntType()), new CompStmt(new DeclStmt("b", new IntType()),
                new CompStmt(new AssignStmt("b", new ArithExp("+", new VarExp("a"), new ValueExp(new
                        IntValue(1)))), new PrintStmt(new VarExp("b")))));

        IMyStack<IStmt> stk2 = new MyStack<>();
        IMyDict<String, IValue> symTbl2 = new MyDict< >();
        IMyList<String> output2 = new MyList<>();
        IMyDict<StringValue, BufferedReader> fileTable2 = new MyDict<>();
        IMyHeap<IValue> heap2= new MyHeap<>();


        stk2.push(ex2);
        PrgState prg2 = new PrgState(2, stk2, symTbl2, output2, fileTable2, heap2, ex2);
        IRepo repo2 = new Repo(prg1, "log2.txt");
        Controller ctr2 = new Controller(repo2);
        ctr2.addProgram(prg2);

        //---------------------------------------------------------------------------------------------ex3
        IStmt ex3 = new CompStmt(new DeclStmt("a", new BoolType()),
                new CompStmt(new DeclStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(new IfStmt(new VarExp("a"), new AssignStmt("v", new ValueExp(new
                                        IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new
                                        VarExp("v"))))));

        IMyStack<IStmt> stk3 = new MyStack<>();
        IMyDict<String, IValue> symTbl3 = new MyDict<>();
        IMyList<String> output3 = new MyList<>();
        IMyDict<StringValue, BufferedReader> fileTable3 = new MyDict<>();
        IMyHeap<IValue> heap3= new MyHeap<>();


        stk3.push(ex3);
        PrgState prg3 = new PrgState(3, stk3, symTbl3, output3, fileTable3, heap3, ex3);
        IRepo repo3 = new Repo(prg3, "log3.txt");
        Controller ctr3 = new Controller(repo3);
        ctr3.addProgram(prg3);


        //--------------------------------------------------------------------------------------------------ex4
        IStmt ex4 = new CompStmt(new DeclStmt("v", new RefType(new IntType())),
                new CompStmt(new New(new ValueExp(new IntValue(20)), "v"),
                        new CompStmt(new DeclStmt("a", new RefType(new RefType(new IntType()))),
                                new CompStmt(new New( new VarExp("v"), "a"),
                                        new CompStmt( new PrintStmt(new VarExp("v")), new PrintStmt(new VarExp("a")))))));

        IMyStack<IStmt> stk4 = new MyStack<>();
        IMyDict<String, IValue> symTbl4 = new MyDict<>();
        IMyList<String> output4 = new MyList<>();
        IMyDict<StringValue, BufferedReader> fileTable4 = new MyDict<>();
        IMyHeap<IValue> heap4= new MyHeap<>();

        stk4.push(ex4);
        PrgState prg4 = new PrgState(4, stk4, symTbl4, output4, fileTable4, heap4, ex4);
        IRepo repo4 = new Repo(prg4, "log4.txt");
        Controller ctr4 = new Controller(repo4);
        ctr4.addProgram(prg4);

        //------------------------------------------------------------------------------------------------------ex5

        IStmt ex5 = new CompStmt(new DeclStmt("v", new RefType(new IntType())),
                new CompStmt(new New(new ValueExp(new IntValue(20)), "v"),
                        new CompStmt(new DeclStmt("a", new RefType(new RefType(new IntType()))),
                                new CompStmt(new New( new VarExp("v"), "a"),
                                        new CompStmt(new PrintStmt(new readHeap(new VarExp("v"))), new PrintStmt(new readHeap(new VarExp("a"))))))));

        IMyStack<IStmt> stk5 = new MyStack<>();
        IMyDict<String, IValue> symTbl5 = new MyDict<>();
        IMyList<String> output5 = new MyList<>();
        IMyDict<StringValue, BufferedReader> fileTable5 = new MyDict<>();
        IMyHeap<IValue> heap5= new MyHeap<>();

        stk5.push(ex5);
        PrgState prg5 = new PrgState(5, stk5, symTbl5, output5, fileTable5, heap5, ex5);
        IRepo repo5 = new Repo(prg5, "log5.txt");
        Controller ctr5 = new Controller(repo5);
        ctr5.addProgram(prg5);

        //------------------------------------------------------------------------------------------------------ex5

        IStmt ex6 = new CompStmt(new DeclStmt("v", new RefType(new IntType())),
                new CompStmt(new New(new ValueExp(new IntValue(20)), "v"),
                        new CompStmt(new PrintStmt(new readHeap(new VarExp("v"))),
                                new CompStmt(new writeHeap("v", new ValueExp(new IntValue(30))), new PrintStmt(new readHeap(new VarExp("v")))))));

        IMyStack<IStmt> stk6 = new MyStack<>();
        IMyDict<String, IValue> symTbl6 = new MyDict<>();
        IMyList<String> output6 = new MyList<>();
        IMyDict<StringValue, BufferedReader> fileTable6 = new MyDict<>();
        IMyHeap<IValue> heap6= new MyHeap<>();

        stk6.push(ex6);
        PrgState prg6 = new PrgState(6, stk6, symTbl6, output6, fileTable6, heap6, ex6);
        IRepo repo6 = new Repo(prg6, "log6.txt");
        Controller ctr6 = new Controller(repo6);
        ctr6.addProgram(prg6);



        //------------------------------------------------------------------------------------------------------ex7
        //Example: Ref int v;new(v,20);Ref Ref int a; new(a,v); new(v,30);print(rH(rH(a)))

        IStmt ex7 = new CompStmt(new DeclStmt("v", new RefType(new IntType())),
                        new CompStmt(new New(new ValueExp(new IntValue(20)), "v"),
                                new CompStmt(new DeclStmt("a", new RefType(new RefType(new IntType()))),
                                        new CompStmt(new New(new VarExp("v"), "a"),
                                                new CompStmt(new New(new ValueExp(new IntValue(30)), "v"), new PrintStmt(new readHeap(new readHeap(new VarExp("a")))))))));

        IMyStack<IStmt> stk7 = new MyStack<>();
        IMyDict<String, IValue> symTbl7 = new MyDict<>();
        IMyList<String> output7 = new MyList<>();
        IMyDict<StringValue, BufferedReader> fileTable7 = new MyDict<>();
        IMyHeap<IValue> heap7= new MyHeap<>();

        stk7.push(ex7);
        PrgState prg7 = new PrgState(7, stk7, symTbl7, output7, fileTable7, heap7, ex7);
        IRepo repo7 = new Repo(prg7, "log7.txt");
        Controller ctr7 = new Controller(repo7);
        ctr7.addProgram(prg7);


        //------------------------------------------------------------------------------------------------------ex7
        //Example: int v; v=4; (while (v>0) print(v);v=v-1);print(v)
        IStmt ex8 = new CompStmt(new DeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(4))),
                        new CompStmt( new WhileStmt(new RelationalExp(">", new VarExp("v"), new ValueExp(new IntValue(0))),
                                new CompStmt(new PrintStmt(new VarExp("v")), new AssignStmt("v", new ArithExp("-", new VarExp("v"), new ValueExp(new IntValue(1)))))),
                                new PrintStmt(new VarExp("v")))));

        IMyStack<IStmt> stk8 = new MyStack<>();
        IMyDict<String, IValue> symTbl8 = new MyDict<>();
        IMyList<String> output8 = new MyList<>();
        IMyDict<StringValue, BufferedReader> fileTable8 = new MyDict<>();
        IMyHeap<IValue> heap8= new MyHeap<>();

        stk8.push(ex8);
        PrgState prg8 = new PrgState(8,stk8, symTbl8, output8, fileTable8, heap8, ex8);
        IRepo repo8 = new Repo(prg8, "log8.txt");
        Controller ctr8 = new Controller(repo8);
        ctr8.addProgram(prg8);

        //------------------------------------------------------------------------------------------------------ex7
        // int v; Ref int a; v=10;new(a,22);
        // fork(wH(a,30);v=32;print(v);print(rH(a)));
        // print(v);print(rH(a))

        IStmt ex9 = new CompStmt(new DeclStmt("v", new IntType()),
                new CompStmt(new DeclStmt("a", new RefType(new IntType())),
                        new CompStmt( new AssignStmt("v", new ValueExp(new IntValue(20))),
                                new CompStmt(new New(new ValueExp(new IntValue(22)), "a"),  new ForkStmt(
                                        new CompStmt(new writeHeap("a", new ValueExp(new IntValue(30))),
                                             new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(32))),
                                                new CompStmt(new PrintStmt(new VarExp("v")), new PrintStmt(new readHeap(new VarExp("a")))))))))));

        IMyStack<IStmt> stk9 = new MyStack<>();
        IMyDict<String, IValue> symTbl9 = new MyDict<>();
        IMyList<String> output9 = new MyList<>();
        IMyDict<StringValue, BufferedReader> fileTable9 = new MyDict<>();
        IMyHeap<IValue> heap9= new MyHeap<>();

        stk9.push(ex9);
        PrgState prg9 = new PrgState(9,stk9, symTbl9, output9, fileTable9, heap9, ex9);
        IRepo repo9 = new Repo(prg9, "log9.txt");
        Controller ctr9 = new Controller(repo9);
        ctr9.addProgram(prg9);

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1", ex1.toString(), ctr1));
        menu.addCommand(new RunExample("2", ex2.toString(), ctr2));
        menu.addCommand(new RunExample("3", ex3.toString(), ctr3));
        menu.addCommand(new RunExample("4", ex4.toString(), ctr4));
        menu.addCommand(new RunExample("5", ex5.toString(), ctr5));
        menu.addCommand(new RunExample("6", ex6.toString(), ctr6));
        menu.addCommand(new RunExample("7", ex7.toString(), ctr7));
        menu.addCommand(new RunExample("8", ex8.toString(), ctr8));
        menu.addCommand(new RunExample("9", ex9.toString(), ctr9));

        menu.show();

    }

}
