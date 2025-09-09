package JavaConstructor;

class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends Student {
    private String researchTopic;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchTopic) {
        super(rollNumber, name, CGPA);
        this.researchTopic = researchTopic;
    }

    public void displayDetails() {
        System.out.println("Roll Number   : " + rollNumber);
        System.out.println("Name          : " + name); // Accessing protected member
        System.out.println("CGPA          : " + getCGPA()); // Using public getter
        System.out.println("Research Topic: " + researchTopic);
    }
}

