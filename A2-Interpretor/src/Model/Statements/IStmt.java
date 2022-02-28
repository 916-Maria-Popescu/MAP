package Model.Statements;

import Exceptions.DictException;
import Exceptions.DivByZeroException;
import Exceptions.NotDefinedException;
import Exceptions.WrongOpException;
import Model.ADT.IMyDict;
import Model.PrgState;
import Model.Types.IType;

import java.lang.reflect.Type;

public interface IStmt {
    IMyDict<String, IType> typecheck(IMyDict<String, IType> typeEnv) throws Exception;
    PrgState execute(PrgState state) throws DivByZeroException, WrongOpException, DictException, NotDefinedException;
}
