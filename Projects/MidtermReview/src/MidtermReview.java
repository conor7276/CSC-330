public class MidtermReview {
    public static void main(String[] args) throws Exception {
        
        // 1a) Date today = new Date(10,20,2002);

        // 1b)
        /*
         * public Date(int mo, int day, int yr){
         * 
         *      month = mo;
         *      this.day = day;
         *      year = yr;
         * }
         */

        // 1c
        // month is private in date, so it cannot be directly accessed
        // call the accessor method month(). This showcases accessor methods.
        // showcases data encapsulation. myEvents[i].month();

        /* 1d
         * 
         * public String toString(){
         *      String s = "";
         *      S += month + "/" + day + "/" + year;
         * }
         */


        /* 2A
         * 
         * public int compareTo(Student other){
         *      return this.average - other.average; getAverage() can also get used
         *      
         *      or
         * 
         *      if( this.getAverage() - other.getAverage() > 0){
         *              return 1;
         *      } 
         *      else if( this.getAverage() - other.getAverage < 0){
         * 
         *              return -1;
         *      } 
         *      else{
         * 
         *              return 0;  
         *      } 
         * }
         * 
         * 
         */


        /* 2B
         * public int compareTo(Object other){
         * 
         *      // He prefers this
         *      for comparing strings does the same thing
         *      return this.name.compareTo(other.name);
         * }
         * 
         * 
         */

        /*
         * 2C
         * public boolean equals(Student other)
         * 
         *      return this.getID() == other.getID();
         */


         /* 3A
          * 
            public AnnoyingStudent(String n, int i, double av, double l, boolean det){
                super(n,i,av);
                volumeLevel = vl; // setVolumeLevel(vl) also works if available
                hasDetention = det;
            }

        */


        /* 3B
         * 
         * public boolean giveDetention(){
         *  
         *      if(volumeLevel > 50){
         *          return true;    
         *      }
         *      else{
         *          return false;
         * 
         *      }
         *      return hasDetention;
         * }
         * 
         * 
         */
        

         /* 3C
          * 
            This method does not change anything because Java is pass by value.
            It only changes first, second, and temp, but they get deleted afterwards leaving s1 and s2 pointing to the same object.

            Java is pass by value. The copies which were first, second, and temp.
            Are deleted (gone) when swap resolves (garbage collection). and 
            swap remains the same.


          */

          /* 3D
           * public void swap(Student first, Student second){
           *    Student temp = new Student(s1.getName(),s1.getID(),s1.getAverage());
           *    creating a new object as the first one so it can be swapped
           *    via mutator functions. pain in the ass
           *    s1.setName(s2.getName());
           *    s1.setID(s2.getID());
           *    s1.setAverage(s2.getAverage());
           *    s2.setName(temp.getName());
           *    s2.setID(temp.setID());
           *    s2.setAverage(temp.setAverage());
           * }
           * 
           * 
           * 
           */

        
        /* 4A
         *  interface Lockable{
         * 
         *      public void setKey(int key);
         *      public void lock(int key);
         *      public void unlock(int key);
         *      public boolean locked();
         *     
         * }
         * 
         * 
         * 
         */

        /* 4B
         * 
         * public Account implements Lockable{
         * 
         *      private int accountNumber;
         *      private double balance;
         *      private String name;
         *      private final double interestRate = 0.35;
         *      private int key;
         *      private boolean locked;
         * 
         *      public Account(int an, double b, String n){ 
         *              accountNum = an;
         *              balance = b;
         *              name = n;
         *      }
         * 
         *      public void setKey(int key){
         *              this.key = key;
         *      }
         *      
         *      public boolean locked(){
         *              return locked;    
         *      }
         * 
         *      public boolean lock(int key){
         *          if (this.key == key){
         *              locked = true;
         *          }
         *      }
         * 
         *      public boolean unlock(int key){
         *          if(this.key == key){
         *              locked = false;
         *          }
         * 
         *      }
         * 
         *      public double deposit(double amount){
         * 
         *          if( locked == false ){
         *              balance += amount;
         *              return balance;
         *          }
         *          else{
         *              System.out.println("Account locked cannot deposit.");
         *              return -1;
         *          }
         *      }
         * 
         *      public double withdraw(double amount){
         * 
         *          if( locked == false ){
         *              balance -= amount;
         *              if(balance < 0){
         *                  System.out.println("Balance is negative setting to 0");
         *                  balance = 0;
         *              }
         *              return balance;
         *          }
         *          else{
         *              System.out.println("Account locked cannot withdraw.");
         *              return -1;
         *          }
         *      }
         * 
         *      public double addInterest(){
        *              if(locked == false){
        *                  balance += (balance * interestRate);
        *                  return balance;
        *              }
        *              else{
        *                  System.out.println("Account locked cannot add interest");
        *                  return -1;
        *              }
                }
         * }
         * 
         * 
         * 
         * 
         */




        /** 5a.
         * 
         *      public class Perishable extends InventoryItem{
         * 
         *      private Date expirationDate;
         * 
         * 
*               public Perishable(Date entry, double price, Date expire){
*                       super(entry,price);
*                       expirationDate = expire;
*               }
                private double getPrice()
                {
                    if(expirationDate.compareTo(getEntryDate) < 0){
                        // yuck
                        return getBasePrice() * .10; // 90% off
                    }
                    else
                    { super.getBasePrice only needs to be called when their are similar named functions in the class
                        return getBasePrice();
                    }
                }
         * 
         *      }
         * 
         * 
         * 
         */


        /** 5b
         *      public ArrayList<InventoryItem> getItems(double loPrice, double hiPrice)
         *      {
         *          ArrayList<InventoryItem> answeres = new ArrayList<InventoryItem>();
         *          for(InventoryItem it : items)
         *          {
         *              if(it.getPrice() >= loPrice && it.getPrice() <= hiPrice)
         *              {
         *                      answers.add(it);
         *              }
         *          }
         *          return answers
         *      }
         *      
         * 
         * 
         * 
         * 
         *
         * 
         * 
         * 
         */


         /**
          * 
            6

            can float is a uml diagram change it


          */
    }
}
