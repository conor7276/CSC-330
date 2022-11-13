
import java.util.Random;
import java.util.Scanner;

public class PokemonRunner {
    public static void main(String[] args) throws Exception {
        // Human Player Pokemon
        Attack[] userAttacks = {
             new Attack("Megahorn",4,"Bug",120)
            ,new Attack("Close Combat",5,"Fighting", 120)
            ,new Attack("Stone Edge",4,"Rock",100)
            ,new Attack("Brick Break",2,"Fighting",75)
            };
        Pokemon player = new Heracross(1000,30,"Heracross","Bug", userAttacks);
        Player human = new HumanPlayer(player, new Potion(100), "Player");
        
        // Computer Player pokemon
        Attack[] cpuAttacks = {
            new Attack("Hurricane",5, "Flying", 110),
            new Attack("Air Slash",2, "Flying", 75),
            new Attack("U-Turn",2, "Bug", 70),
            new Attack("Twister",20, "Dragon", 40)
        };
        Pokemon comp = new Pidgeot(120, 25, "Pidgeot", "Flying", cpuAttacks);
        Player cpu = new ComputerPlayer(comp, new Potion(100), "CPU");
        

        // Introductions
        System.out.println("Human player sent out " + player.toString() + " "); player.speak(); System.out.println(human.getItem());
        System.out.println("Computer player sent out " + comp.toString() + " "); comp.speak(); System.out.println(cpu.getItem());

        int turnCount = 1; // count number of turns
        boolean playeritemUsed = false; // if the human player used an item
        boolean cpuitemUsed = false; // if the computer player used an item
        while(true){
            // check if pokemon has fainted
            if(player.getHitPoints() <= 0 || comp.getHitPoints() <= 0){
                if(player.getHitPoints() >= 0){
                    loserMessage(human.getName(), cpu.getName());
                }
                else{
                    loserMessage(cpu.getName(), human.getName());
                }
                
                break;
            }

            // player goes first
            int op = 0;
            System.out.println("\n-------------------------------------------------");
            System.out.println("Turn " + turnCount + ":");
            displayCPU(cpu);
            displayPlayerChoice();
            Scanner input = new Scanner(System.in);
            op = input.nextInt();
            

            /*
             * Fight Item Run
             */
            displayCPU(cpu);
            switch(op){
                case 1:
                // Fight
                    displayPlayerFight(human);
                    selectAttack(player,comp);
                    break;
                case 2:
                // Item
                    if(playeritemUsed == false){
                        human.getItem().use(player);
                        playeritemUsed = true;
                    }   
                    else{
                        System.out.println("You can only use an item once in battle!");
                    }
                    break;
                case 3:
                // Run
                    human.run();
                    break;
                default:
                    break;
            }

            // check if enemy pokemon fainted here
            if(player.getHitPoints() <= 0 || comp.getHitPoints() <= 0){
                if(player.getHitPoints() >= 0){
                    loserMessage(human.getName(), cpu.getName());
                }
                else{
                    loserMessage(cpu.getName(), human.getName());
                }
                input.close();
                break;
            }

            // computer player goes second
            Random cpuMove = new Random();
            op = cpuMove.nextInt(3);
            op += 1;
            switch(op){
                case 1:
                    cpuChooseAttack(comp,player);
                    break;
                case 2:
                    if(cpuitemUsed == false){
                        cpu.getItem().use(comp);
                        cpuitemUsed = true;
                    }   
                    else{
                        System.out.println("The enemy tried to use an item again!");
                    }
                    break;
                case 3:
                    cpu.run(); 
                    break;
                default:
                    break;
            }

            turnCount++;           
        }       
    }


    /**
     * Prints which players either won or lost
     * @param winner // winning player
     * @param loser // losing player
     */
    public static void loserMessage(String winner, String loser){
        System.out.println(winner + " has won the match, " + loser + " is the loser.");
    }

