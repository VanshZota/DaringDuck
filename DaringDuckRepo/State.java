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


    //init states to get accept state, name of the state and transition for state machine
    public Boolean getisfinalstate() {
        return isfinalstate;
    }

    public String getsname() {
        return sname;
    }

    public ArrayList<transition> gettrans() {
        return trans;
    }

}
 