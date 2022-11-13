public class ComputerPlayer extends Player {
    
    /**
     * Constructor for ComputerPlayer
     * calls super class to get all of its fields
     * @param p // pokemon
     * @param i // item
     * @param n // name
     */
    public ComputerPlayer(Pokemon p, Item i, String n){
        super(p,i,n);
    }

    /**
     * Run method for whent he enemy tries to run away
     * Was not sure whether the enemy should not be able
     * to run away or have a random chance to be able to run
     */
    public void run(){
        System.out.println("The Computer Player tried running.");
    }

    /**
     * toString fo the computer player method
     * returns the string for introducing the computer players pokemon
     * @return
     */
    public String toString(){
        String s = "";
        s += "\nComputer Player chooses: ";
        s += getPokemon().toString();
        s += getItem().toString();
        return s;
    }
}
