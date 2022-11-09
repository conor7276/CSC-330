public abstract class Player {

    Pokemon pokemon; // ONLY ONE POKEMON PER PLAYER
    Item item; // One item that will be brought into battle

    public Item getItem() {
        return item;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public Player(Pokemon p, Item i){
        pokemon = p;
        item = i;
    }

    public abstract void run();


}
