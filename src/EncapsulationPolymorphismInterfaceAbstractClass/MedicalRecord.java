package EncapsulationPolymorphismInterfaceAbstractClass;

import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> medicalHistory = new ArrayList<>();
    private String diagnosis;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate, String diagnosis) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.diagnosis = diagnosis;
    }

    public int getDaysAdmitted() {
        return daysAdmitted;
    }

    public void setDaysAdmitted(int daysAdmitted) {
        this.daysAdmitted = daysAdmitted;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return Collections.unmodifiableList(medicalHistory);
    }

    @Override
    public String getPatientDetails() {
        return super.getPatientDetails() + ", Diagnosis: " + diagnosis + ", Days Admitted: " + daysAdmitted;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalHistory = new ArrayList<>();
    private String diagnosis;

    public OutPatient(String patientId, String name, int age, double consultationFee, String diagnosis) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.diagnosis = diagnosis;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return Collections.unmodifiableList(medicalHistory);
    }

    @Override
    public String getPatientDetails() {
        return super.getPatientDetails() + ", Diagnosis: " + diagnosis;
    }
}

class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        InPatient inpatient = new InPatient("P001", "Alice", 45, 10, 300, "Pneumonia");
        inpatient.addRecord("Initial checkup complete");
        inpatient.addRecord("X-Ray performed");

        OutPatient outpatient = new OutPatient("P002", "Bob", 30, 100, "Flu");
        outpatient.addRecord("Consulted for fever and cough");

        patients.add(inpatient);
        patients.add(outpatient);

        for (Patient p : patients) {
            System.out.println(p.getPatientDetails());
            System.out.println("Bill: $" + p.calculateBill());
            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord) p;
                System.out.println("Medical Records:");
                for (String record : mr.viewRecords()) {
                    System.out.println("- " + record);
                }
            }
            System.out.println("-------------------------");
        }
    }
}

