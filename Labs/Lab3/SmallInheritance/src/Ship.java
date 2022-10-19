public class Ship {
    private String name;
    private String year;

    public Ship(){
        name = "Da boat";
        year = "At this very moment";
    }

    public Ship(String name, String year){
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String toString(){
        String s = "";
        s += "The ships name is: " + getName() + "\n";
        s += "The ships year made is: " +  getYear() + "\n";
        return s;
    }
}
