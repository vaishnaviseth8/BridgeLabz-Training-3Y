package Inheritance;
public class Employee {
    static String companyName = "Tech Solutions Pvt. Ltd.";
    static int totalEmployees = 0;

    private String name;
    private String designation;
    private final int id;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Vaishnavi", 101, "Software Engineer");
        Employee e2 = new Employee("Rohit", 102, "QA Analyst");

        e1.displayEmployeeDetails();
        e2.displayEmployeeDetails();

        Employee.displayTotalEmployees();
    }
}

