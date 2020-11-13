import java.util.EventObject;

public class viewEvent extends EventObject {
    private int i;
    private int j;
    private int num;

    public viewEvent(Model model, int i, int j, int num) {
        super(model);
        this.i = i;
        this.j = j;
        this.num = num;

    }
    public int getI(){
        return i;
    }
    public int getJ(){
        return j;
    }
    public int getNum(){
        return num;
    }

}
