package Inheritance;

public class Patient {
    static String hospitalName = "Sunrise Multispeciality Hospital";
    static int totalPatients = 0;

    private String name;
    private int age;
    private String ailment;
    private final String patientID;

    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Vaishnavi", 25, "Fever", "P1001");
        Patient p2 = new Patient("Ravi", 40, "Back Pain", "P1002");

        p1.displayPatientDetails();
        p2.displayPatientDetails();

        Patient.getTotalPatients();
    }
}

