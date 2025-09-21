package ScenarioBasedQues;

import java.util.ArrayList;
import java.util.List;

public class CampusConnectApp {
    public static void main(String[] args) {
        Faculty faculty = new Faculty("Dr. Smith", "smith@univ.edu", "F001");
        Student student1 = new Student("Alice", "alice@univ.edu", "S001");
        Student student2 = new Student("Bob", "bob@univ.edu", "S002");

        Course course = new Course("CS101", "Intro to Computer Science", faculty);

        student1.enrollCourse(course);
        student2.enrollCourse(course);

        student1.assignGrade(course, 3.7);
        student2.assignGrade(course, 3.3);

        student1.printDetails();
        student2.printDetails();
        faculty.printDetails();
    }
}

interface ICourseActions {
    void enrollCourse(Course course);
    void dropCourse(Course course);
}

class Person {
    protected String name;
    protected String email;
    protected String id;

    public Person(String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public void printDetails() {
        System.out.println("Name: " + name + ", Email: " + email + ", ID: " + id);
    }
}

class Student extends Person implements ICourseActions {
    private List<Course> enrolledCourses;
    private final List<Double> grades;

    public Student(String name, String email, String id) {
        super(name, email, id);
        enrolledCourses = new ArrayList<>();
        grades = new ArrayList<>();
    }

    @Override
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
        }
    }

    @Override
    public void dropCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            enrolledCourses.remove(course);
            course.removeStudent(this);
        }
    }

    public void assignGrade(Course course, double grade) {
        int idx = enrolledCourses.indexOf(course);
        if (idx != -1) {
            if (idx < grades.size()) {
                grades.set(idx, grade);
            } else {
                // If no grade assigned yet, add
                grades.add(grade);
            }
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        double total = 0.0;
        for (Double g : grades) {
            total += g;
        }
        return total / grades.size();
    }

    public void printTranscript() {
        System.out.println("Transcript for " + name + ":");
        for (int i = 0; i < enrolledCourses.size(); i++) {
            String courseName = enrolledCourses.get(i).getCourseName();
            Double grade = (i < grades.size()) ? grades.get(i) : null;
            System.out.println("Course: " + courseName + ", Grade: " + (grade != null ? grade : "N/A"));
        }
        System.out.printf("GPA: %.2f\n", calculateGPA());
    }

    @Override
    public void printDetails() {
        super.printDetails();
        printTranscript();
    }
}

class Faculty extends Person {
    private List<Course> assignedCourses;

    public Faculty(String name, String email, String id) {
        super(name, email, id);
        assignedCourses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        if (!assignedCourses.contains(course)) {
            assignedCourses.add(course);
        }
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Assigned courses:");
        for (Course c : assignedCourses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}

class Course {
    private String courseId;
    private String courseName;
    private List<Student> students;
    private Faculty faculty;

    public Course(String courseId, String courseName, Faculty faculty) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.faculty = faculty;
        this.students = new ArrayList<>();
        this.faculty.assignCourse(this);
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public String getCourseName() {
        return courseName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public List<Student> getStudents() {
        return students;
    }
}

