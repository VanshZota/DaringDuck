import java.util.*;

public class StateMachine {
    // "ε" = epsilon
    // "N" = null
    
    public State currentstate;
    public State finstate;


    public ArrayList<State> liststates = new ArrayList<>();
    public Tape tape;
    
    public StateMachine(Tape input) {
        tape = input;

        /* ArrayList<transition> trans1 = new ArrayList<>();
        ArrayList<transition> trans2 = new ArrayList<>();
        ArrayList<transition> trans3 = new ArrayList<>();
        ArrayList<transition> trans4 = new ArrayList<>();
        ArrayList<transition> trans5 = new ArrayList<>();
        ArrayList<transition> checktrans = new ArrayList<>();
        ArrayList<transition> accepttrans = new ArrayList<>();
        
        State s0 = new State(trans1,"s0",false);
        State s1 = new State(trans2,"s1",false);
        State s2 = new State(trans3,"s2",false);
        State s3 = new State(trans4,"s3",false);
        State s4 = new State(trans5,"s4",false);
        State check = new State( checktrans,"check", false);
        State halt = new State( accepttrans,"halt", true);
        
        trans1.add(new transition(tape,s0,  "0", "0", "R"));
        trans1.add(new transition(tape, s0, "1", "1", "R"));
        trans1.add(new transition(tape, s0, "S", "S", "R"));
        trans1.add(new transition(tape, s0, "E", "E", "R"));
        trans1.add(new transition(tape, s1, "N", "1", "L"));
        liststates.add(s0);
        currentstate = s0;

        trans2.add(new transition(tape, s1, "0", "0", "L"));
        trans2.add(new transition(tape, s1, "1", "1", "L"));
        trans2.add(new transition(tape, s1, "S", "S", "L"));
        trans2.add(new transition(tape, s2, "E", "E", "L"));  
        liststates.add(s1);

        trans3.add(new transition(tape, s0, "0", "1", "R"));
        trans3.add(new transition(tape, check, "1", "1", "L")); 
        liststates.add(s2);

        checktrans.add(new transition(tape, check, "1", "1", "L"));   
        checktrans.add(new transition(tape, s3, "0", "0", "R"));
        checktrans.add(new transition(tape, halt, "S", "S", "R"));
        liststates.add(check);
        
        liststates.add(halt);
        finstate = halt;

        trans4.add(new transition(tape, s3, "0", "0", "R"));
        trans4.add(new transition(tape, s3, "1", "1", "R"));
        trans4.add(new transition(tape, s3, "S", "S", "R"));
        trans4.add(new transition(tape, s4, "E", "E", "L"));
        liststates.add(s3);
    
        trans5.add(new transition(tape, s4, "1", "0", "L"));
        trans5.add(new transition(tape, s0, "0", "1", "R"));
        liststates.add(s4); */




        ArrayList<State> liststates = new ArrayList<>();
    ArrayList<transition> trans = new ArrayList<>();
    ArrayList<transition> checktrans = new ArrayList<>();
    ArrayList<transition> accepttrans = new ArrayList<>();

    State s0 = new State(trans, "s0", false);
    State s1 = new State(trans, "s1", false);
    State s2 = new State(trans, "s2", false);
    State s3 = new State(trans, "s3", false);
    State s4 = new State(trans, "s4", false);
    State check = new State(checktrans, "check", false);
    State halt = new State(accepttrans, "halt", true);

    liststates.add(s0);
    liststates.add(s1);
    liststates.add(s2);
    liststates.add(s3);
    liststates.add(s4);
    liststates.add(check);
    liststates.add(halt);

    trans.add(new transition(tape, s0, "0", "0", "R"));
    trans.add(new transition(tape, s0, "1", "1", "R"));
    trans.add(new transition(tape, s0, "S", "S", "R"));
    trans.add(new transition(tape, s0, "E", "E", "R"));
    trans.add(new transition(tape, s1, "N", "1", "L"));

    trans.add(new transition(tape, s1, "0", "0", "L"));
    trans.add(new transition(tape, s1, "1", "1", "L"));
    trans.add(new transition(tape, s1, "S", "S", "L"));
    trans.add(new transition(tape, s2, "E", "E", "L"));

    trans.add(new transition(tape, s0, "0", "1", "R"));
    trans.add(new transition(tape, check, "1", "1", "L"));

    checktrans.add(new transition(tape, check, "1", "1", "L"));
    checktrans.add(new transition(tape, s3, "0", "0", "R"));
    checktrans.add(new transition(tape, halt, "S", "S", "R"));

    trans.add(new transition(tape, s3, "0", "0", "R"));
    trans.add(new transition(tape, s3, "1", "1", "R"));
    trans.add(new transition(tape, s3, "S", "S", "R"));
    trans.add(new transition(tape, s4, "E", "E", "L"));

    trans.add(new transition(tape, s4, "1", "0", "L"));
    trans.add(new transition(tape, s0, "0", "1", "R"));

    currentstate = s0;
    finstate = halt;

    }

    public State getCurrentState() {
        return currentstate;
    }

    public State getHaltState() {
        return finstate;
    }

    public void move(State initialState) {
        ArrayList<String> ta = tape.getTape();
        int tI = tape.index;
        if (tI > tape.getTape().size()) {
            tape.incright();
        }
        String s2 = ta.get(tI);

        for (int i = 0; i < initialState.gettrans().size(); i++) {
            ArrayList<transition> tL = initialState.gettrans();
            transition t = tL.get(i);
            String s = t.getReadSymbol();
            if (s.equals(s2)) {
            }

            if (s.equals(s2)) {
                    tape.write(initialState.gettrans().get(i).getWriteSymbol());
                

                currentstate = initialState.gettrans().get(i).getNextState();

                // Moving the tape
                if (initialState.gettrans().get(i).getDirection().equals("L")) {
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