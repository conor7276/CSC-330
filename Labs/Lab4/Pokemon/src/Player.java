public abstract class Player {
    private String name;
    private Pokemon pokemon; // ONLY ONE POKEMON PER PLAYER
    private Item item; // One item that will be brought into battle

    public Item getItem() {
        return item;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public String getName() {
        return name;
    }
    public Player(Pokemon p, Item i, String n){
        pokemon = p;
        item = i;
        name = n;
    }
    
    
    public abstract void run();


}
