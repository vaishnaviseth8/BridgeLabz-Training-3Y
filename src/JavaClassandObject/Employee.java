package JavaClassandObject;

public class Employee {
    String name;
    String id;
    double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.printf("Salary : $%.2f\n", salary);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice Johnson", "E102", 55000);
        emp1.displayDetails();
    }
}

