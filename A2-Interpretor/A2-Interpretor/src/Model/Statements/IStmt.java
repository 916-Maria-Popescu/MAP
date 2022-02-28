package Model.Statements;

import Exceptions.DictException;
import Exceptions.DivByZeroException;
import Exceptions.NotDefinedException;
import Exceptions.WrongOpException;
import Model.PrgState;

public interface IStmt {
    PrgState execute(PrgState state) throws DivByZeroException, WrongOpException, DictException, NotDefinedException;
}
