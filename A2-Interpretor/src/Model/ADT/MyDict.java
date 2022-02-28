package Model.ADT;

import Exceptions.DictException;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MyDict<T1,T2> implements IMyDict<T1,T2>{

    Map<T1,T2> dict;

    public MyDict(){dict= new HashMap<>();}

    @Override
    public void add(T1 v1, T2 v2){dict.put(v1, v2);}

    @Override
    public T2 lookUp(T1 id){return dict.get(id);}

    @Override
    public void update(T1 v1, T2 v2) throws DictException {
        if(!isDefined(v1)){
            throw new DictException("Can't update " + v1 + " since is not defined!");
        }
        dict.replace(v1, v2);
    }
    @Override
    public boolean isDefined(T1 id){return dict.containsKey(id);}

    @Override
    public String toString(){return Arrays.toString(dict.entrySet().toArray());
    }

    @Override
    public T2 remove(T1 key){
        return dict.remove(key);
    }

    @Override
    public Map<T1,T2> getContent(){
        return this.dict;
    }

    @Override
    public Collection<T1> keySet(){
        return this.dict.keySet();
    }

    @Override
    public MyDict<T1, T2> clone() {
        MyDict<T1, T2> new_dict = new MyDict<T1, T2>();
        for(T1 key : this.keySet())
            new_dict.add(key, this.lookUp(key));
        return new_dict;
    }

}
