import java.util.Scanner;
import java.io.*;


public class StrignsAndTokenizing {
    public static void main(String[] args){
        Scanner input;
        // FILE IO requires checked error handling 
        // Some specific errors that are thrown at run time
        // are called Exceptions
        // Exceptions are thrown by JVM (JAVA Virtual Machine)
        // at run time. You need to handle (or ignore) exceptions
        try{
                // Anonymous(no variable) object it has no reference but it does exist it will not
                // be garbage collected because it belongs to the Scanner object but you 
                // can't get the file again.
                input = new Scanner(new File("C:\\Users\\Conor\\Desktop\\School\\Fall 2022\\CSC 330\\Projects\\WrapperClassesAndStrings\\src\\data.txt"));

        }catch(Exception e){
            //code to deal with this exceptions
            System.out.println("Ahh shit we done goofed while opening the file.");
            input = new Scanner(System.in); // instead of reading from file we default to keyboard
        }
        int numOfItems = input.nextInt(); 
        Datum[] myData = new Datum[numOfItems];
        int index = 0;
        input.nextLine(); // force a next line
        while(input.hasNext()){ 
            String ssn = input.nextLine().trim(); // read lines removes leading and trailing spaces
            int secretCode = input.nextInt();
            input.nextLine();
            String phone = input.nextLine().trim();
            String word = input.nextLine().trim();
            // done reading
            // make a Datum index anonymously and add it to the datum array
            myData[index] = new Datum(ssn,secretCode,phone,word);
        }
        // Let's print our info
        for(Datum d : myData){
            System.out.println(d);
        }
        input.close(); // close that shit
    }
}
