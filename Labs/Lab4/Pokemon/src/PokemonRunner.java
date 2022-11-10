// ideas
// working health bar ui, goes red when low
// max health display

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
            human.run();
            // computer goes second
            cpu.run();
        }
    }



    public static void loserMessage(String winner, String loser){
        System.out.println(winner + " has won the match " + loser + " is the loser.");
    }


}
