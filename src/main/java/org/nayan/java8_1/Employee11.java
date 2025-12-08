package org.nayan.java8_1;

public class Employee11 {
    private int id;
    private String name;
    private String gender;
    private String designation;
    private String department;
    private String doj; // Date of Joining
    private double salary;
    private int age;

    public Employee11() {
    }

    // Constructor
    public Employee11(int id, String name, String gender, String designation, String department, String doj, double salary, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.designation = designation;
        this.department = department;
        this.doj = doj;
        this.salary = salary;
        this.age=age;

    }

    // Getter and setter methods for id

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for gender
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter and setter methods for designation
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    // Getter and setter methods for department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Getter and setter methods for doj
    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    // Getter and setter methods for salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", designation='" + designation + '\'' +
                ", department='" + department + '\'' +
                ", doj=" + doj +
                ", salary=" + salary +
                '}';
    }
}
