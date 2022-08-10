package HomeworkForLesson13;


public class Symbols {
    private char from;
    private char to;

    public Symbols( char from, char to){
        this.from = from;
        this.to =to;
    }

    public char getFrom() {
        return from;
    }

    public char getTo() {
        return to;
    }

    public boolean isEmpty(){
        if(from !=0 && to !=0);
            return true;
    }
}

