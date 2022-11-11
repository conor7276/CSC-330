// ideas
// working health bar ui, goes red when low
// make ai !!!!!!!!!!!!!!
// check max health when using item
// run away methods

import java.util.Random;
import java.util.Scanner;
//import java.util.ConsoleColors;
public class PokemonRunner {
    public static void main(String[] args) throws Exception {
        // user pokemon
        Attack[] userAttacks = {
             new Attack("Megahorn",4,"Bug",120)
            ,new Attack("Close Combat",5,"Fighting", 120)
            ,new Attack("Stone Edge",4,"Rock",100)
            ,new Attack("Brick Break",2,"Fighting",75)
            };
        Pokemon player = new Heracross(1000,30,"Heracross","Bug", userAttacks);
        HumanPlayer human = new HumanPlayer(player, new Potion(100), "Player");
        System.out.println(human.toString());

        Attack[] cpuAttacks = {
            new Attack("Hurricane",5, "Flying", 110),
            new Attack("Air Slash",2, "Flying", 75),
            new Attack("U-Turn",2, "Bug", 70),
            new Attack("Twister",20, "Dragon", 40)
        };
        Pokemon comp = new Pidgeot(120, 25, "Pidgeot", "Flying", cpuAttacks);
        ComputerPlayer cpu = new ComputerPlayer(comp, new Potion(100), "CPU");
        System.out.println(cpu.toString());

        boolean battle = true;
        int turnCount = 0;
        
        while(battle){
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
            //input.close();
            /*
             * Fight Item Run
             */
            displayCPU(cpu);
            switch(op){
                case 0:
                // Fight
                    displayPlayerFight(human);
                    selectAttack(player,comp);
                    break;
                case 1:
                // Item
                    human.getItem().use(player);
                    break;
                case 2:
                // Run
                    human.run();
                    break;
                default:
                    break;
            }
            // check if enemy pokemon fainted here
            turnCount++;
            Random cpuMove = new Random();
            op = cpuMove.nextInt(3);
            switch(op){
                case 0:
                    selectAttack(comp,player);
                    break;
                case 1:
                    cpu.getItem().use(comp);
                    break;
                case 2:
                    cpu.run(); // write random code for this
                    break;
            }

            


            // computer goes second
            cpu.run();
        }
        
    }



    public static void loserMessage(String winner, String loser){
        System.out.println(winner + " has won the match, " + loser + " is the loser.");
    }

    public static void displayPlayerFight(HumanPlayer p){
        String s = "";
        Attack[] attacks = p.getPokemon().getAttacks();
        s += "\n|------------------------------------------------\n";
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
        s += "|------------------------------------------------\n";
        System.out.println(s);
    }

    public static void displayPlayerChoice(){
        String s = "";
        s += "|\n-------------------------\n";
        s += "| 1. Fight  2. Item   3. Run\n";
        s += "|---------------------------\n";
        System.out.println(s);
    }
    public static String healthBarLogic(Player p){
        // max 20 --------------------
        String s = "";
        double bars = 20;
        int maxHealth = p.getPokemon().getMaxHealth();
        int currHealth = p.getPokemon().getHitPoints();
        double remBars = (double)currHealth / (double)maxHealth;
        bars = remBars / 0.05; // 1 bar is 5% of health
        if(remBars >= 0.5){
            // make colors green
            //System.out.print(ANSI_GREEN);
            for(int i = 0; i < Math.round(bars); i++){
                s += "-";
            }
        }
        else if(remBars > 0.25 && remBars < 0.50){
            // make yellow
            for(int i = 0; i < Math.round(bars); i++){
                s += "-";
            }
        }
        else{
            // make red
            for(int i = 0; i < Math.round(bars); i++){
                s += "-";
            }
        }

       
        return s;
    }
    public static void selectAttack(Pokemon current, Pokemon other){
            Scanner move = new Scanner(System.in);
            System.out.print("Select attack: ");
            int attackChoice = move.nextInt();
            //move.close();
            System.out.println();
            System.out.println(current.getName() + " used " + current.getAttack(attackChoice).getDescription() + " on " + other.getName());
            current.attack(other,attackChoice);
            
    }
    
    public static void displayCPU(ComputerPlayer p){
        /**
         * |------------------------------|
         * | Pokemon Name                 |
         * |                              |
         * | Health ----------------------|
         * |                              |
         * |------------------------------|
         */

        String s = "";
        System.out.println("\n                     |------------------------------------------------");
        System.out.println("                     | " + p.getName());
        System.out.println("                     | " + p.getPokemon().getName() + "                   ");
        System.out.println("                     | " + p.getPokemon().getHitPoints() + "/" + p.getPokemon().getMaxHealth() + ": " + healthBarLogic(p));
        System.out.println("                     |                   ");
        System.out.println("                     |-----------------------------------------------\n");
    }
    
}
