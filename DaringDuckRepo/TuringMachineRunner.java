public class TuringMachineRunner {
    
    // public static StateMachine machine;
    

    public static State acceptstate;
    public static Tape tape = new Tape("S000000000000000E");


    public static void main(String[] args) {
        StateMachine mach = new StateMachine(tape);
        tape.toString();

        for (int i = 0; !mach.currentstate.equals(mach.finstate); i++) {
            mach.move(mach.currentstate);
            if (mach.currentstate.equals(mach.finstate)) {
                break;
            }
        }
        

/*         while (!(mach.currentstate.equals(mach.finstate))) {
    
            mach.move(mach.currentstate);
            


            if (mach.currentstate.equals(mach.finstate)) {
                break;
            }
        } */


        
        System.out.println("Done");
        System.out.println(tape.toString());
        System.out.println();

        int onecount = tape.numOnes();
        System.out.println("Ones: " + onecount);

        System.out.printf("Final score: %d", onecount / (7 + 5 + tape.getInput().length()));
    }
}