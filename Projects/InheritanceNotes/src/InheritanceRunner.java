public class InheritanceRunner {
    public static void main(String args[]){
        Person person1 = new Person("Rich", "Weir");
        Student student1 = new Student("Andi","Kolari",4.0,"Junior",000000);
        HighSchoolStudent child1 = new HighSchoolStudent("Mike", "Blah", 5.0, "super senior",123456,false, "101");

        System.out.println(person1);
        System.out.println(student1);
        System.out.println(child1);



    }
}
