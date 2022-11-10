public class Bug extends Pokemon {
    
    public Bug(int hp, int pp, String n, String t, Attack[] a){
        super(hp,pp,n,t,a);
    }
    
    public void attack(Pokemon other, int attackIndex) {
        if(other.getType().equals("Psyhcic") || other.getType().equals("Poison") || other.getType().equals("Grass")){
            attackIndex *= 2;
            other.setHitPoints(other.getHitPoints() - attackIndex);
            System.out.println("It was Super Effective! doing " + attackIndex + " damage");
        }
        else if(other.getType().equals("Fire") || other.getType().equals("Flying") || other.getType().equals("Rock")){
            attackIndex *= .5;
            other.setHitPoints(other.getHitPoints() - attackIndex);
            System.out.println("It was Super Effective! doing " + attackIndex + " damage");
        }
        else{
            attackIndex *= 1;
            other.setHitPoints(other.getHitPoints() - attackIndex);
            System.out.println("It did " + attackIndex + " damage");
        }
        
    }
    
    public void speak() {
        System.out.println("We ball");
        
    }
}
