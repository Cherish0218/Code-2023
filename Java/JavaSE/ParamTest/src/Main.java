public class Main {
    public static void main(String[] args) {
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

        System.out.println("-------------------");
        System.out.println("Testing tripleSalary:");
        var harry = new Employee("Harry", 50000);
        System.out.println("Before: salary = " + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary = " + harry.getSalary());

        System.out.println("-------------------");
        System.out.println("Tesing swap:");
        var a = new Employee("Alice", 70000);
        var b = new Employee("Bob", 60000);
        System.out.println("Before: a = " + a.getName());
        System.out.println("Before: b = " + b.getName());
        swap(a,b);
        System.out.println("After salary a="+a.getSalary());
        System.out.println("After salary b="+b.getSalary());
        System.out.println("After: a = " + a.getName());
        System.out.println("After: b = " + b.getName());
    }

    public static void tripleValue(double x){ //doesn't work
        x = 3*x;
        System.out.println("End of method: x="+x);
    }

    public static void tripleSalary(Employee x) //works
    {
        x.raiseSalary(200);
        System.out.println("End of method: salary =" + x.getSalary());
    }

    public static void swap(Employee x, Employee y){
        Employee temp;
        x.raiseSalary(200);
        System.out.println("Raise Salary x:" + x.getSalary());

        temp = x;
        x = y;
        y = temp;

        System.out.println("End of method: x = " + x.getSalary());
        System.out.println("End of method: y = " + y.getSalary());
    }
}