package Model.ADT;

import Exceptions.ListException;

import java.util.Stack;

public class MyList<T> implements IMyList<T> {
    Stack<T> list;

    public MyList(){
        list=new Stack<T>();
    }

    @Override
    public void add(T v) {
        list.push(v);
    }

    @Override
    public T pop()  throws ListException {
        if (list.isEmpty())
            throw new ListException("Can't pop the element since the list is empty!");
        return list.pop();
    }

    public T getFirstElement() {return this.list.peek();}

    @Override
    public boolean empty() {
        return this.list.isEmpty();
    }

    @Override
    public void clear(){
        this.list.clear();
    }

    @Override
    public T get(int pos) {
        return this.list.get(pos);
    }

    @Override
    public String toString() {
        return list.toString();
    }

}