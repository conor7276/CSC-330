public class HumanPlayer extends Player{
    

    public HumanPlayer(Pokemon p, Item i, String n){
        super(p,i,n);

    }
    public void run(){

    }
    
    public String toString(){
        String s = "";
        s += "\nHuman Player chooses: ";
        s += getPokemon().toString();
        s += getItem().toString();
        return s;
    }

    public String displayPlayerUI(){
        String s = "";
        Attack[] attacks = getPokemon().getAttacks();
        s += "|------------------------------------------------|\n";
        s += "| " + getPokemon().getName() + "                                   |\n";
        s += "|                                                |\n";
        s += "| HP: " + getPokemon().getHitPoints() + "/" + getPokemon().getMaxHealth() + "|\n";
        s += "| PP: " + getPokemon().getPowerPoints() + "/" + getPokemon().getMaxPowerPoints() + "|\n";
        s += "|                                                |\n";
        s += "| " + attacks[0].getDescription() + " : Damage " + attacks[0].getBaseDamage() + ": PP " + attacks[0].getPowerPointCost() + "| ";
        s += "| " + attacks[1].getDescription() + " : Damage " + attacks[1].getBaseDamage() + ": PP " + attacks[1].getPowerPointCost() + "|\n";
        s += "| " + attacks[2].getDescription() + " : Damage " + attacks[2].getBaseDamage() + ": PP " + attacks[2].getPowerPointCost() + "| ";
        s += "| " + attacks[3].getDescription() + " : Damage " + attacks[3].getBaseDamage() + ": PP " + attacks[3].getPowerPointCost() + "|\n";
        s += "|------------------------------------------------|\n";
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