package DaringDuck.DaringDuck;
import java.util.*;


public class State {
    
    public ArrayList<Transition> trans;
    public String sname;
    public Boolean isfinalstate;


    public stateinfo(ArrayList<Transition> transitions, String namestate, Boolean accept){
        sname = namestate;
        trans = transitions;
        isfinalstate = accept;
    }

    public String getsname() {
        return sname;
    }

    public ArrayList<Transition> gettrans() {
        return trans;
    }

    public Boolean getisfinalstate() {
        return isfinalstate;
    }
}
 