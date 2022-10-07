public class NPCRUNNER {
    public static void main(String[] args){
    

        NPC boringNPC = new NPC();
        Theif robinhood = new Theif(10,10,100,"Robin hood",90,99,80);
        Berserker conan = new Berserker(20,20,1000,"Conan",100,100);
        Wizard gandalf = new Wizard(30,30,50,"Gandalf",70,70);

        // Now for some weird things:
        // In all of OOP not just Java you are allowed to have a reference that is more 
        // general than the objects instantiated type.
        // When you read it, read it right to left, asking "Is right hand side a left hand side?"
        // Is a wizard an NPC??? yes Is an NPC a wizard??? 

        // Theif t = new NPC(); Syntax error no an NPC is not a theif
        
        NPC merlin = new Wizard(); // Yes a wizard is an NPC
        NPC locke = new Theif(10,20,300,"Locke Cole",20,20,20); // Yes a Theif is an NPC
        
        // These types are not binded correctly and Java does not recognize them
        // in the context of OOP you need to understand two types of bindings

        /*
         * 1. Static/Early Binding:
         *  This occurs at compile time: the question asked is: "Can this object do this?"
         * Reads with left hand side of equal side reads the object first
         * Wizard the compilier reads it as, this object can do whatever a wizard can do
        */

        gandalf.castSpell(robinhood); // sure Wizard object doing Wizard action
        robinhood.sneak(); // sure Theif object doing Theif action
        //merlin.castSpell(gandalf); // merlin can not cast a spell because he is an NPC and not a wizard
        // You can fix this by? A: Casting, changing the type
        // downcasting
        ((Wizard)merlin).castSpell(locke); // change type from NPC to Wizard make compilier think merlin is a wizard


        // 2. Late/DYNAMIC binding checks by right hand side of equal sign
        // At run time, the JVM will choose the correct behavior to enact
        // based on the actual object type
    
        System.out.println("Merlin is acting like a ");
        merlin.act(); // he will act like a wizard
        locke.act();
        System.out.println();
        NPC[] allChars = new NPC[6];
        allChars[0] = boringNPC;
        allChars[1] = robinhood;
        allChars[2] = conan;
        allChars[3] = gandalf;
        allChars[4] = merlin;
        allChars[5] = locke;

        for(int i = 0; i < allChars.length; i++){
            doSomething(allChars[i]);
        }




    }

    public static void theifDoSomething(Theif t){ // bad code repitious absolutely horrendous don't do this 
        // you have to repeat this function for every class
        t.act();
    }

    public static void doSomething(NPC human){
        human.act();
    }
}
