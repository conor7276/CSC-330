public abstract class Player {

    Pokemon pokemon; // ONLY ONE POKEMON PER PLAYER
    String item; // One item that will be brought into battle

    public String getItem() {
        return item;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public Player(Pokemon p, String i){
        pokemon = p;
        item = i;
    }

    public abstract void run();


}
