import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
public class UnitTest {
    private Scanner input;
    private ArrayList<String> answers;

    public UnitTest(){
        try{
            // Desktop Path C:\\Users\\conor\\OneDrive\\Desktop\\school\\2022 Fall\\CSC-330\\Labs\\Lab2\\UnitTest\\src\\answers.txt
            // Laptop Path C:\\Users\\Conor\\Desktop\\School\\Fall 2022\\CSC 330\\Labs\\Lab2\\UnitTest\\src\\answers.txt
            this.input = new Scanner(new File("C:\\Users\\Conor\\Desktop\\School\\Fall 2022\\CSC 330\\Labs\\Lab2\\UnitTest\\src\\answers.txt"));
            this.answers = new ArrayList<String>();
            while(input.hasNextLine()){
                String test = input.next();
                //System.out.println(test);
                answers.add(test);
            }
            
        }catch(Exception e){
            System.out.println("File answers failed to be read");
        }
    }
    public double calculateGrade(ArrayList<String> student_answers){
        
        // passes through answers only loop takes care of assigning grades to names
        //System.out.print(student_answers);
        int num_of_answers = answers.size();
        int correct_answers = 0;     
        
        //System.out.println("Number of answers in exam: " + num_of_answers);
        //System.out.println("Number of students: " + num_of_students);
        for(int ans = 0; ans < num_of_answers; ans++){
            
            if(answers.get(ans).equals(student_answers.get(ans)) == true){
                //System.out.print(" " + answers.get(ans) + " " + student_answers.get(ans));
                correct_answers++;
                //System.out.print( " " + correct_answers + " ");
            }
            
            //if(answers.get(ans).compareTo(student_answers.get(ans)) == 0){
              //  correct_answers++;
            //}

        }
        //System.out.print(" " + num_of_answers + " ");
        //System.out.print(" " + (correct_answers / num_of_answers) + " ");
        double avg = (double) correct_answers / (double) num_of_answers;
        //System.out.print( " " + correct_answers + " " + num_of_answers + " " + avg);
        return avg;
        
        
    }

    public double calculateRange(ArrayList<ArrayList<String>> answers){



        return 0.0;
    }

    public double calculateMean(ArrayList<ArrayList<String>> answers){

        return 0.0;
    }
}

