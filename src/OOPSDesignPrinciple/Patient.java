package OOPSDesignPrinciple;

import java.util.*;

class Patient {
    String name;
    List<Doctor> consultedDoctors = new ArrayList<>();
    public Patient(String name) {
        this.name = name;
    }
    public void addDoctor(Doctor doctor) {
        if (!consultedDoctors.contains(doctor)) {
            consultedDoctors.add(doctor);
        }
    }
    public String toString() {
        return "Patient: " + name;
    }
}

class Doctor {
    String name;
    List<Patient> patientsSeen = new ArrayList<>();
    public Doctor(String name) {
        this.name = name;
    }
    public void consult(Patient patient) {
        System.out.println(name + " is consulting " + patient.name);
        if (!patientsSeen.contains(patient)) {
            patientsSeen.add(patient);
        }
        patient.addDoctor(this);
    }
    public String toString() {
        return "Doctor: " + name;
    }
}

class Hospital {
    String name;
    List<Doctor> doctors;
    List<Patient> patients;
    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }
    public void addDoctor(Doctor d) {
        doctors.add(d);
    }
    public void addPatient(Patient p) {
        patients.add(p);
    }
    public void showData() {
        System.out.println("Hospital: " + name);
        for (Doctor d : doctors) {
            System.out.println(" - " + d);
        }
        for (Patient p : patients) {
            System.out.println(" * " + p);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");
        Doctor doc1 = new Doctor("Dr. Alice");
        Doctor doc2 = new Doctor("Dr. Bob");
        Patient pat1 = new Patient("John");
        Patient pat2 = new Patient("Emily");
        hospital.addDoctor(doc1);
        hospital.addDoctor(doc2);
        hospital.addPatient(pat1);
        hospital.addPatient(pat2);
        doc1.consult(pat1);
        doc1.consult(pat2);
        doc2.consult(pat1);
        hospital.showData();
    }
}

