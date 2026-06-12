package abc.emp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        Department it = new Department(1L, "IT");
        Department hr = new Department(2L, "HR");
        Department finance = new Department(3L, "Finance");
        Department ops = new Department(4L, "Operations");

        List<Employee> employees = Arrays.asList(
                new Employee(1L, "Nayan", 5000.0, it),
                new Employee(2L, "Sonu", 7000.0, it),
                new Employee(3L, "Umesh", 6000.0, it),

                new Employee(4L, "Mantu", 3000.0, hr),
                new Employee(5L, "NK", 3000.0, hr),

                new Employee(6L, "BK", 4500.0, finance),
                new Employee(7L, "Amit", 2000.0, finance),

                new Employee(8L, "Onkar", 9000.0, ops),
                new Employee(9L, "Mayur", 8000.0, ops)
        );

        Map<String, Double> salaryMap =
                employees.stream()
                        .collect(Collectors.toMap(
                                e -> e.getDepartment().getDeptName(),
                                Employee::getSalary,
                                Double::max
                        ));


       // System.out.println(salaryMap);

        Map<String, Employee> maxSalaryByDept =
                employees.stream()
                        .collect(Collectors.toMap(
                                e -> e.getDepartment().getDeptName(),
                                e -> e,
                                BinaryOperator.maxBy(
                                        Comparator.comparingDouble(Employee::getSalary)
                                )
                        ));

        maxSalaryByDept.forEach((dept, emp) ->
                System.out.println(dept + " -> " + emp.getEmpName() + " : " + emp.getSalary())
        );


    }
}
