import java.util.*;
public class tape {
    


    public String input; 
    public ArrayList<String> tape = new ArrayList<String>();
    public int index = 0;



    public ArrayList<String> mytape() {
        return tape;}
    public String mystring(){
        return input;}
    public int myindex(){
        return index;}



    public void Tape(String mystring){
        input = mystring;

        for (int i = 0; i < input.length(); i++) {
            tape.add(input.substring(i, i+1));}}

    
    public void addleft() {
        for (int i = 0; i < tape.size() - 1; i++) {
            tape.set(i + 1, tape.get(i));
    }
}

    public void addright(){
        tape.add("");}


    public void left() {
        index--;
        if (index < 0) {
            addleft();
            index=0;
        }
    }


    public void right() {
        if (index == tape.size() - 1) {
            addright();
        }

        index++;

        }

    

    public void settape(String input2){
        tape.set(index, input2);
    }
    
    public int numones(){
        int countones = 0;
        for (int i = 0; i<tape.size(); i++){
            if (tape.get(i).equals("1")) {
                countones++;
        }
    }
    return countones;
}

}
