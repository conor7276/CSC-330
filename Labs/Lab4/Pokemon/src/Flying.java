public class Flying extends Pokemon{
    
    public Flying(int hp, int pp, String n, String t, Attack[] a){
        super(hp,pp,n,t,a);
    }

    public void attack(Pokemon other, int attackIndex) {
        // get attack
        // multiply index and check if it's effective or otherwise.
        // apply damage
        if(other.getType().equals("Bug") || other.getType().equals("Fighting") || other.getType().equals("Grass")){
            attackIndex *= 2; // super effective 
            other.setHitPoints(other.getHitPoints() - attackIndex);
            System.out.println("It was Super Effective! doing " + attackIndex + " damage");
        }
        else if(other.getType().equals("Electric") || other.getType().equals("Rock")){
            attackIndex *= 0.5; // not very effective
            other.setHitPoints(other.getHitPoints() - attackIndex);
            System.out.println("It was Not Very Effective. " + attackIndex + " damage" );
        }
        else{
            attackIndex *= 1; // normal damage placeholder
            other.setHitPoints(other.getHitPoints() - attackIndex);
            System.out.println("It did " + attackIndex + " damage");
        }
        
    }
    public void speak() {
        
        System.out.println("RAHHHHHHHHHHHHHHHHHHH");
        
    }

}
