public class Potion implements Item{
    
    private String name;
    private int healthBoost;

    /**
     * Constructor for potion class
     * 
     * @param h // how much health the potion will recover
     */
    public Potion(int h){
        name = "Potion";
        healthBoost = h;
    }

    /**
     * Implemented method that recovers health to the pokemon who uses it
     * Can only be used once
     * @param p // pokemon that is using this method
     */
    public void use(Pokemon p){
        // if using the potion will cause the health to go over max
        if(p.getHitPoints() + healthBoost >= p.getMaxHealth()){
            System.out.println("\n" + p.getName() + " used a potion recovering " + (p.getMaxHealth() - p.getHitPoints()) + " hitpoints.");
            p.setHitPoints(p.getMaxHealth());
            return;
        }
        p.setHitPoints(p.getHitPoints() + healthBoost);
        System.out.println("\n" + p.getName() + " used a potion recovering " + healthBoost + " hitpoints.");
    }
    
    /**
     * accessor method for getting the name of the potion
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * toString method for displaying what item the pokemon is holding
     * @return // summary of the item the pokemon is holding
     */
    public String toString(){
        String s = "";
        s += "\nThis pokemon is holding the item: " + getName() + "\n";
        return s;
    }
}
