public abstract class Pokemon {

    private int hitPoints; // health of the pokemon
    private int powerPoints; // power points of the pokemon
    private String name; // name of the pokemon
    private String type; // type of the pokemon
    private Attack[] attacks; // list of attacks set final to 4

    public abstract void attack(Pokemon other, int attackIndex); // polymorphism go brrrrr
    public abstract void speak();

    public Pokemon(int hp, int pp, String n, String t, Attack[] a){
        hitPoints = hp;
        powerPoints = pp;
        name = n;
        type = t;
        attacks = a;
    }

    public Attack[] getAttacks() {
        return attacks;
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

}
