package Model.ADT;

import Model.Value.IValue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public interface IMyHeap<T> extends Serializable {
    int allocate (T value);
    T readAddress (int address);
    void deallocate(int address);
    void update(Integer address, T value);
    T lookUp(Integer id);
    void add(Integer a, T b);
    void setContent(Map<Integer, T> map);
    HashMap<Integer, T> getContent();
    //Map<Integer, T> toMap();
}
