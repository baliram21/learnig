package other.baliram.java8;

import java.util.*;
import java.util.stream.Collectors;

public class SecondHighestSalaryPerDepartment {

    public static void main(String[] args) {

        // ================= EMPLOYEE DATA =================
        List<Employee> employees = List.of(
                new Employee(1, "A", 5000, 1),
                new Employee(2, "B", 7000, 1),
                new Employee(3, "C", 6000, 1),
                new Employee(4, "D", 4000, 2),
                new Employee(5, "E", 9000, 2),
                new Employee(6, "F", 8000, 2),
                new Employee(7, "G", 3000, 3),
                new Employee(8, "H", 6000, 3)
        );

        // ================= DEPARTMENT DATA =================
        List<Department> departments = List.of(
                new Department(1, "IT"),
                new Department(2, "HR"),
                new Department(3, "OPS")
        );

        // ================= DEPT MAP (JOIN) =================
        Map<Integer, String> deptMap =
                departments.stream()
                           .collect(Collectors.toMap(
                                   Department::getDeptId,
                                   Department::getDeptName
                           ));

        /*
         =====================================================
          SECOND HIGHEST SALARY EMPLOYEE PER DEPARTMENT
         =====================================================
        */
        Map<String, Optional<Employee>> secondHighestPerDept =
                employees.stream()
                         .collect(Collectors.groupingBy(
                                 e -> deptMap.get(e.getDeptId()),   // JOIN
                                 Collectors.collectingAndThen(
                                         Collectors.toList(),
                                         list -> list.stream()
                                                 .sorted(Comparator.comparingDouble(Employee::getSalary)
                                                                   .reversed())
                                                 .skip(1)   // skip highest
                                                 .findFirst()
                                 )
                         ));

        // ================= OUTPUT =================
        System.out.println("===== SECOND HIGHEST SALARY PER DEPARTMENT =====");
        secondHighestPerDept.forEach((dept, empOpt) ->
                empOpt.ifPresent(emp ->
                        System.out.println(
                                dept + " -> " + emp.getName() + " : " + emp.getSalary()
                        )
                )
        );
    }
}

// ================= EMPLOYEE CLASS =================


// ================= DEPARTMENT CLASS =================
