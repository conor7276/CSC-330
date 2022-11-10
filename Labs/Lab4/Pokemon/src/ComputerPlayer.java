public class ComputerPlayer extends Player {
    

    public ComputerPlayer(Pokemon p, Item i, String n){
        super(p,i,n);
    }

    public void run(){
        
    }

    public String toString(){
        String s = "";
        s += "\nComputer Player chooses: ";
        s += getPokemon().toString();
        s += getItem().toString();
        return s;
    }
}
