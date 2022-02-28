package View;

import Controller.Controller;

public class RunExample extends Command{
    private Controller ctr;
    public RunExample(String key, String desc,Controller ctr){
        super(key, desc);
        this.ctr=ctr;
    }
    @Override
    public void execute() {
        try{
            System.out.println("here, in exec at run exemple");
            ctr.allStep(); }
        catch (Exception e) {
            e.printStackTrace();
        } //here you must treat the exceptions that can not be solved in the controller
    }
}
