public class Potion implements Item{
    
    String name;
    int healthBoost;

    
    public Potion(int h){
        name = "Potion";
        healthBoost = h;
    }

    public final void use(Pokemon p){
        p.setHitPoints(p.getHitPoints() + healthBoost);
    }
    
    public String getName() {
        return name;
    }

    public String toString(){
        String s = "";
        s += "\nThis pokemon is holding the item: " + getName() + "\n";
        return s;
    }
}
