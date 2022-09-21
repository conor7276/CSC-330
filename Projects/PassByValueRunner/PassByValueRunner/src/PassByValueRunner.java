import java.util.Scanner;
public class PassByValueRunner {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        double d1, d2;
        System.out.print("Enter a double: ");
        d1 = input.nextDouble();
        System.out.print("Enter another double: ");
        d2 = input.nextDouble();
        System.out.print("Before Swap \n");
        System.out.print("d1 = " + d1 + " d2 = " + d2 + "\n");
        swap(d1,d2);
        System.out.print("After Swap \n");
        System.out.print("d1 = " + d1 + " d2 = " + d2);
        
        Song song1 = new Song("Never ending song","Me",Integer.MAX_VALUE,2.00);
        Song song2 = new Song("What do you do with a drunken sailor","Irish People",90,0);
        
        System.out.println("Before Swap: ");
        System.out.println("Song1 " + song1 + "\n");
        System.out.println("Song2 " + song2 + "\n");
        swap(song1,song2);
        System.out.println("After swap: \n");
        System.out.println("Song1 " + song1 + "\n");
        System.out.println("Song2 " + song2 + "\n");
        
        
        input.close();
    }
    /**
     * Everything in Java is passed by value
     * This includes primitives
     * What this means is when a methodis called, a copy of the "value"
     * is passed into the method.
     * Any changes to the data is done on these temporary copies.
     * If the method is void, and the parameters are primitive No changes
     * will come out of the method when it resolves.
     * 
     * For this example, in this method num1 and num2 are swapped but not the ones in main.
     * Only the copies in the function are changed
     */
    // Broken Method does not swap values can't return 2 values
    public static void swap(double num1, double num2){
        double temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("Inside swap before resolved: num1 =" + num1 + " num2 = " + num2 + "\n");
    }
    // METHOD OVERLOADING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  
    // You can have multiple methods with the same name in the same class
    // However the headers must be different: the parameters must be of 
    // different data types or the number of parameters.
    // This acts the same way as the swap for the doubles
    public static void swap(Song s1, Song s2){
        /* 
        Song temp = s1;
        s1 = s2; Bad method
        s2 = temp;
        */
        //Fixed:
        // Copying a whole ass object
        Song temp = new Song(s1.getTitle(),s1.getArtist(),s1.getDuration(),s1.getPrice());
        s1.setTitle(s2.getTitle());
        s1.setArtist(s2.getArtist());
        s1.setDuration(s2.getDuration());
        s1.setPrice(s2.getPrice());
        s2.setTitle(temp.getTitle());
        s2.setArtist(temp.getArtist());
        s2.setDuration(temp.getDuration());
        s2.setPrice(temp.getPrice());

    }

}
