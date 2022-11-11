public class Pidgeot extends Pokemon{
    
    public Pidgeot(int hp, int pp, String n, String t, Attack[] a){
        super(hp,pp,n,t,a);
    }

    public void attack(Pokemon other, int attackIndex) {
        // get attack
        // multiply index and check if it's effective or otherwise.
        // apply damage
        int damage = 0;
        if(this.getAttack(attackIndex).getMoveType().equals("Flying")){
            if(other.getType().equals("Bug") || other.getType().equals("Fighting") || other.getType().equals("Grass")){
                damage = getAttack(attackIndex).getBaseDamage() * 2;
                other.setHitPoints(other.getHitPoints() - damage);
                System.out.println("It was Super Effective! doing " + damage + " damage");
            }
            else if(other.getType().equals("Electric")  || other.getType().equals("Rock")){
                damage = (int) Math.round(getAttack(attackIndex).getBaseDamage() * 0.5);
                other.setHitPoints(other.getHitPoints() - damage);
                System.out.println("It was Not very Effective doing " + damage + " damage");
            }
            else{
                damage *= 1;
                other.setHitPoints(other.getHitPoints() - damage);
                System.out.println("It did " + damage + " damage");
            }
        }
        else if(this.getAttack(attackIndex).getMoveType().equals("Bug")){
            if(other.getType().equals("Psyhcic") || other.getType().equals("Poison") || other.getType().equals("Grass")){
                damage = getAttack(attackIndex).getBaseDamage() * 2;
                other.setHitPoints(other.getHitPoints() - damage);
                System.out.println("It was Super Effective! doing " + damage + " damage");
            }
            else if(other.getType().equals("Fire") || other.getType().equals("Flying") || other.getType().equals("Rock")){
                damage = (int) Math.round(getAttack(attackIndex).getBaseDamage() * 0.5);
                other.setHitPoints(other.getHitPoints() - damage);
                System.out.println("It was Not very Effective doing " + damage + " damage");
            }
            else{
                damage *= 1;
                other.setHitPoints(other.getHitPoints() - damage);
                System.out.println("It did " + damage + " damage");
            }
        }
        else{ // dragon type move
            damage *= 1;
            other.setHitPoints(other.getHitPoints() - damage);
            System.out.println("It did " + damage + " damage");
        }

        
    }
    public void speak() {
        
        System.out.println("RAHHHHHHHHHHHHHHHHHHH");
        
    }

}
