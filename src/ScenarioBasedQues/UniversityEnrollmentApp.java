package ScenarioBasedQues;

public class UniversityEnrollmentApp {
    public static void main(String[] args) {
        Faculty profSmith = new Faculty("Dr. Smith", "F123");
        Course math101 = new Course("Math 101", profSmith);

        UndergraduateStudent student1 = new UndergraduateStudent("Alice", "S1001");
        PostgraduateStudent student2 = new PostgraduateStudent("Bob", "S2001", new String[]{"AI", "ML"});

        Enrollment enrollment1 = new Enrollment(student1, math101);
        Enrollment enrollment2 = new Enrollment(student2, math101);

        Graded letterGrade = new LetterGrading();
        Graded passFailGrade = new PassFailGrading();

        letterGrade.assignGrade(enrollment1, "A");
        passFailGrade.assignGrade(enrollment2, "Pass");

        System.out.println(student1.getTranscript());
        System.out.println(student2.getTranscript());
    }
}

interface Graded {
    void assignGrade(Enrollment enrollment, String grade);
}

class Person {
    private String name;
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

class Student extends Person {
    private double gpa;
    private String transcript = "";

    public Student(String name, String id) {
        super(name, id);
        this.gpa = 0.0;
    }

    protected void updateGPA(double gradePoint) {
        // Simplified GPA calculation: average of grades
        gpa = (gpa + gradePoint) / 2;
    }

    public String getTranscript() {
        return "Transcript for " + getName() + ": " + transcript + ", GPA: " + String.format("%.2f", gpa);
    }

    protected void addToTranscript(String entry) {
        transcript += entry + "; ";
    }
}

class UndergraduateStudent extends Student {
    private String[] electivePreferences;

    public UndergraduateStudent(String name, String id) {
        super(name, id);
    }

    public UndergraduateStudent(String name, String id, String[] electivePreferences) {
        super(name, id);
        this.electivePreferences = electivePreferences;
    }

    public String[] getElectivePreferences() {
        return electivePreferences;
    }
}

class PostgraduateStudent extends Student {
    private String[] electivePreferences;

    public PostgraduateStudent(String name, String id) {
        super(name, id);
    }

    public PostgraduateStudent(String name, String id, String[] electivePreferences) {
        super(name, id);
        this.electivePreferences = electivePreferences;
    }

    public String[] getElectivePreferences() {
        return electivePreferences;
    }
}

class Faculty extends Person {
    public Faculty(String name, String id) {
        super(name, id);
    }
}

class Course {
    private String courseName;
    private Faculty faculty;
    private java.util.List<Student> enrolledStudents = new java.util.ArrayList<>();

    public Course(String courseName, Faculty faculty) {
        this.courseName = courseName;
        this.faculty = faculty;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public String getCourseName() {
        return courseName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public java.util.List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}

class Enrollment {
    private Student student;
    private Course course;
    private String grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.course.enrollStudent(student);
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
        student.addToTranscript(course.getCourseName() + ": " + grade);
    }
}

// Grading strategies:

class LetterGrading implements Graded {
    @Override
    public void assignGrade(Enrollment enrollment, String grade) {
        enrollment.setGrade(grade);
        double gradePoint = convertLetterToPoint(grade);
        enrollment.getStudent().updateGPA(gradePoint);
    }

    private double convertLetterToPoint(String grade) {
        switch (grade.toUpperCase()) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
            default: return 0.0;
        }
    }
}

class PassFailGrading implements Graded {
    @Override
    public void assignGrade(Enrollment enrollment, String grade) {
        enrollment.setGrade(grade);
        double gradePoint = grade.equalsIgnoreCase("Pass") ? 4.0 : 0.0;
        enrollment.getStudent().updateGPA(gradePoint);
    }
}

