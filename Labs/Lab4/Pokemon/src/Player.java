public abstract class Player {
    private String name;
    private Pokemon pokemon; // ONLY ONE POKEMON PER PLAYER
    private Item item; // One item that will be brought into battle

    /**
     * Constructor for the Player class
     * @param p // pokemon
     * @param i // item
     * @param n // name
     */
    public Player(Pokemon p, Item i, String n){
        pokemon = p;
        item = i;
        name = n;
    }

    /**
     * accessor method for getting the item that will be brought to battle
     * @return
     */
    public Item getItem() {
        return item;
    }

    /**
     * accessor method to get the one pokemon that the 
     * player brings to the battle
     * @return
     */
    public Pokemon getPokemon() {
        return pokemon;
    }

    /**
     * accessor method to get the name of the player
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Abstract class run
     * Run away from battle
     */
    public abstract void run();


}
