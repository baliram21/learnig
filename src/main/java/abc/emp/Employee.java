package abc.emp;

public class Employee {
    private Long id;
    private String EmpName;
    private Double salary;
    private Department department;

    public Employee(Long id, String EmpName, Double salary, Department department) {
        this.id = id;
        this.EmpName = EmpName;
        this.salary = salary;
        this.department = department;
    }
// getters, setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
