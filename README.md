# DaringDuck

FOR AARON:

public Tape(String inp): Constructor that initializes the tape with the given input string
public String getInput(): Returns the input string used to initialize the tape
public ArrayList<String> getTape(): Returns the ArrayList representing the tape
public int getIndex(): Returns the current position of the head on the tape
public void moveRight(): Moves the head of the tape one position to the right
public void moveLeft(): Moves the head of the tape one position to the left
public void resizeLeft(): Resizes the tape to the left by shifting all symbols to the right by one position
public void resizeRight(): Resizes the tape to the right by adding a new empty symbol at the end of the tape
public void write(String newInput): Writes a new symbol to the current position on the tape
public String toString(): Returns a String representation of the current state of the tape
public int oneCount(): Returns the number of occurrences of the symbol "1" on the tape.