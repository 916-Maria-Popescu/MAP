package Repository;

import Model.ADT.IMyList;
import Model.PrgState;

import java.util.List;

public interface IRepo {
    void addPrg(PrgState newPrg);
    PrgState getCrtPrg() throws Exception;
    void logPrgStateExec(PrgState p) throws Exception;
    List<PrgState> getPrgStateList();
    void setPrgStateList(List<PrgState> prgStateList);
}
