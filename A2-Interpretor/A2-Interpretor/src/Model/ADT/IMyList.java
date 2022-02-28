package Model.ADT;

import Exceptions.ListException;

public interface IMyList <T>{
    void add(T v);
    T pop() throws ListException;
    String toString();
    boolean empty();
    void clear();
    T get(int pos);
}
