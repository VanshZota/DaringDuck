import java.util.*;


public class State {
    
    public ArrayList<transition> trans;
    public String sname;
    public Boolean isfinalstate;

    public State(ArrayList<transition> transitions, String namestate, Boolean accept){
        sname = namestate;
        trans = transitions;
        isfinalstate = accept;
    }

    public String getsname() {
        return sname;
    }

    public ArrayList<transition> gettrans() {
        return trans;
    }

    public Boolean getisfinalstate() {
        return isfinalstate;
    }
}
 