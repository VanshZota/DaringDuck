public class transition {
    
    public Tape mytape;
    public State nextstate;
    public String inputatindex;
    public String outputatindex;
    public String direction;

    public transition(Tape input, State next, String read, String write, String lorr /*left or right*/) {
        mytape = input;
        nextstate = next;
        inputatindex = read;
        outputatindex = write;
        direction = lorr; //kind of confusing but if you want to change variable name to smth else you can
    }


    //init transition properties for state machine - might need to change names to make more sense
    public Tape gettape() {
        return mytape;
    }

    public State getnext() {
        return nextstate;
    }
        public String getinput() {
        return inputatindex;
    }

    public String getoutput() {
        return outputatindex;
    }

    public String getdir() {
        return direction;
    }
}

