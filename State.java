import java.util.*;

import javax.net.ssl.SNIHostName;
package DaringDuck;

public class State {
    
    public ArrayList<Transition> trans;
    public String sname;
    public Boolean isfinalstate;


    public stateinfo(ArrayList<Transition> transitions, String namestate, Boolean accept){
        sname = sname;
        trans = transitions;
        isfinalstate = accept;
    }

}
 