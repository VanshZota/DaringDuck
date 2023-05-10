import java.util.*;
public class Tape{
    
        public String input; 
        public ArrayList<String> tape = new ArrayList<String>();
        public int index = 0;
        
        public Tape(String userinput){
            input = userinput;
            for (int i = 0; i < input.length(); i++) {
                tape.add(input.substring(i, i+1));
            }
        }
    
        public String getInput() {
            return input;
        }
    
        public ArrayList<String> getTape() {
            return tape;
        }
    
        public int getIndex() {
            return index;
        }
    
        public void right(){
            if (index == tape.size()-1) {
                System.out.println("Tape size: " + tape.size());
                incright();
            }
            index++;
        }
    
        public void left(){
            index--;
            if (index < 0){
                incleft();
                index = 0;
            }
        }
    
        public void incleft() { //add to the left of the tape so there is enough space
            for (int i = 0; i < tape.size()-1; i++) {
                tape.set(i+1, tape.get(i));
            }
        }
    
        public void incright() { //add to the right of the tape so there is enough space
            tape.add("N");
        }
    
        public void write(String input2) {
            tape.set(index, input2);
        }


        
        public String toString() {
            String tapestr = "";
            for (String i : tape) {
                tapestr += i + "|";
            }
            return tapestr;
        }
    
        // Prints how many 1's we have
        public int numOnes() {
            int total = 0;
            for (int i = 0; i < tape.size(); i++) {
                if (tape.get(i).equals("1")) {
                    total++;
                }
            }
            return total;
        }
    
        
    }