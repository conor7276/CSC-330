// ideas
// working health bar ui, goes red when low
// max health display
// check max health when using item

import java.util.Scanner;
//import java.util.ConsoleColors;
public class PokemonRunner {
    public static void main(String[] args) throws Exception {
        // user pokemon
        Attack[] userAttacks = {
             new Attack("Attack 1",2,"Bug",100)
            ,new Attack("Attack 2",5,"???", 400)
            ,new Attack("Attack 3",10,"yah",100)
            ,new Attack("Attack 4",2,"Bug",100)
            };
        Bug player = new Bug(100,30,"Spiderman","Bug", userAttacks);
        HumanPlayer human = new HumanPlayer(player, new Potion(100), "Player");
        System.out.println(human.toString());

        Attack[] cpuAttacks = {
            new Attack("Attack 1",20, "Flying", 20),
            new Attack("Attack 1",20, "Baller", 50),
            new Attack("Attack 1",20, "Flying", 500),
            new Attack("Attack 1",20, "Gangster", 40)
        };
        Flying comp = new Flying(120, 25, "Da baby", "Flying", cpuAttacks);
        ComputerPlayer cpu = new ComputerPlayer(comp, new Potion(100), "CPU");
        System.out.println(cpu.toString());

        boolean battle = true;
        while(battle){
            // check if pokemon has fainted
            if(player.getHitPoints() <= 0 || comp.getHitPoints() <= 0){
                if(player.getHitPoints() <= 0){
                    loserMessage(human.getName(), comp.getName());
                }
                else{
                    loserMessage(comp.getName(), human.getName());
                }
                battle = false;
            }
            // player goes first
            int op = 0;
            displayPlayerChoice();
            Scanner input = new Scanner(System.in);
            op = input.nextInt();
            //input.close();
            /*
             * Fight Item Run
             */
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

                
            
            
            


            // computer goes second
            cpu.run();
        }
    }



    public static void loserMessage(String winner, String loser){
        System.out.println(winner + " has won the match " + loser + " is the loser.");
    }

    public static void displayPlayerFight(HumanPlayer p){
        String s = "";
        Attack[] attacks = p.getPokemon().getAttacks();
        s += "\n|------------------------------------------------|\n";
        s += "| " + p.getPokemon().getName() + "                                   |\n";
        s += "|                                                |\n";
        s += "| HP: " + p.getPokemon().getHitPoints() + "/" + p.getPokemon().getMaxHealth() + "   " + healthBarLogic(p) + "|\n";
        s += "| PP: " + p.getPokemon().getPowerPoints() + "/" + p.getPokemon().getMaxPowerPoints() + "|\n";
        s += "|                                                |\n";
        s += "| " + attacks[0].getDescription() + " : Damage " + attacks[0].getBaseDamage() + ": PP " + attacks[0].getPowerPointCost() + "| ";
        s += "| " + attacks[1].getDescription() + " : Damage " + attacks[1].getBaseDamage() + ": PP " + attacks[1].getPowerPointCost() + "|\n";
        s += "| " + attacks[2].getDescription() + " : Damage " + attacks[2].getBaseDamage() + ": PP " + attacks[2].getPowerPointCost() + "| ";
        s += "| " + attacks[3].getDescription() + " : Damage " + attacks[3].getBaseDamage() + ": PP " + attacks[3].getPowerPointCost() + "|\n";
        s += "|------------------------------------------------|\n";
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
        double remBars = currHealth / maxHealth;
        bars = remBars / 0.05;
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
            current.attack(other,attackChoice);
            System.out.println(current.getName() + " used " + current.getAttack(attackChoice).getDescription() + " on " + other.getName());
    }
    
    public static void 
}
