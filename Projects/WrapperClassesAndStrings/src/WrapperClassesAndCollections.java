import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
public class WrapperClassesAndCollections {
        // An array list is of varying suze
        // It can grow ans hrink over the lifespan of 
        // a piece of software.
        
        // Generics work in java -- syntax <T>
        // I want an array list of ints
        // I CANNOT DO THIS!
        // That which is in <> has to be an object
        // ArrayList<int> myList = new ArrayList<int>(); shit don't do that
        public static void main(String[] args){
            ArrayList<Integer> myList = new ArrayList<Integer>();
            //Integer is called a wrapper class
            // A primitive data type value is "wrapped" inside of an Object  
    
            //How do I add to an ArrayList basicially worse python
            //.add(Object o) appends that mf
            myList.add(4); // make a new integer object with value 4
                             // Autoboxing Java wrapping
            myList.add(new Integer(88)); // appends right 

            //.add(int i, Object o) - places o at i of List and pushes all values forward
            // look at Java api bible to see all methods

            //How to print a List?
            System.out.println(myList); // cheating for some reason prof will get mad
            
            for(Integer i : myList){
                System.out.println(i); //OP for loop holy shit
            }

            //How do you get the number of items in an Arraylist?
            //.size() on of the many ways the size method is in Java
            // because the devs are mentally insane

            System.out.println("How many items: " + myList.size());

            myList.add(1,99999); // appending to certian element

            System.out.println(myList);
            System.out.println("How many items: " + myList.size());
            myList.add(45);
            myList.add(35786);
            System.out.println(myList);
            // How do you remove something from an Arraylist
            // 1). .remove(int index)
            //      removes object and returns it
            
            // 2) .remove(Object o)
            int nummy = myList.remove(3); // removes by index 
            System.out.println(myList);
            myList.add(4678);
            myList.remove(new Integer(99999)); // remove the object
            // deprecated moment
            System.out.println(myList);

            myList.add(3,21); // can't overwrite index
            myList.add(3,21);
            myList.add(3,21);
            System.out.println(myList);

            // I want to remove all of the 21s from the List
            // Broken ass algorithm also get() gets the value from the List
            /* 
            for (int i= 0; i < myList.size(); i++){
                if(myList.get(i) == 21){ // auto unboxing to compare Integer object to int
                    myList.remove(i);
                    // remove function removes item then pushes all items
                    // ahead back (skipping values when incrementing)
                }
            }
            */
            // fucking Java moment doesn't remove them all
            // not really though algorithm is scuffed


            // Go backwards!
            for(int i = 0; i < myList.size()-1; i++){
                if(myList.get(i) == 21){
                    myList.remove(i);
                    i--; // rahhhhhhhhhhhhhhhhhh
                }

            }

            System.out.println(myList);




            // Holy shit a hash map
            // Object as an index rahhhhhhhhhhh
            // <> generics <key,value>
            HashMap<String, Song> myMap = new HashMap<String,Song>();
            Song song1 = new Song("In the Air Tonight","Phil Collins", 240,1.00);
            System.out.println(song1);
            // Objects in java have default print behavior ClassName@MemoryAddress;
            Song song2 = new Song("Toxicity", "System of a Down", 218, 10.00);
            Song song3 = new Song("Happy Birthday", "Patty Hill", 1000, 99.99);
            Song song4 = new Song("El Paso", "Marty Robbins",420, 50.00);
            Song song5 = new Song("Billie Jean", "Michael Jackson", 272, 0.99);
            // How do we put things in a hash map?

            myMap.put(song1.getTitle(),song1);
            myMap.put(song2.getTitle(),song2);
            myMap.put(song3.getTitle(),song3);
            myMap.put(song4.getTitle(),song4);
            myMap.put(song5.getTitle(),song5);

            // Hashmaps are not sorted automatically and can be sorted using a method .sort() slow as shit

            // How do we get things?
            //.get()
            Song what = myMap.get("Billy Jean");
            System.out.println(what); // will print billie jean info
            Song nope = myMap.get("Wannabe");
            System.out.println("SPICE GIRLS SONG: = " + nope); // no spice girls song here hashmaps return null if key doesn't exist
            nope.setTitle("Uh Oh");
            // Let's print out the information in the hashmap there are multiple ways.

            // 1. Iterators
            // it == iterator
            Iterator<Map.Entry<String,Song>> it = myMap.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<String,Song> entry = it.next();
                System.out.println("Key = " + entry.getKey() + "\n Value: " + entry.getValue() );
            }
            // they may be outputed in different orders

            System.out.println (" Second map print: \n");
            // for each loop

            for(Map.Entry<String,Song> entry: myMap.entrySet()){
                
                System.out.println("Key = " + entry.getKey() + "\n Value: " + entry.getValue() );
            }

            // What happens when we have multiple values of the same key
            HashMap<String,ArrayList<Song>> magic = new HashMap<String,ArrayList<Song>>();

        }


}
