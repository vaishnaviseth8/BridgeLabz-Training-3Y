package TypesofInheritance;

class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name      : " + name);
        System.out.println("ID        : " + id);
        System.out.println("Salary    : $" + salary);
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size : " + teamSize);
        System.out.println("Role      : Manager");
        System.out.println("------------------------------");
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Language  : " + programmingLanguage);
        System.out.println("Role      : Developer");
        System.out.println("------------------------------");
    }
}

class Intern extends Employee {
    private String schoolName;

    public Intern(String name, int id, double salary, String schoolName) {
        super(name, id, salary);
        this.schoolName = schoolName;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("School    : " + schoolName);
        System.out.println("Role      : Intern");
        System.out.println("------------------------------");
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Manager m = new Manager("Alice Johnson", 101, 95000, 5);
        Developer d = new Developer("Bob Smith", 102, 85000, "Java");
        Intern i = new Intern("Charlie Lee", 103, 20000, "MIT");

        m.displayDetails();
        d.displayDetails();
        i.displayDetails();
    }
}

