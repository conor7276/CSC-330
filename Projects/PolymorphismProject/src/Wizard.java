public class Wizard extends NPC{
    private int magic;

    public Wizard(){
        magic = 60;
    }

    public Wizard(float x, float y, int h, String n, int a,int m){
        super(x,y,h,n,a);
        magic = m;
    }

    public void act(){
        System.out.println("I am a wizard, and I am reading a book.");
    }

    public void castSpell(NPC other){
        if(magic > 10){
            System.out.println("I am casting a fireball at: " + other.getName());
            magic -=10;
        }
        else{
            System.out.println("Spell Fizzles");
        }
    }
}
