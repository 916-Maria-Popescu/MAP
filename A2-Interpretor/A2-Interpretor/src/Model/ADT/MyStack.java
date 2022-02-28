package Model.ADT;

import Exceptions.StackException;
import Model.Expressions.IExpression;
import Model.Statements.IStmt;

import java.util.ArrayList;
import java.util.Stack;

public class MyStack<T> implements IMyStack<T>{

    Stack<T> stack;

    public MyStack(){
        stack=new Stack<T>();
    }

    @Override
    public T pop() throws StackException {
        if (stack.isEmpty())
            throw new StackException("Can't pop the elem since the stack is empty!");
        return stack.pop();
    }

    @Override
    public void push(T v) {
        stack.push(v);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public T top() throws StackException {
        return stack.peek();
    }

    @Override
    public String toString() {
        return stack.toString();
    }



}
