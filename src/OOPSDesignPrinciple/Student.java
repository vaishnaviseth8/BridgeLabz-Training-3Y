package OOPSDesignPrinciple;

import java.util.*;

class Student {
    String name;
    List<Course> enrolledCourses = new ArrayList<>();
    public Student(String name) {
        this.name = name;
    }
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
            System.out.println(name + " enrolled in " + course.title);
        }
    }
    public void showCourses() {
        System.out.println("Student: " + name);
        for (Course c : enrolledCourses) {
            System.out.println(" - " + c.title);
        }
    }
}

class Professor {
    String name;
    List<Course> assignedCourses = new ArrayList<>();
    public Professor(String name) {
        this.name = name;
    }
    public void assignCourse(Course course) {
        if (!assignedCourses.contains(course)) {
            assignedCourses.add(course);
            course.setProfessor(this);
            System.out.println(name + " assigned to teach " + course.title);
        }
    }
    public void showCourses() {
        System.out.println("Professor: " + name);
        for (Course c : assignedCourses) {
            System.out.println(" - " + c.title);
        }
    }
}

class Course {
    String title;
    Professor professor;
    List<Student> students = new ArrayList<>();
    public Course(String title) {
        this.title = title;
    }
    public void setProfessor(Professor p) {
        this.professor = p;
    }
    public void addStudent(Student s) {
        if (!students.contains(s)) {
            students.add(s);
        }
    }
    public void showDetails() {
        System.out.println("Course: " + title);
        System.out.println(" Professor: " + (professor != null ? professor.name : "None"));
        System.out.println(" Students:");
        for (Student s : students) {
            System.out.println("  - " + s.name);
        }
    }
}

 class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Professor p1 = new Professor("Dr. Smith");
        Professor p2 = new Professor("Dr. Johnson");
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");
        p1.assignCourse(c1);
        p2.assignCourse(c2);
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c2);
        s1.showCourses();
        s2.showCourses();
        p1.showCourses();
        p2.showCourses();
        c1.showDetails();
        c2.showDetails();
    }
}

