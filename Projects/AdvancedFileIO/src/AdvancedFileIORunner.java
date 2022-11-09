import java.io.*;
import java.util.Random;

public class AdvancedFileIORunner {

    public static void main(String[] args) throws Exception {
        try{
            DataOutputStream output = new DataOutputStream(new FileOutputStream("Data.txt"));
            output.writeInt(5);
            output.writeDouble(.5);
            output.writeChar('a');
            output.writeUTF("CSC 330 at night ROCKS!");
            output.close();
        }
        catch(Exception e){
            System.out.println("oops!");
            e.printStackTrace();
        }

        try{
            DataInputStream input = new DataInputStream(new FileInputStream("Things.txt"));
            // YOU MUST MAKE SURE TO READ IN THE DATA IN THE 
            // ORDER IN WHICH YOU WROTE IT TO FILE!!
            int num = input.readInt();
            double d = input.readDouble();
            char c = input.readChar();
            String truth = input.readUTF();
            input.close();
            System.out.println(num);
            System.out.println(d);
            System.out.println(c);
            System.out.println(truth);
        }
        catch(Exception e){
            System.out.println("OOps!!!");
            e.printStackTrace();
        }



        try{
            RandomAccessFile raf = new RandomAccessFile("random.txt", "r");
            raf.writeInt(10); // 4 bytes
            raf.writeDouble(12.5); // 8 bytes
            raf.writeChar('a'); // 1 byte
            raf.writeUTF("Sleepy sleepy sleepy time");
            raf.seek(0); // seeks out the specific byte
            raf.close();
        }
        catch(Exception e){
            System.out.println("Oops!!!!");
            e.printStackTrace();
        }
    }
}
