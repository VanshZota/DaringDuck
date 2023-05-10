import java.util.*;

public class StateMachine {
    
    public State currentstate;
    public State finstate;



    public ArrayList<State> liststates = new ArrayList<>();
    public Tape tape;
    


    public StateMachine(Tape input) {
        tape = input;



        //initialize all of the transitions
        ArrayList<transition> trans1 = new ArrayList<>();
        ArrayList<transition> trans2 = new ArrayList<>();
        ArrayList<transition> trans3 = new ArrayList<>();
        ArrayList<transition> trans4 = new ArrayList<>();
        ArrayList<transition> trans5 = new ArrayList<>();
        ArrayList<transition> trans6 = new ArrayList<>();
        ArrayList<transition> trans7 = new ArrayList<>();
        


        //create all of the states (seen in picture)
        State s0 = new State(trans1,"s0",false);
        State s1 = new State(trans2,"s1",false);
        State s2 = new State(trans3,"s2",false);
        State s3 = new State(trans4,"s3",false);
        State s4 = new State(trans5,"s4",false);
        State s5 = new State( trans6,"s5", false);
        State s6 = new State( trans7,"end", true);
        


        //all of the transitions for s0
        trans1.add(new transition(tape,s0,  "0", "0", "R"));//s0, 0/0, R
        trans1.add(new transition(tape, s0, "1", "1", "R"));//s0, 1/1, R
        trans1.add(new transition(tape, s0, "S", "S", "R"));//s0, start/start, R
        trans1.add(new transition(tape, s0, "E", "E", "R"));//s0, end/, R
        trans1.add(new transition(tape, s1, "N", "1", "L"));//s1, null/1, L



        liststates.add(s0);
        currentstate = s0;



        //all of the transitions for s1
        trans2.add(new transition(tape, s1, "0", "0", "L")); //(s1), read 0/write 0, (s1)
        trans2.add(new transition(tape, s1, "1", "1", "L")); //(s1), read 1/write 1, (s1)
        trans2.add(new transition(tape, s1, "S", "S", "L")); //(s1), read S/write S, (s1)
        trans2.add(new transition(tape, s2, "E", "E", "L")); //(s2), read E/write E, (s2)

    
        
        liststates.add(s1);



        //trans3 transitions
        trans3.add(new transition(tape, s0, "0", "1", "R")); //(s0), read 0/write 1, (s2)
        trans3.add(new transition(tape, s5, "1", "1", "L")); //(check), read 1/write 1, (check)
        liststates.add(s2);



        //trans6 (last state before accept state) transitions
        trans6.add(new transition(tape, s5, "1", "1", "L")); //(check), read 1/write 1, (check)
        trans6.add(new transition(tape, s3, "0", "0", "R")); //(s3), read 0/write 0, (s3)
        trans6.add(new transition(tape, s6, "S", "S", "R")); //(end), read S/write S, (end)
        


        //add a final state and call it end
        liststates.add(s6);
        finstate = s6;



        //trans 4 transitions (look from the picture and just add what we need)
        trans4.add(new transition(tape, s3, "0", "0", "R")); //(s3), read 0/write 0, (s3)
        trans4.add(new transition(tape, s3, "1", "1", "R")); //(s3), read 1/write 1, (s3)
        trans4.add(new transition(tape, s3, "S", "S", "R")); //(s3), read S/write S, (s3)
        trans4.add(new transition(tape, s4, "E", "E", "L")); //(s4), read E/write E, (s4)
        liststates.add(s3);
    


        //trans5 (i think these are all done)
        trans5.add(new transition(tape, s4, "1", "0", "L")); //(s4), read 1/write 0, (s0)
        trans5.add(new transition(tape, s0, "0", "1", "R")); //(s0), read 0/write 1, (s0)
        liststates.add(s4);
    }

   


    //for moving the head and keeping track of transitions
    public State getstate() {
        return currentstate;
    }

    public State getaccept() {
        return finstate;
    }






    //note for aaron: overcommented so you see what I did if you want to change anything we can just delete before we submit
    public void move(State initialState) {

    // Declare and initialize variables
    ArrayList<String> temptape = tape.getTape(); // Get the tape from the Turing machine's tape object
    int tapeindex = tape.index; // Get the current index of the tape head

    // Check if the tape head is at the end of the tape, and move the tape one step to the right if it is
    if (tapeindex > tape.getTape().size()) {
        tape.incright();
    }

    // Get the symbol currently under the tape head
    String s2 = temptape.get(tapeindex);

    // Loop through all the transitions of the current state to find a match for the current symbol
    for (int i = 0; i < initialState.gettrans().size(); i++) {

        // Get the current transition
        ArrayList<transition> ltrans = initialState.gettrans();
        transition temptrans = ltrans.get(i);

        // Get the symbol that the current transition reads
        String tempstring = temptrans.getinput();

        // Check if the symbol matches the current symbol under the tape head
        if (tempstring.equals(s2)) {
        }

        // If the symbol matches, perform the transition
        if (tempstring.equals(s2)) {

            // Write the symbol that the transition specifies onto the tape
            tape.write(initialState.gettrans().get(i).getoutput());

            // Set the current state to the state that the transition leads to
            currentstate = initialState.gettrans().get(i).getnext();

            // Move the tape head left or right based on the direction specified by the transition
            if (initialState.gettrans().get(i).getdir().equals("L")) {
                tape.left();
            }
            else {
                tape.right();
            }

            break;
        }
    }
}

}