public class Attack {
    
    private String description; // attack name
    private int powerPointCost; // power points cost that the move uses
    private String moveType; // type of attack Ex: fire, water, grass
    private int baseDamage; // damage that the move does

    /**
     * Constructor for attack class
     * @param d // description
     * @param p // power point cost
     * @param m // move type
     * @param b // base damage
     */
    public Attack(String d, int p, String m, int b){
        description = d;
        powerPointCost = p;
        moveType = m;
        baseDamage = b;
    }

    /**
     * accessor method for baseDamage
     * @return returns base damage
     */
    public int getBaseDamage() {
        return baseDamage;
    }

    /**
     * accessor method for description
     * @return returns the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * accessor method for powerPointCost
     * @return // returns the powerPointCost
     */
    public int getPowerPointCost() {
        return powerPointCost;
    }

    /**
     * accessor method for moveType
     * @return // return the moveType
     */
    public String getMoveType() {
        return moveType;
    }

    /**
     * toString method for the Attack class
     * For summary of moves that each pokemon has
     * @return summary of each attack
     */
    public String toString(){
        String s = "";
        s += "\nName: " + getDescription();
        s += "\nPP: " + getPowerPointCost();
        s += "\nType: " + getMoveType();
        s += "\nDamage: " + getBaseDamage() + "\n";
        return s;
    }

}
