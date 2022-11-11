public class Potion implements Item{
    
    String name;
    int healthBoost;

    
    public Potion(int h){
        name = "Potion";
        healthBoost = h;
    }

    public final void use(Pokemon p){
        if(p.getHitPoints() + healthBoost >= p.getMaxHealth()){
            p.setHitPoints((p.getMaxHealth() - p.getHitPoints()) + p.getHitPoints());
            // 100 - 40 = 60 + 40 = 100
        }
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
