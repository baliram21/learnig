package other.baliram.java8;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private int deptId;

    public Employee(int id, String name, double salary, int deptId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.deptId = deptId;
    }

    public double getSalary() {
        return salary;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getName() {
        return name;
    }
}