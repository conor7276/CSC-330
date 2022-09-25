import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class UnitTestRunner {
    public static void main(String[] args) throws Exception {
        
        UnitTest test1 = new UnitTest();
        Scanner read_scores = new Scanner(new File("C:\\Users\\Conor\\Desktop\\School\\Fall 2022\\CSC 330\\Labs\\Lab2\\allExams.txt"));
        ArrayList<Student> students = new ArrayList<Student>();
        //ArrayList<String> answers = new ArrayList<String>();
        HashMap<String,ArrayList<String>> student_answer_map = new HashMap<String,ArrayList<String>>();
        
        // read in scores
        while(read_scores.hasNext()){
            String lastname = read_scores.next().trim();
            String firstname = read_scores.next().trim();
            ArrayList<String> answers = new ArrayList<String>();
            System.out.print(lastname + " " + firstname + " ");
            for(int i = 0; i < 10; i++){
                
                String scores = read_scores.next().trim();
                answers.add(scores);
                System.out.print(scores);
            }
            
            double average = test1.calculateGrade(answers);
            System.out.print(" " + average);
            System.out.println();
            //String scores = read_scores.next();
            //students.add(new Student(lastname,firstname));
            //answers.add(scores);
            
            
            //students = new Student(lastname,firstname,)
            //read_scores.next();
            //test1.calculateGrade()
        }
        /* 
        ArrayList<String> yar = new ArrayList<String>();
        for( int i = 0; i < 10; i++){
            yar.add("B");
        }
        double yes = test1.calculateGrade(yar);
        System.out.println(yes);      
        */  
    }
}
