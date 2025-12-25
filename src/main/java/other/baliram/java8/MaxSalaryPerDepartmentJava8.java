package other.baliram.java8;

import java.util.*;
import java.util.stream.Collectors;

/*
 =====================================================
  PROBLEM:
  --------
  There are two different classes:
  1) Employee   -> id, name, salary, deptId
  2) Department -> deptId, deptName

  Requirement:
  -------------
  Find the MAX salary from each department using Java 8
  (similar to SQL JOIN + GROUP BY + MAX)

 =====================================================
  SQL EQUIVALENT:
  ---------------
  SELECT d.dept_name, MAX(e.salary)
  FROM employee e
  JOIN department d
  ON e.dept_id = d.dept_id
  GROUP BY d.dept_name;
 =====================================================
*/

public class MaxSalaryPerDepartmentJava8 {

    public static void main(String[] args) {

        /*
         =====================================================
          1. EMPLOYEE DATA
         =====================================================
        */
        List<Employee> employees = List.of(
                new Employee(1, "A", 5000, 1),
                new Employee(2, "B", 7000, 1),
                new Employee(3, "C", 4000, 2),
                new Employee(4, "D", 9000, 2),
                new Employee(5, "E", 6000, 3)
        );

        /*
         =====================================================
          2. DEPARTMENT DATA
         =====================================================
        */
        List<Department> departments = List.of(
                new Department(1, "IT"),
                new Department(2, "HR"),
                new Department(3, "OPS")
        );

        /*
         =====================================================
          3. CONVERT DEPARTMENT LIST TO MAP
             (Acts like SQL JOIN condition)
             deptId -> deptName
         =====================================================
        */
        Map<Integer, String> deptMap =
                departments.stream()
                           .collect(Collectors.toMap(
                                   Department::getDeptId,
                                   Department::getDeptName
                           ));

        /*
         =====================================================
          4. MAX SALARY PER DEPARTMENT
             Output: Department Name -> Max Salary
         =====================================================
        */
        Map<String, Double> maxSalaryPerDept =
                employees.stream()
                         .collect(Collectors.groupingBy(
                                 e -> deptMap.get(e.getDeptId()), // JOIN logic
                                 Collectors.collectingAndThen(
                                         Collectors.maxBy(
                                                 Comparator.comparingDouble(Employee::getSalary)
                                         ),
                                         emp -> emp.get().getSalary()
                                 )
                         ));

        System.out.println("===== MAX SALARY PER DEPARTMENT =====");
        maxSalaryPerDept.forEach((dept, salary) ->
                System.out.println(dept + " -> " + salary)
        );

        /*
         =====================================================
          5. MAX SALARY EMPLOYEE PER DEPARTMENT
             Output: Department -> Employee Name -> Salary
         =====================================================
        */
        Map<String, Employee> maxSalaryEmployeePerDept =
                employees.stream()
                         .collect(Collectors.groupingBy(
                                 e -> deptMap.get(e.getDeptId()),
                                 Collectors.collectingAndThen(
                                         Collectors.maxBy(
                                                 Comparator.comparingDouble(Employee::getSalary)
                                         ),
                                         Optional::get
                                 )
                         ));

        System.out.println("\n===== MAX SALARY EMPLOYEE PER DEPARTMENT =====");
        maxSalaryEmployeePerDept.forEach((dept, emp) ->
                System.out.println(
                        dept + " -> " + emp.getName() + " : " + emp.getSalary()
                )
        );
    }
}


