import java.util.Scanner;


public class MusicStoreRunner {
    public static void main(String[] args) throws Exception {
        Song song1 = new Song("In the Air Tonight","Phil Collins", 240,1.00);
        System.out.println(song1);
        // Objects in java have default print behavior ClassName@MemoryAddress;
        Song song2 = new Song("Toxicity", "System of a Down", 218, 10.00);
        Song song3 = new Song("Happy Birthday", "Patty Hill", 1000, 99.99);
        Song song4 = new Song("El Paso", "Marty Robbins",420, 50.00);
        Song song5 = new Song("Billie Jean", "Michael Jackson", 272, 0.99);
        Song[] ourSongs = new Song[5];
        ourSongs[0] = song1;
        ourSongs[1] = song2;
        ourSongs[2] = song3;
        ourSongs[3] = song4;
        ourSongs[4] = song5;
        //Also Song[] ourSongs = {song1,song2,song3,song4,song5}
        Album ourAlbum = new Album(ourSongs, "CSC 330's Greatest Hits", "All of Us \n");
        System.out.println("Price of our album: $" + ourAlbum.getPrice());
        System.out.println(ourAlbum);
        String wrd1 = "abc";
        String wrd2 = "abcdefgh";
        System.out.println(wrd1.compareTo(wrd2));
        /* This is for lab this is very important!!!!!!!!!!!!!
         * How do you read in data in java!!!!!!!!
         * There is no CIN 
         * 
         * 
         *
         * This is how you read from console 
         */

        Scanner input = new Scanner(System.in);

        //How do you read an inteeger
        System.out.println("Enter an integer");
        int myNummy = input.nextInt();
        System.out.println(myNummy);
        System.out.println("Enter an string");
        String line = input.nextLine();
        System.out.println(line);
        System.out.println("Enter an double");
        double dubby = input.nextDouble();
        System.out.println(dubby);
    }
}
