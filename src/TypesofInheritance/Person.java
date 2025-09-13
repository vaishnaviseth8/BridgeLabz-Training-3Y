package TypesofInheritance;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        displayInfo();
        System.out.println("Subject     : " + subject);
        System.out.println("Role        : Teacher");
        System.out.println("------------------------------");
    }
}

class Student extends Person {
    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        displayInfo();
        System.out.println("Grade       : " + grade);
        System.out.println("Role        : Student");
        System.out.println("------------------------------");
    }
}

class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        displayInfo();
        System.out.println("Department  : " + department);
        System.out.println("Role        : Staff");
        System.out.println("------------------------------");
    }
}

class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Alice Johnson", 35, "Mathematics");
        Student student = new Student("Bob Smith", 16, "10th Grade");
        Staff staff = new Staff("Charlie Brown", 42, "Administration");

        teacher.displayRole();
        student.displayRole();
        staff.displayRole();
    }
}

