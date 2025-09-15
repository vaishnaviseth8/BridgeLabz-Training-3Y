package EncapsulationPolymorphismInterfaceAbstractClass;

import java.util.*;

interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    protected void setDepartment(String department) {
        this.department = department;
    }

    protected String getDepartment() {
        return department;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + (department == null ? "Not Assigned" : department));
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Calculated Salary: $" + calculateSalary());
    }
}

class FullTimeEmployee extends Employee implements Department {
    public FullTimeEmployee(String employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }

    @Override
    public void assignDepartment(String departmentName) {
        setDepartment(departmentName);
    }

    @Override
    public String getDepartmentDetails() {
        return getDepartment();
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(String employeeId, String name, double hourlyRate, int workHours) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * workHours;
    }

    @Override
    public void assignDepartment(String departmentName) {
        setDepartment(departmentName);
    }

    @Override
    public String getDepartmentDetails() {
        return getDepartment();
    }
}

class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        FullTimeEmployee fte1 = new FullTimeEmployee("F1001", "Alice Johnson", 60000);
        fte1.assignDepartment("Finance");
        PartTimeEmployee pte1 = new PartTimeEmployee("P2001", "Bob Smith", 20, 120);
        pte1.assignDepartment("Marketing");
        employees.add(fte1);
        employees.add(pte1);
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("-----------------------");
        }
    }
}

