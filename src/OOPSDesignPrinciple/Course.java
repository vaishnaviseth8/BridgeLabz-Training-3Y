package OOPSDesignPrinciple;

import java.util.*;

class Course {
    private String name;
    private List<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this);
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + name + ":");
        for (Student s : enrolledStudents) {
            System.out.println(" - " + s.getName());
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this);
        }
    }

    protected void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void viewCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Course c : courses) {
            System.out.println(" - " + c.getName());
        }
    }
}

class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void showStudents() {
        System.out.println("Students in " + name + ":");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        School school = new School("Green Valley High");

        Student john = new Student("John");
        Student emma = new Student("Emma");
        Student raj = new Student("Raj");

        school.addStudent(john);
        school.addStudent(emma);
        school.addStudent(raj);

        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");
        Course literature = new Course("Literature");

        john.enrollInCourse(math);
        john.enrollInCourse(physics);

        emma.enrollInCourse(math);
        emma.enrollInCourse(literature);

        raj.enrollInCourse(physics);

        school.showStudents();
        System.out.println();

        john.viewCourses();
        emma.viewCourses();
        raj.viewCourses();
        System.out.println();

        math.showEnrolledStudents();
        physics.showEnrolledStudents();
        literature.showEnrolledStudents();
    }
}

