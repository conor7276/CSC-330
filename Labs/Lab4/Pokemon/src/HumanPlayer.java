
public class HumanPlayer extends Player{
    
    /**
     * Constructor for human player
     * calls the super class to get all of its fields
     * @param p // pokemon
     * @param i // item
     * @param n // name
     */
    public HumanPlayer(Pokemon p, Item i, String n){
        super(p,i,n);

    }

    /**
     * Run method
     * The human player runs away from battle ending the program
     */
    public void run(){
        System.out.println("You decided to run away");
        System.exit(0);
    }
    
    /**
     * toString for the human player class
     * used to introduce the human players pokemon
     * @return 
     */
    public String toString(){
        String s = "";
        s += "\nHuman Player chooses: ";
        s += getPokemon().toString();
        s += getItem().toString();
        return s;
    }

    
}


