public class Person {
    public String name;
    public int age;
    public String gender;
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
class Employeee extends Person {
    int employeeId;
    double salary;
    public Employeee(String name, int age, String gender, int employeeId, double salary) {
        super(name,age,gender);
        this.employeeId = employeeId;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "======= "+employeeId+" Details =======\n"
                         +"Employee Name: "+name+"\n"
                         +"Employee ID: "+employeeId+"\n"
                         +"Employee Age: "+age+"\n"
                         +"Employee Gender: "+gender+"\n"
                         +"Employee Salary per month: "+salary+"\n"
                         +"\n";
    }
    public static void main(String[] args) {
        Employeee e1 = new Employeee("Ritwik",22,"Male",1234,50000);
        System.out.println(e1);
    }
}
