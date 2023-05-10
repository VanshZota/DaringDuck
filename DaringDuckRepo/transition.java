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
        direction = lorr;
    }

    public Tape getInputTape() {
        return mytape;
    }

    public State getNextState() {
        return nextstate;
    }
        public String getReadSymbol() {
        return inputatindex;
    }

    public String getWriteSymbol() {
        return outputatindex;
    }

    public String getDirection() {
        return direction;
    }
}

