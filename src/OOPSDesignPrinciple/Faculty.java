package OOPSDesignPrinciple;

import java.util.ArrayList;
import java.util.List;

class Faculty {
    String name;
    public Faculty(String name) {
        this.name = name;
    }
    public String toString() {
        return "Faculty: " + name;
    }
}

class Department {
    String name;
    public Department(String name) {
        this.name = name;
    }
    public String toString() {
        return "Department: " + name;
    }
}

class University {
    String name;
    List<Department> departments;
    List<Faculty> facultyMembers;
    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }
    public void addDepartment(Department d) {
        departments.add(d);
    }
    public void addFaculty(Faculty f) {
        facultyMembers.add(f);
    }
    public void showStructure() {
        System.out.println("University: " + name);
        for (Department d : departments) {
            System.out.println(" - " + d);
        }
        for (Faculty f : facultyMembers) {
            System.out.println(" * " + f);
        }
    }
    public void deleteUniversity() {
        departments.clear();
        facultyMembers.clear();
        System.out.println("University '" + name + "' deleted. Departments removed. Faculty not deleted.");
    }
}

public class Main {
    public static void main(String[] args) {
        Faculty f1 = new Faculty("Dr. Smith");
        Faculty f2 = new Faculty("Dr. Johnson");
        University uni = new University("Tech University");
        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Physics");
        uni.addDepartment(d1);
        uni.addDepartment(d2);
        uni.addFaculty(f1);
        uni.addFaculty(f2);
        uni.showStructure();
        uni.deleteUniversity();
        System.out.println(f1 + " still exists.");
        System.out.println(f2 + " still exists.");
    }
}

