package Model.ADT;

import Exceptions.StackException;

public interface IMyStack<T> {
    T pop() throws StackException;
    void push(T v);
    boolean isEmpty();
    T top() throws StackException;
    String toString();
}
