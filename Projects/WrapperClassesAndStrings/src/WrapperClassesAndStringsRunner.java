public class WrapperClassesAndStringsRunner {
    public static void main(String[] args) throws Exception {
        /* Java Strings
         * 
         * In Java Strings are immutable!!
         * This means that once you declare and instantiate a string object,
         * you can never change its value. (it means that reference)
         * 
         *  
         */

         String word1 = "phone"; // String word = new String("phone");
         
         // Hypothesis Time: 
         String word2 = "phone";
         if(word1 == word2){ // Java moment this is bad == works on some days
            System.out.println("Yankees?");
         }
         else{
            System.out.println("Mets?");
         }
         // Sometimes Java will compare references since strings are objects and sometimes it compares values
         // Unreliable don't use this for strings
         // == is for reference comparison it compares addresses
         // There are many methods in the string class that you will find useful

         // Find how many characters are in a string
         // 1) length()
         System.out.print("Size of word: " + word1.length() + "\n");
         String sentence = "Why is Java so janky with == for Objects; who wrote the compilier anyways??";
         System.out.print("Size of sentence: " + sentence.length() + "\n");

         // 2) charAt(int index) - returns the character at index
         // What symbol is at index 31 of our sentence returns an actual char
         System.out.println("The symbol at index 31 of sentence is: " + sentence.charAt(31));

         // 3) equals(String other) - returns true if this String has the same value
         System.out.println(word1.equals(word2));

         // 4) substring(int start, int end) - returns the subString of a string starting at index start and ending at end-1
         // - Overloaded function
         System.out.println(word1.substring(1,2)); // phone

         // 5) substring(int start) - one parameter returns from start all the way to the end of the string
         System.out.println(sentence.substring(4)); // strings are immutable sentence did not change

         // 6) indexOf(String subby) - return the int location
         // in a string returns -1 if subby is not there
         System.out.println("index of janky in out sentence: " + sentence.indexOf("janky"));
         System.out.println("index of batman in our sentence: " + sentence.indexOf("batman"));

         // 7) replace(String orig, String repl) - replaces all instances of orig in string with repl
         String myNewString = sentence.replace("e","y");
         System.out.println(myNewString);
         // The objects get there references change the contents of the string do not get replaced
         sentence = sentence.replace("e","y");
         System.out.println(sentence);

         String badFormat = sentence.replace(" ", "");
         System.out.println(badFormat);

         // The important ones for class!!!!!
         //8. comapreTo - how do we quantitatively compare objects that we write ourselves
         // examine how compareTo is written for String
         // compareTo returns an integer!!!!!

         // obj1.compareTo(obj2) compareto does not mutate objects
         // Typically: obj1.compareTo(obj2) will return a positive int if 
         //     obj1 > obj2
         // obj1.compareTo(obj2) will return a negative if 
         //      obj1 < obj2
         // obj1.comapreTo(obj2) will return 0 if obj1 == obj2
         /*
          * For Strings:
          * str1.compareTo(str2)
            str1.compareTo(str2) will return a positive int if
                str1 comes after str2 in the dictionary
            str1.compareTo(str2) will return a negative int if
                str1 comes before str2 in the dictionary
            str1.compareTo(str2) will return 0 if they have the same value
          */
          // word1 and word2 are phone
          String word3 = "apple";
          String word4 = "zebra";
          System.out.println(word1.compareTo(word4)); // -10 p comes 10 letters before z
          System.out.println(word1.compareTo(word3)); // 15 p comes 15 letters after a
          System.out.println(word1.compareTo(word2)); // 0 same string

          // print all of the letters in sentence vertically
          for (int i = 0; i < sentence.length(); i++){
            System.out.println(sentence.substring(i,i+1));
          }





    }
}
