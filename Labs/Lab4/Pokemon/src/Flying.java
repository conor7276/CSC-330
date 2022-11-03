public class Flying extends Pokemon{
    
    public Flying(int hp, int pp, String n, String t, Attack[] a){
        super(hp,pp,n,t,a);
    }

    public void attack(Pokemon other, int attackIndex) {
        if(other.getType().equals("Bug") || other.getType().equals("Fighting") || other.getType().equals("Grass")){
            attackIndex *= 2; // super effective 
        }
        else if(other.getType().equals("Electric") || other.getType().equals("Rock")){
            attackIndex *= 0.5; // not very effective
        }
        else{
            attackIndex *= 1; // normal damage placeholder
        }
        
    }
    public void speak() {
        
        System.out.println("RAHHHHHHHHHHHHHHHHHHH");
        
    }

}
