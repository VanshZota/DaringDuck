import java.util.*;

public class StateMachine {
    // "ε" = epsilon
    // "N" = null
    
    public State currState;
    public State haltState;
    public ArrayList<State> stateList = new ArrayList<>();
    public tape tape;
    
    public StateMachine(tape input) {
        tape = input;

        ArrayList<transition> t0 = new ArrayList<>();
        ArrayList<transition> t1 = new ArrayList<>();
        ArrayList<transition> t2 = new ArrayList<>();
        ArrayList<transition> t3 = new ArrayList<>();
        ArrayList<transition> t4 = new ArrayList<>();
        ArrayList<transition> t_check = new ArrayList<>();
        ArrayList<transition> t_halt = new ArrayList<>();
        
        State s0 = new State(t0,"s0",false);
        State s1 = new State(t1,"s1",false);
        State s2 = new State(t2,"s2",false);
        State s3 = new State(t3,"s3",false);
        State s4 = new State(t4,"s4",false);
        State check = new State( t_check,"check", false);
        State halt = new State( t_halt,"halt", true);
        
        t0.add(new Transition(s0, tape, "0", "0", "R"));
        t0.add(new Transition(tape, s0, "1", "1", "R"));
        t0.add(new Transition(tape, s0, "S", "S", "R"));
        t0.add(new Transition(tape, s0, "E", "E", "R"));
        t0.add(new Transition(tape, s1, "N", "1", "L"));
        stateList.add(s0);
        currState = s0;

        t1.add(new Transition(tape, s1, "0", "0", "L"));
        t1.add(new Transition(tape, s1, "1", "1", "L"));
        t1.add(new Transition(tape, s1, "S", "S", "L"));
        t1.add(new Transition(tape, s2, "E", "E", "L"));  
        stateList.add(s1);

        t2.add(new Transition(tape, s0, "0", "1", "R"));
        t2.add(new Transition(tape, check, "1", "1", "L")); 
        stateList.add(s2);

        t_check.add(new Transition(tape, check, "1", "1", "L"));   
        t_check.add(new Transition(tape, s3, "0", "0", "R"));
        t_check.add(new Transition(tape, halt, "S", "S", "R"));
        stateList.add(check);
        
        stateList.add(halt);
        haltState = halt;

        t3.add(new Transition(tape, s3, "0", "0", "R"));
        t3.add(new Transition(tape, s3, "1", "1", "R"));
        t3.add(new Transition(tape, s3, "S", "S", "R"));
        t3.add(new Transition(tape, s4, "E", "E", "L"));
        stateList.add(s3);
    
        t4.add(new Transition(tape, s4, "1", "0", "L"));
        t4.add(new Transition(tape, s0, "0", "1", "R"));
        stateList.add(s4);
    }

    public State getCurrentState() {
        return currState;
    }

    public State getHaltState() {
        return haltState;
    }

    public void move(State initialState) {
        ArrayList<String> ta = tape.mytape();
        int tI = tape.index;
        //System.out.println("Current index: " + tI);
        if (tI > tape.mytape().size()) {
            tape.addright();
        }
        String s2 = ta.get(tI);

        for (int i = 0; i < initialState.gettrans().size(); i++) {
            ArrayList<transition> tL = initialState.gettrans();
            transition t = tL.get(i);
            String s = t.getReadSymbol();
            //System.out.println("transition is looking for symbol: " + s);
            
            //System.out.println("Symbol on tape: " + s2);
            //System.out.println(s + " equals " + s2 + ": " + (s.equals(s2)));
            if (s.equals(s2)) {
                //System.out.println("Correct symbol found. Moving to next space on tape.");
            }

            if (s.equals(s2)) {
                // if (initialState.getTransitions().get(i).getReadSymbol().equals("N")) {
                //     tape.getTape().add(initialState.getTransitions().get(i).getWriteSymbol());
                // }
                // else {
                    //System.out.println("Writing " + initialState.getTransitions().get(i).getWriteSymbol() + " to tape.");
                    tape.settape(initialState.gettrans().get(i).getWriteSymbol());
                // }
                
                // Changing the current state
                currState = initialState.gettrans().get(i).getNextState();

                // Moving the tape
                if (initialState.gettrans().get(i).getDirection().equals("L")) {
                    //System.out.println("Index before moving: " + tape.index);
                    tape.left();
                    //System.out.println("Index after moving: " + tape.index + "\n");
                }
                else {
                    //System.out.println("Index before moving: " + tape.index);
                    tape.right();
                    //System.out.println("Index after moving: " + tape.index + "\n");
                    
                }

                break;
            }
        }
    }
}