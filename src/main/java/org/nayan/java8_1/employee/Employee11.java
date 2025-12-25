package org.nayan.java8_1.employee;

import java.time.LocalDate;

class Employee11 {
    private int id;
    private String name;
    private String gender;
    private String role;
    private String department;
    private LocalDate doj; // date of joining
    private double salary;
    private int age;

    public Employee11(int id, String name, String gender, String role, String department, LocalDate doj, double salary, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.role = role;
        this.department = department;
        this.doj = doj;
        this.salary = salary;
        this.age = age;
    }

    // getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getRole() { return role; }
    public String getDepartment() { return department; }
    public LocalDate getDoj() { return doj; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Employee11{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", department='" + department + '\'' +
                ", doj=" + doj +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}