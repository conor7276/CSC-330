
public class HumanPlayer extends Player{
    

    public HumanPlayer(Pokemon p, Item i, String n){
        super(p,i,n);

    }
    public void run(){
        System.out.println("You can't run from a trainer battle!");
    }
    
    public String toString(){
        String s = "";
        s += "\nHuman Player chooses: ";
        s += getPokemon().toString();
        s += getItem().toString();
        return s;
    }

    
}


/*
 * |------------------------------------------------|
 * | Pokemon Name                                   |
 * |                                                |
 * | HP: 36/100 -------                             |
 * | PP: 15/30 ------                               |
 * |                                                |
 * | Attack 1 : Damage : PP | Attack 2 : Damage : PP|
 * | Attack 3 : Damage : PP | Attack 4 : Damage : PP|
 * |------------------------------------------------|
 */