public class Attack {
    
    private String description; // what does the attack do
    private int powerPointCost; // power points cost not pcp
    private String moveType; // type of attack Ex: fire, dark
    private int baseDamage; // damage that the move does


    public int getBaseDamage() {
        return baseDamage;
    }
    public String getDescription() {
        return description;
    }
    public int getPowerPointCost() {
        return powerPointCost;
    }
    public String getMoveType() {
        return moveType;
    }

}
