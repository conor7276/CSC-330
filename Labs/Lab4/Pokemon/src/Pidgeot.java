public class Pidgeot extends Pokemon{
    
    /**
     * Constructor for the Pidgeot class
     * calls the superclass to get all of its fields
     * @param hp // hitpoints
     * @param pp // powerpoints
     * @param n // name
     * @param t // type
     * @param a // attacks
     */
    public Pidgeot(int hp, int pp, String n, String t, Attack[] a){
        super(hp,pp,n,t,a);
    }


    /**
     * Attack method for attacking the enemy pokemon with a move.
     * Checks if move being used is super effective on the other pokemon
     * @param other // the enemy pokemon that will be attacked
     * @param attackIndex // the attack that the enemy pokemon will be attacked with
     */
    public void attack(Pokemon other, int attackIndex) {
        
        int damage = 0;
        this.setPowerPoints(this.getPowerPoints() - this.getAttack(attackIndex).getPowerPointCost());
        System.out.println("Computer Player using a " + this.getAttack(attackIndex).getMoveType());
        if(this.getAttack(attackIndex).getMoveType().equals("Flying")){ // super effective moves
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
                damage = getAttack(attackIndex).getBaseDamage(); // normal damage
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
                damage = getAttack(attackIndex).getBaseDamage();
                other.setHitPoints(other.getHitPoints() - damage);
                System.out.println("It did " + damage + " damage");
            }
        }
        else{ // dragon type move
            damage = getAttack(attackIndex).getBaseDamage();
            other.setHitPoints(other.getHitPoints() - damage);
            System.out.println("It did " + damage + " damage");
        }

        
    }

    /**
     * method for the pokemon to speak
     */
    public void speak() {
        
        System.out.println("Pidgeot!!!!\n");
        
    }

}
