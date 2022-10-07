public class NPC {
    private float xPos,yPos;
    private int health;
    private String name;
    private int awareness;
    

    public NPC(){
        xPos = 0;
        yPos = 0;
        health = 10;
        name = "Joe Schmo";
        awareness = 0;
    }

    public NPC(float xPos, float yPos, int health,  String name,int awareness){
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health;
        this.name = name;
        this.awareness = awareness;
    }
    
    public int getHealth() {
        return health;
    }
    public String getName() {
        return name;
    }
    public float getxPos() {
        return xPos;
    }
    public float getyPos() {
        return yPos;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setxPos(float xPos) {
        this.xPos = xPos;
    }
    public void setyPos(float yPos) {
        this.yPos = yPos;
    }
    public int getAwareness() {
        return awareness;
    }
    public void setAwareness(int awareness) {
        this.awareness = awareness;
    }



    public void act(){
        System.out.println("I am an NPC and I am walking");

    }
}    
