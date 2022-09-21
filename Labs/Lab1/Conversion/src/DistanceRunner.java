import java.util.Scanner;
public class DistanceRunner {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter length in meters:");
        double length = input.nextDouble();
        input.close();
        Distance newDistance = new Distance(length);
        newDistance.getInches(length);
        newDistance.getFeet(length);
        System.out.println("The length in inches is: " + newDistance.toString());

    }
}
