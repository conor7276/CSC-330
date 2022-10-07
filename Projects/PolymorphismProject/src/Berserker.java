public class Berserker extends NPC{
    private int rageLevel;
    public Berserker(){
        rageLevel = 10;
    }
    public Berserker(float x, float y, int h, String n, int a,int rl){
        super(x,y,h,n,a);
        rageLevel = rl;
    }
    
    public void act(){
        System.out.println("I am a berserker and I need to fight something now!!!!!!");
    }

    public void swingAxe(){
        System.out.println("ROARRRRRR SWWWWOWOWOWSSSSSSSSSSSSHHHHHHH");
    }
    
}
