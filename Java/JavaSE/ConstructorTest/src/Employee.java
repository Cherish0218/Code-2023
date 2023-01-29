import java.util.Random;

public class Employee {
    private static int nextID;

    private int id;
    private String name = "";   //instance field initialiaztion
    private double salary;

    //静态初始化块
    //static intialization block
    static {
        var generator = new Random();
        // set nextID to a random number between 0 and 9999
        nextID = generator.nextInt(10000);
    }

    //object initialization block
    {
        id = nextID;
        nextID++;
    }

    //three overloaded constructors
    public Employee(String n, double s){
        name = n;
        salary = s;
    }

    public Employee(double s){
        // calls the Employee(String, double) constructor
        this("Employee #"+nextID, s);
    }

    // the default constructor
    public Employee(){
        //name initialized to "" -- see above
        //salary not explicitly set -- initialized to 0
        //id initialized in initialization block
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public double getSalary(){
        return salary;
    }
}
