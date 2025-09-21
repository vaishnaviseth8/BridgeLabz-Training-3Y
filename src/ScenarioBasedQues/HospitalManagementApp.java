package ScenarioBasedQues;

public class HospitalManagementApp {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("Dr. Smith", "D12345", "Cardiology");
        Doctor doctor2 = new Doctor("Dr. Emily", "D67890", "Neurology");

        InPatient patient1 = new InPatient("John Doe", 45, "Flu", "No allergies", doctor1);
        OutPatient patient2 = new OutPatient("Jane Roe", 30, "Headache", "Migraine history", doctor2);

        Bill bill1 = new Bill(patient1, 5000, 10); // 10% discount
        Bill bill2 = new Bill(patient2, 1500, 5);  // 5% discount

        System.out.println(patient1.displayInfo());
        System.out.println(patient2.displayInfo());

        System.out.println("Bill for patient1: " + bill1.calculatePayment());
        System.out.println("Bill for patient2: " + bill2.calculatePayment());
    }
}

interface Payable {
    double calculatePayment();
}

class Patient {
    private String name;
    private int age;
    private String diagnosis;
    private String medicalHistory;
    protected Doctor assignedDoctor;

    public Patient(String name, int age, String diagnosis, String medicalHistory, Doctor assignedDoctor) {
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = medicalHistory;
        this.assignedDoctor = assignedDoctor;
    }

    public String getSummary() {
        return "Name: " + name + ", Age: " + age + ", Diagnosis: " + diagnosis;
    }

    public String displayInfo() {
        return getSummary() + ", Doctor: " + assignedDoctor.getName();
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }
}

class InPatient extends Patient {
    private String roomNumber;

    public InPatient(String name, int age, String diagnosis, String medicalHistory, Doctor assignedDoctor) {
        super(name, age, diagnosis, medicalHistory, assignedDoctor);
        this.roomNumber = "Not assigned";
    }

    public InPatient(String name, int age, String diagnosis, String medicalHistory, Doctor assignedDoctor, String roomNumber) {
        super(name, age, diagnosis, medicalHistory, assignedDoctor);
        this.roomNumber = roomNumber;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Room: " + roomNumber;
    }
}

class OutPatient extends Patient {
    private String appointmentDate;

    public OutPatient(String name, int age, String diagnosis, String medicalHistory, Doctor assignedDoctor) {
        super(name, age, diagnosis, medicalHistory, assignedDoctor);
        this.appointmentDate = "Not scheduled";
    }

    public OutPatient(String name, int age, String diagnosis, String medicalHistory, Doctor assignedDoctor, String appointmentDate) {
        super(name, age, diagnosis, medicalHistory, assignedDoctor);
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Appointment: " + appointmentDate;
    }
}

class Doctor {
    private String name;
    private String licenseNumber;
    private String specialization;

    public Doctor(String name, String licenseNumber, String specialization) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String displayInfo() {
        return "Dr. " + name + ", License: " + licenseNumber + ", Specialization: " + specialization;
    }
}

class Bill implements Payable {
    private Patient patient;
    private double amount;
    private double discountPercent;
    private static final double TAX_RATE = 0.12; // 12% tax

    public Bill(Patient patient, double amount, double discountPercent) {
        this.patient = patient;
        this.amount = amount;
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculatePayment() {
        double discount = amount * discountPercent / 100;
        double subtotal = amount - discount;
        double tax = subtotal * TAX_RATE;
        return subtotal + tax;
    }
}

