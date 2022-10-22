public class Date implements Comparable<Date>{
   
    private int day;
    private int month;
    private int year;
 
    public Date() {  
        day = 1;
        month = 1;
        year = 1900;
    }
    public Date(int mo, int day, int yr) { 
        //part (b) } //constructor
        month = mo;
        this.day = day;
        year = yr;			
    }
 
    public int month() { return month; } //returns month of Date
    public int day() { return day; } //returns day of Date
    public int year() { return year; } //returns year of Date
 
    //returns String representation of Date as “m/d/y”
    public String toString() { 
        //part (d) 
        String s = "";
        s += month + "/" + day + "/" + year;
        return s;
    }
 
    public int compareTo(Date other) {
        return 42;  //dummy method.
    }
    
 }
 
 //1a) Date today = new Date(10, 19, 2021);
    
