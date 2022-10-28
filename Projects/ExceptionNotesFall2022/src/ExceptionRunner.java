public class ExceptionRunner {
    public static void main(String[] args) throws Exception {
        

        int [] myArr = {1,2,3,4};
        //myArr[5] = 9; // asshole
        // if a method can throw an exception it must be put in a try catch bloc
        try{
            dumbMethod(106);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("This always happens without the exception, used for cleanup");
        }


    }

    public static void dumbMethod(int n) throws CSC330Exception{
            // this is dumb:
            if(n > 100){
                throw new CSC330Exception("n is greater than 100");
            }
            else{
                System.out.println("Whatever AYYYY!!!!!!!!!");
                
            }

    }
    
}
