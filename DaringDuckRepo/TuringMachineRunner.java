public class TuringMachineRunner {
    
    public static State acceptstate;
    public static Tape tape = new Tape("S000000000000000E");


    public static void main(String[] args) {
        StateMachine mach = new StateMachine(tape);
        tape.toString();

        for (; !mach.currentstate.equals(mach.finstate);) {
            mach.move(mach.currentstate);
            if (mach.currentstate.equals(mach.finstate)) {
                break;
            }
        }
        

        
        System.out.println("Done");
        System.out.println(tape.toString());

        int onecount = tape.numOnes();
        System.out.println("Ones: " + onecount);

        System.out.printf("Score: %d", onecount/(7 + 5 + tape.getInput().length()));
    }
}