public class Attack {
    
    private String description; // what does the attack do
    private int powerPointCost; // power points cost not pcp
    private String moveType; // type of attack Ex: fire, dark
    private int baseDamage; // damage that the move does

    public Attack(String d, int p, String m, int b){
        description = d;
        powerPointCost = p;
        moveType = m;
        baseDamage = b;
    }

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
    public String toString(){
        String s = "";
        s += "\nName: " + getDescription();
        s += "\nPP: " + getPowerPointCost();
        s += "\nType: " + getMoveType();
        s += "\nDamage: " + getBaseDamage() + "\n";
        return s;
    }

}
