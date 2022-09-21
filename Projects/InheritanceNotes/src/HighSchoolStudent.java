public class HighSchoolStudent extends Student{

    private boolean hasLunch;
    private String homeroom;

    public HighSchoolStudent(){
        super(); // unneeded
        hasLunch = false;
        homeroom = "101";
    }
    
    public HighSchoolStudent(String firstName, String lastName, double gpa, String level, int emplID, boolean hl, String hr){
        super(firstName, lastName, gpa, level, emplID);
        
        hasLunch = hl;
        homeroom = hr;
    }

    public String getHomeroom() {
        return homeroom;
    }

    public boolean isHasLunch(){
        return hasLunch;
    }

    public String toString(){
        String s = super.toString();
        s += "I have my lunch: " + hasLunch + "\n";
        s += "Homeroom: " + homeroom + "\n";
        return s;
    }
}
