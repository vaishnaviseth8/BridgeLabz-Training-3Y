package OOPSDesignPrinciple;

import java.util.*;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    public void showEmployees() {
        System.out.println("  Employees in " + name + " Department:");
        for (Employee e : employees) {
            System.out.println("   - " + e.getName());
        }
    }

    public void clearEmployees() {
        employees.clear();
    }

    public String getName() {
        return name;
    }
}

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addEmployeeToDepartment(String deptName, String employeeName) {
        for (Department d : departments) {
            if (d.getName().equals(deptName)) {
                d.addEmployee(employeeName);
                return;
            }
        }
    }

    public void showStructure() {
        System.out.println("Company: " + name);
        for (Department d : departments) {
            d.showEmployees();
        }
    }

    public void deleteCompany() {
        for (Department d : departments) {
            d.clearEmployees();
        }
        departments.clear();
        System.out.println("Company " + name + " and all its departments and employees have been deleted.");
    }
}

public class Main {
    public static void main(String[] args) {
        Company myCompany = new Company("TechCorp");

        myCompany.addDepartment("IT");
        myCompany.addDepartment("HR");

        myCompany.addEmployeeToDepartment("IT", "Alice");
        myCompany.addEmployeeToDepartment("IT", "Bob");
        myCompany.addEmployeeToDepartment("HR", "Charlie");

        myCompany.showStructure();

        System.out.println();
        myCompany.deleteCompany();
    }
}

