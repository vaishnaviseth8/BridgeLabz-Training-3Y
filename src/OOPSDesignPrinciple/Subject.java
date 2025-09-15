package OOPSDesignPrinciple;

import java.util.*;

// Class representing a Subject
class Subject {
    private String name;
    private int marks;

    public Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }
}

// Class representing a Student
class Student {
    private String name;
    private String studentID;
    private List<Subject> subjects;

    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public String getName() {
        return name;
    }
}

// Class for calculating grades
class GradeCalculator {
    public String calculateGrade(Student student) {
        int totalMarks = 0;
        int numSubjects = student.getSubjects().size();

        for (Subject sub : student.getSubjects()) {
            totalMarks += sub.getMarks();
        }

        double average = (double) totalMarks / numSubjects;

        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }
}

// Main class to run the program
public class SchoolResultsApp {
    public static void main(String[] args) {
        Student student = new Student("John", "S01");
        student.addSubject(new Subject("Maths", 90));
        student.addSubject(new Subject("Science", 85));

        GradeCalculator calculator = new GradeCalculator();
        String grade = calculator.calculateGrade(student);

        System.out.println("Student: " + student.getName());
        System.out.println("Grade: " + grade);
    }
}
