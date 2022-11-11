public abstract class Pokemon {

    private int hitPoints; // health of the pokemon
    private int powerPoints; // power points of the pokemon
    private String name; // name of the pokemon
    private String type; // type of the pokemon
    private Attack[] attacks; // list of attacks only 4
    private int maxHealth; // for ui and potion logic
    private int maxPowerPoints; // for ui 
    public abstract void attack(Pokemon other, int attackIndex); // polymorphism go brrrrr
    public abstract void speak();

    public Pokemon(int hp, int pp, String n, String t, Attack[] a){
        hitPoints = hp;
        powerPoints = pp;
        name = n;
        type = t;
        attacks = a;
        maxHealth = hp;
        maxPowerPoints = pp;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public void setPowerPoints(int powerPoints) {
        this.powerPoints = powerPoints;
    }
    public Attack[] getAttacks() {
        return attacks;
    }

    public Attack getAttack(int index){
        return attacks[index];
    }
    public int getHitPoints() {
        return hitPoints;
    }

    public String getName() {
        return name;
    }

    public int getPowerPoints() {
        return powerPoints;
    }
    
    public String getType() {
        return type;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxPowerPoints() {
        return maxPowerPoints;
    }
    public String toString(){
        String s = "";
        s += "\nPokemon: " + getName();
        s += "\nType: " + getType();
        s += "\nHP : " + getHitPoints();
        s += "\nPP: " + getPowerPoints();
        s += "\nAttacks:\n";
        for(int i = 0; i < attacks.length; i++){
            s += (i + 1) + ". " + attacks[i].toString();
        }
        return s;
    }
}
