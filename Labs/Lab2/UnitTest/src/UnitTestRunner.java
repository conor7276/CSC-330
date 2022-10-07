import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class UnitTestRunner {
    public static void main(String[] args) throws Exception {
        // part 1
        UnitTest test1 = new UnitTest(); // test object

        // desktop path C:\\Users\\conor\\OneDrive\\Desktop\\school\\2022 Fall\\CSC-330\\Labs\\Lab2\\UnitTest\\src\\allExams.txt
        // laptop path C:\\Users\\Conor\\Desktop\\School\\Fall 2022\\CSC 330\\Labs\\Lab2\\UnitTest\\src\\allExams.txt
        
        Scanner read_scores = new Scanner(new File("C:\\Users\\Conor\\Desktop\\School\\Fall 2022\\CSC 330\\Labs\\Lab2\\UnitTest\\src\\allExams.txt"));
        
        ArrayList<Student> students = new ArrayList<Student>(); // Store student objects
        
        ArrayList<ArrayList<String>> answers = new ArrayList<ArrayList<String>>(); // Store students answers
        
        
        
        // read in scores
        while(read_scores.hasNext()){ // read in student info
            String lastname = read_scores.next().trim().toLowerCase();
            String firstname = read_scores.next().trim().toLowerCase();
            Student student = new Student(firstname,lastname); // create student object
            students.add(student); // add student to student list
            //String temp = "";
            //int index = 0;
            ArrayList<String> scores = new ArrayList<String>();
            //System.out.print(lastname + " " + firstname + " ");
            for(int i = 0; i < 10; i++){
                
                scores.add(read_scores.next().trim()); // read each answer
                //temp += scores;
                
                //System.out.print(scores);
            }
            answers.add(scores); 
            
            
            System.out.println();
        }
        System.out.println("Student Objects: ");
        System.out.println(students);
        System.out.println();
        System.out.println("Students Answers: ");
        System.out.println(answers);
        System.out.println();

        // Create hashmap
        HashMap<String,ArrayList<String>> student_answer_map = new HashMap<String,ArrayList<String>>();
        int index = 0;
        for(Student student : students){
            String name = "";
            name += student.getLastName();
            name += student.getFirstName();
            //name = name.toLowerCase();
            student_answer_map.put(name,answers.get(index));
            index++;

        }
        System.out.println("Student Hashmap: ");
        System.out.println(student_answer_map);
        System.out.println();
        //System.out.println(student_answer_map.get("russojames"));

        //System.out.println(students.size());
        //System.out.println(answers.size());

        // part 2


        
        System.out.println("Updated Student objects: ");
        for (Student student : students){
            String key = "";
            key += student.getLastName();
            key += student.getFirstName();
            double avg = test1.calculateGrade(student_answer_map.get(key));
            student.setAverage(avg);
            System.out.println(student);
        }
        

        // get range

        double range = test1.calculateRange(students);
        double mean = test1.calculateMean(students);

    }    
}

