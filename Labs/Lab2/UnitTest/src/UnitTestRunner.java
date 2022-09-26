import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
// Unit Test Object /
// Read Student info /
// Create Student Object /
// Add Student objects to an ArrayList<Students> /
// Add all answers to an ArrayList of Strings

public class UnitTestRunner {
    public static void main(String[] args) throws Exception {
        // part 1
        UnitTest test1 = new UnitTest(); // test object

        // desktop path C:\\Users\\conor\\OneDrive\\Desktop\\school\\2022 Fall\\CSC-330\\Labs\\Lab2\\UnitTest\\src\\allExams.txt
        // laptop path C:\\Users\\Conor\\Desktop\\School\\Fall 2022\\CSC 330\\Labs\\Lab2\\UnitTest\\src\\allExams.txt
        Scanner read_scores = new Scanner(new File("C:\\Users\\conor\\OneDrive\\Desktop\\school\\2022 Fall\\CSC-330\\Labs\\Lab2\\UnitTest\\src\\allExams.txt"));
        
        ArrayList<Student> students = new ArrayList<Student>(); // Store student objects
        
        ArrayList<String> answers = new ArrayList<String>(); // Store students answers
        
        
        
        // read in scores
        while(read_scores.hasNext()){ // read in student info
            String lastname = read_scores.next().trim();
            String firstname = read_scores.next().trim();
            Student student = new Student(lastname,firstname); // create student object
            students.add(student); // add student to student list
            String temp = "";
            
            System.out.print(lastname + " " + firstname + " ");
            for(int i = 0; i < 10; i++){
                
                String scores = read_scores.next().trim(); // read each answer
                temp += scores;
                
                System.out.print(scores);
            }
            
            answers.add(temp);
            
            System.out.println();
        }
        
        System.out.println(students);
        System.out.println(answers);

        // Create hashmap
        HashMap<String,ArrayList<String>> student_answer_map = new HashMap<String,ArrayList<String>>();
        int index = 0;
        for(Student student : students){
            String name = student.getLastName() + student.getFirstName();
            //student_answer_map.put(name,answers.get(index));
            index++;

        }
        





        /* part 2!
         * 
         * 
         * double average = test1.calculateGrade(temp_answers);
            answers.add(temp);

            
            student.setAverage(average);
            
            
            System.out.print(" " + average);
         * 
         */



    }    
}
