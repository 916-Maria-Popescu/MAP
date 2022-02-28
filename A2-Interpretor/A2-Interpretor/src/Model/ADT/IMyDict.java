package Model.ADT;

import Exceptions.DictException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface IMyDict <T1, T2>{
    void add(T1 v1, T2 v2);
    void update(T1 v1, T2 v2) throws DictException;
    T2 lookUp(T1 id);
    boolean isDefined(T1 id);
    String toString();
    T2 remove(T1 id);
    Map<T1, T2> getContent();
    MyDict<T1, T2> clone();
    public Collection<T1> keySet();
}
