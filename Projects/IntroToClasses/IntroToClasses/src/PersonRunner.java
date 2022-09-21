public class PersonRunner{
    public static void main(String[] args){
        Person p; // declared a person object
        p = new Person();
        //p.setname("Awesome");
        System.out.println("Person Information \n");
        // cant do this name is private
        //System.out.print("Name:" + p.name); BAD
        //bur we can do
        System.out.println("Name " + p.getName());
        System.out.println("Age: " + p.getAge());
        System.out.println("Height " + p.getHeight());
        System.out.println("Weight " + p.getWeight());

        Person person2 = new Person("Will Smith", 53, 74, 218);
        System.out.println("Name " + person2.getName());
        System.out.println("Age: " + person2.getAge());
        System.out.println("Height " + person2.getHeight());
        System.out.println("Weight " + person2.getWeight());
        //System.out.println("Num: " + person2.num);
        //System.out.println("Num: " + Person.num);

        // Person.num = -10 changes every object to -10 only works if it is static static access to a static variable
    }
}