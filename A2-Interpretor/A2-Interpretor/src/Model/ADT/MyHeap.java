package Model.ADT;
import Model.Value.IValue;

import java.util.HashMap;
import java.util.Map;

public class MyHeap<T> implements IMyHeap<T> {

    int memory = 0;
    private HashMap<Integer, T> heap;

    public MyHeap(HashMap<Integer, T> m){
        this.heap = m;
    }

    public MyHeap(){
        this.heap = new HashMap<>();
    }

    @Override
    public int allocate(T val){
        System.out.println("Value in heap is: " + val);
        this.memory ++ ;
        this.heap.put(this.memory, val);
        return memory;
    }

    @Override
    public void deallocate(int a){
        this.heap.remove(a);
    }

    @Override
    public T readAddress(int a){
        return this.heap.get(a);
    }

    @Override
    public String toString(){
        String str = "";
        for (Integer key : heap.keySet()){
            String key_str = key.toString();
            String val = heap.get(key).toString();
            str = str + key + " -> " + val + "\n";
        }
        return str;
    }
    public void update(Integer address, T value) {
        heap.put(address, value);
    }

    @Override
    public void add(Integer v1, T v2){heap.put(v1, v2);}

    @Override
    public T lookUp(Integer id){return heap.get(id);}

    @Override
    public void setContent(Map<Integer, T> map){
        this.heap = (HashMap<Integer, T>) map;
    }

    @Override
    public HashMap<Integer, T> getContent(){
        return this.heap;
    }

}
