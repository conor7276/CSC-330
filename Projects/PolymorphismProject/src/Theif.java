public class Theif extends NPC{
    private int stealthValue; // 1-100
    private int deceptionValue;

    public Theif(){// calls parent constructor automatically using super will do the same thing 
        stealthValue = 50;
        deceptionValue = 50;

    }

    public Theif(float x, float y, int h, String n, int sv, int dv, int a){ // must use super() for non default class
        super(x,y,h,n,a);
        stealthValue = sv;
        deceptionValue = dv;

    }
    public int getDeceptionValue() {
        return deceptionValue;
    }
    public int getStealthValue() {
        return stealthValue;
    }
    public void setDeceptionValue(int deceptionValue) {
        this.deceptionValue = deceptionValue;
    }
    public void setStealthValue(int stealthValue) {
        this.stealthValue = stealthValue;
    }

    // METHOD OVERRIDING
    public void act(){
        System.out.println("I am a Theif, and I am stealing");
    }
    public void sneak(){
        System.out.println("Sneaky sneaky");
    }
    public void lie(NPC other){
        if(other.getAwareness() > this.getAwareness()){
            System.out.println("The other NPC does not believe me");
        }
        else{
            System.out.println("Lie Successful");
        }
    }
}
