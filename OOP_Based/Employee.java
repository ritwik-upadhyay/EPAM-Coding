public class Employee {
    private String id;
    private String name;
    private double salary;
    public Employee(String id, String name, double salary) {
        setId(id);
        setName(name);
        setSalary(salary);
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        if(id!=null && !id.trim().isEmpty()) {
            this.id = id;
            return;
        }
        System.out.println("Invalid ID.");
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
         if(name!=null && !name.trim().isEmpty()) {
            this.name = name;
            return;
        }
        System.out.println("Invalid name.");
    }
    public double getSalary() {
        return this.salary;
    }
    public void setSalary(double salary) {
        if(salary>0) {
            this.salary = salary;
            return;
        }
        System.out.println("Invalid salary.");
    }
    public void displayEmployeeDetails() {
        System.out.println("Employee Details of "+this.getName()+":");
        System.out.println("Id: "+this.getId());
        System.out.println("Name: "+this.getName());
        System.out.println("Salary: "+this.getSalary());
    }
    public static void main(String[] args) {
        Employee e = new Employee("1234","Ritwika Upadhyay",50000);
        e.displayEmployeeDetails();
        e.setName("Ritwika Mishra");
        e.setSalary(60000);
        System.out.println("After marriage and promotion");
        e.displayEmployeeDetails();
        System.out.println("Testing Invalid Inputs:");
        e.setId(null);
        e.setName("  ");
        e.setSalary(-40000);
    }
}

