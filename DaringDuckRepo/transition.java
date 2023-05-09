public class transition {
    
    public tape inputstring;
    public State nextstate;
    public String inputread;
    public String inputwrite;
    public String direction;

    public void Transition(tape input, State next, String read, String write, String dirtape) {
        inputstring = input; //take the input from user
        nextstate = next; //find the next state that machine transitions to
        inputread = read; //read the tape
        inputwrite = write; //overwrite the tape with new output
        direction = dirtape; //find direction of the tape
    }

    public tape getinputstring() {
        return inputstring;
    }

    public State getNextState() {
        return nextstate;
    }

    public String getReadSymbol() {
        return inputread;
    }

    public String getWriteSymbol() {
        return direction;
    }

    public String getDirection() {
        return direction;
    }

}
