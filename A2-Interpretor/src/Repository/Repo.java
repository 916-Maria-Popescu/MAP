package Repository;

import Model.ADT.IMyList;
import Model.ADT.MyList;
import Model.PrgState;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repo implements IRepo {
    private List<PrgState> prgStateList;
    String logFilePath;
    int step = 1;
    boolean first_time = true;

    public Repo(PrgState prg, String path){
        logFilePath = path;
        prgStateList = new ArrayList<PrgState>();
        first_time = true;
    }
    @Override
    public List<PrgState> getPrgStateList(){return this.prgStateList;}

    @Override
    public void setPrgStateList(List<PrgState> prgStateList){this.prgStateList = prgStateList;}

    @Override
    public PrgState getCrtPrg(){
        return prgStateList.get(0);
    }

    @Override
    public void addPrg(PrgState newPrg) {
        prgStateList.add(newPrg);
    }

    public void logPrgStateExec(PrgState p) throws Exception{//throws Exception {
        if(first_time){
            try {
                PrintWriter writer = new PrintWriter(new File(logFilePath));
                writer.print("");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            first_time = false;
        }

        PrintWriter logFile = new PrintWriter(new FileOutputStream(new File(logFilePath), true));
        String csq = "\n*************************\nStep: " + step ;
        logFile.append(csq);
        logFile.append(p.toString());
        logFile.close();
        step ++;
    }



}
