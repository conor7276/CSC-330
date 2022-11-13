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
    
    /**
     * Constructor for pokemon class
     * @param hp // hitpoints
     * @param pp // powerpoints
     * @param n // name
     * @param t // type
     * @param a // attacks
     */
    public Pokemon(int hp, int pp, String n, String t, Attack[] a){
        hitPoints = hp;
        powerPoints = pp;
        name = n;
        type = t;
        attacks = a;
        maxHealth = hp;
        maxPowerPoints = pp;
    }

    /**
     * mutator for hitpoints
     * called when taking damage and using healing items
     * @param hitPoints
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * mutator for powerpoints
     * called when attacks are being used
     * @param powerPoints
     */
    public void setPowerPoints(int powerPoints) {
        this.powerPoints = powerPoints;
    }

    /**
     * accessor method
     * get all of the attacks of a pokemon
     * @return // an array of Attacks
     */
    public Attack[] getAttacks() {
        return attacks;
    }

    /**
     * accessor method for 
     * getting a single attack of a pokemon
     * @param index // index in the attacks array
     * @return // the attack that the index is for
     */
    public Attack getAttack(int index){
        return attacks[index];
    }
    
    /**
     * accessor method for hitpoints
     * @return
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * accessor method for name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * accessor method for powerpoints
     * @return
     */
    public int getPowerPoints() {
        return powerPoints;
    }
    
    /**
     * accessor method for type
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * accessor method for maxhealth
     * @return
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * accessor method for maxpowerpoints
     * @return
     */
    public int getMaxPowerPoints() {
        return maxPowerPoints;
    }

    /**
     * toString method for the Pokemon Class
     * used for displaying the pokemons stats at the beginning
     * @return // returns stats of the pokemon
     */
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