    /**
     * Method to display the UI for the player to select their 
     * pokemons attacks when they select "fight"
     * @param p // passed through to get accessor methods
     */
    public static void displayPlayerFight(Player p){
        String s = "";
        Attack[] attacks = p.getPokemon().getAttacks();
        s += "\n|-------------------------------------------------------------|\n";
        s += "| " + p.getName() + "\n";
        s += "| " + p.getPokemon().getName() + "\n";
        s += "|\n";
        s += "| HP: " + p.getPokemon().getHitPoints() + "/" + p.getPokemon().getMaxHealth() + ": " + healthBarLogic(p) + "\n";
        s += "| PP: " + p.getPokemon().getPowerPoints() + "/" + p.getPokemon().getMaxPowerPoints() + "\n";
        s += "|\n";
        s += "| " + attacks[0].getDescription() + " : Damage " + attacks[0].getBaseDamage() + ": PP " + attacks[0].getPowerPointCost();
        s += "| " + attacks[1].getDescription() + " : Damage " + attacks[1].getBaseDamage() + ": PP " + attacks[1].getPowerPointCost() + "\n";
        s += "| " + attacks[2].getDescription() + " : Damage " + attacks[2].getBaseDamage() + ": PP " + attacks[2].getPowerPointCost();
        s += "| " + attacks[3].getDescription() + " : Damage " + attacks[3].getBaseDamage() + ": PP " + attacks[3].getPowerPointCost() + "\n";
        s += "|-------------------------------------------------------------|\n";
        System.out.println(s);
        /*
        * |------------------------------------------------|
        * | Pokemon Name                                   |
        * |                                                |
        * | HP: 36/100 -------                             |
        * | PP: 15/30 ------                               |
        * |                                                |
        * | Attack 1 : Damage : PP | Attack 2 : Damage : PP|
        * | Attack 3 : Damage : PP | Attack 4 : Damage : PP|
        * |------------------------------------------------|
        */
    }

    /**
     * Method to display the choices that the player can do
     */
    public static void displayPlayerChoice(){
        String s = "";
        s += "\n|----------------------------|\n";
        s += "| 1. Fight  2. Item   3. Run |\n";
        s += "|----------------------------|\n";
        System.out.println(s);
    }

    /**
     * Calculates how many "-" to print to the screen 
     * representing the health bar
     * @param p // for accessing health
     * @return // returns the health bar to be printed
     */
    public static String healthBarLogic(Player p){
        // max 20 --------------------
        String s = "";
        double bars = 20;
        int maxHealth = p.getPokemon().getMaxHealth();
        int currHealth = p.getPokemon().getHitPoints();
        double remBars = (double)currHealth / (double)maxHealth;
        bars = remBars / 0.05; // 1 bar is 5% of health
        for(int i = 0; i < Math.round(bars); i++){
            s += "-";
        }
        return s;
    }

    /**
     * Takes in players input to attack the other pokemon
     * @param current // always player pokemon
     * @param other // always computer players pokemon
     */
    public static void selectAttack(Pokemon current, Pokemon other){
            Scanner move = new Scanner(System.in);
            System.out.print("Select attack: ");
            while(true){
                try{
                    int attackChoice = move.nextInt();
                    attackChoice -= 1;
                    //move.close();
                    System.out.println();
                    System.out.println(current.getName() + " used " + current.getAttack(attackChoice).getDescription() + " on " + other.getName());
                    current.attack(other,attackChoice);
                    return;
                }catch (Exception e){
                    System.out.println("Choose move 1-4");
                }
            }  
    }
    
    /**
     * Displays the AIs pokemon and health
     * @param p // for accessor method always the computer player
     */
    public static void displayCPU(Player p){
        /**
         * |------------------------------|
         * | Pokemon Name                 |
         * |                              |
         * | Health ----------------------|
         * |                              |
         * |------------------------------|
         */

        
        System.out.println("\n                     |------------------------------|");
        System.out.println("                     | " + p.getName());
        System.out.println("                     | " + p.getPokemon().getName() + "                   ");
        System.out.println("                     | " + p.getPokemon().getHitPoints() + "/" + p.getPokemon().getMaxHealth() + ": " + healthBarLogic(p));
        System.out.println("                     |                   ");
        System.out.println("                     |------------------------------|\n");
    }
    
    /**
     * For AI to choose an attack
     * @param current // always computer player
     * @param other // always human player
     */
    public static void cpuChooseAttack(Pokemon current, Pokemon other){
        Random rand = new Random();
        int attackChoice = rand.nextInt(4);
        System.out.println();
        System.out.println(current.getName() + " used " + current.getAttack(attackChoice).getDescription() + " on " + other.getName());
        current.attack(other,attackChoice);
    }
}
