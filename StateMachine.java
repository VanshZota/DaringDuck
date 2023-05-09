package DaringDuck;
import java.util.Arrays;

public class TuringMachine {
    private static final int STATE_Q0 = 0;
    private static final int STATE_Q1 = 1;
    private static final int STATE_Q2 = 2;
    private static final int STATE_Q3 = 3;

    private static final char SYMBOL_0 = '0';
    private static final char SYMBOL_1 = '1';

    private char[] tape;
    private int headPosition;
    private int currentState;

    public TuringMachine(String input) {
        tape = input.toCharArray();
        headPosition = 0;
        currentState = STATE_Q0;
    }

    public void run() {
        while (currentState != STATE_Q3) {
            switch (currentState) {
                case STATE_Q0:
                    handleStateQ0();
                    break;
                case STATE_Q1:
                    handleStateQ1();
                    break;
                case STATE_Q2:
                    handleStateQ2();
                    break;
            }
        }
    }

    private void handleStateQ0() {
        while (tape[headPosition] != SYMBOL_1) {
            moveHeadRight();
        }

        tape[headPosition] = SYMBOL_0;
        moveHeadLeft();

        currentState = STATE_Q1;
    }

    private void handleStateQ1() {
        while (tape[headPosition] != SYMBOL_0) {
            moveHeadLeft();
        }

        tape[headPosition] = SYMBOL_1;
        moveHeadRight();

        currentState = STATE_Q2;
    }

    private void handleStateQ2() {
        while (tape[headPosition] != SYMBOL_1) {
            moveHeadRight();
        }

        tape[headPosition] = SYMBOL_0;
        moveHeadLeft();

        currentState = STATE_Q1;
    }

    private void moveHeadLeft() {
        if (headPosition > 0) {
            headPosition--;
        } else {
            expandTapeLeft();
        }
    }

    private void moveHeadRight() {
        if (headPosition < tape.length - 1) {
            headPosition++;
        } else {
            expandTapeRight();
        }
    }

    private void expandTapeLeft() {
        char[] newTape = new char[tape.length + 1];
        Arrays.fill(newTape, SYMBOL_0);
        System.arraycopy(tape, 0, newTape, 1, tape.length);
        tape = newTape;
        headPosition++;
    }

    private void expandTapeRight() {
        char[] newTape = new char[tape.length + 1];
        Arrays.fill(newTape, SYMBOL_0);
        System.arraycopy(tape, 0, newTape, 0, tape.length);
        tape = newTape;
    }

    public int getScore() {
        int score = 0;
        for (char symbol : tape) {
            if (symbol == SYMBOL_1) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        String input = "000011110000";
        TuringMachine turingMachine = new TuringMachine(input);
        turingMachine.run();
        int score = turingMachine.getScore();
        System.out.println("Score: " + score);
    }
}