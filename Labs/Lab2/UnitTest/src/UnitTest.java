import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
public class UnitTest {
    private Scanner input;
    private ArrayList<String> answers;
    /**
     * Default constructor no params
     * Creates a scanner object to read in the answers to
     * the ArrayList answers.
     * If file fails to be read it will throw an error
     */
    public UnitTest(){
        try{
            // Desktop Path C:\\Users\\conor\\OneDrive\\Desktop\\school\\2022 Fall\\CSC-330\\Labs\\Lab2\\UnitTest\\src\\answers.txt
            // Laptop Path C:\\Users\\Conor\\Desktop\\School\\Fall 2022\\CSC 330\\Labs\\Lab2\\UnitTest\\src\\answers.txt
            this.input = new Scanner(new File("C:\\Users\\Conor\\Desktop\\School\\Fall 2022\\CSC 330\\Labs\\Lab2\\UnitTest\\src\\answers.txt"));
            this.answers = new ArrayList<String>();
            while(input.hasNextLine()){
                String test = input.next();
                answers.add(test);
            }
            
        }catch(Exception e){
            System.out.println("File answers failed to be read");
        }
    }
    /**
     * Calculates the Grade of a single students test score and returns it
     * @param student_answers : ArrayList<String>
     * @return average : double
     */
    public double calculateGrade(ArrayList<String> student_answers){
        
        // passes through answers only, loop takes care of assigning grades to names
        
        int num_of_answers = answers.size();
        int correct_answers = 0;     
        
        
        for(int ans = 0; ans < num_of_answers; ans++){
            
            if(answers.get(ans).equals(student_answers.get(ans)) == true){                
                correct_answers++;                
            }
            
        }
        
        double avg = (double) correct_answers / (double) num_of_answers;
        return avg;       
    }

    /**
     * Calculates the Range of all the students test songs and returns the range
     * @param students : ArrayList<Student> 
     * @return range : double
     */
    public double calculateRange(ArrayList<Student> students){
        double range = 0.0;
        double min = 100.0;
        double max = 0.0;
        for(Student student : students){
            double curr = student.getAverage();
            if(curr > max ){
                max = curr;
            }
            if(curr < min){
                min = curr;
            }
        }
        
        System.out.println("\nThe minimum is: " + min + "\nThe maximum is: " + max + "\nThe range is: " + range + "\n");
        return range;
    }

    /**
     * Calculates the mean of all the students test scores and returns the mean
     * 
     * @param students : ArrayList<Student>
     * @return mean : double
     */
    public double calculateMean(ArrayList<Student> students){
        int size = students.size();
        double mean = 0.0;
        double total = 0.0;

        for(Student student: students){
            total += student.getAverage();
        }

        mean = (double) total / (double) size;
        System.out.println("\nThe mean score: " + mean + "\n");

        return mean;
    }
}

