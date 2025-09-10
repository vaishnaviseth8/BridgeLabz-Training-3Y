package Inheritance;

public class Student {
    static String universityName = "Global Tech University";
    static int totalStudents = 0;

    private String name;
    private final int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for Roll Number " + rollNumber);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Vaishnavi", 101, "A");
        Student s2 = new Student("Rahul", 102, "B");

        s1.displayStudentDetails();
        s2.displayStudentDetails();

        s2.updateGrade("A+");

        System.out.println();
        s2.displayStudentDetails();

        Student.displayTotalStudents();
    }
}

