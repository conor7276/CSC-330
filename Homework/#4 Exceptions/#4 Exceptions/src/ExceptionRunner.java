import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
public class ExceptionRunner {
    public static void main(String[] args) throws Exception {
        
        int[] arr = {1,2,3};
        specifiedValue(arr,-1);
    }
    /**
     *  searches for a specified value in the array and returns the subscript for it
     *  if value is not found throw an exception with the error message "Element not found"
     * @param arr // array that will be searched
     * @return
     * @throws ExceptionTest
     */
    public static int specifiedValue(int[] arr, int val) throws ExceptionTest{
        if(val < 0){
            throw new IllegalArgumentException("Argument cannot be negative");
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == val){
                return i;
            }
        }
        throw new ExceptionTest("Element Not Found"); 
        
    }
}
