package org.nayan.java8_1.employee;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeMainClass {
    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<Employee11> emp = new ArrayList<>();

        // Adding 15 Employee objects to the list with doj as strings (converted to LocalDate)
        emp.add(new Employee11(1, "John Doe", "Male", "Manager", "Sales", LocalDate.parse("2020-02-04", df), 50000, 35));
        emp.add(new Employee11(2, "Jane Smith", "Female", "Software Engineer", "IT", LocalDate.parse("2013-09-05", df), 60000, 40));
        emp.add(new Employee11(3, "David Johnson", "Male", "HR Manager", "Human Resources", LocalDate.parse("2018-07-15", df), 55000, 30));
        emp.add(new Employee11(4, "Emily Brown", "Female", "Accountant", "Finance", LocalDate.parse("2019-11-20", df), 48000, 38));
        emp.add(new Employee11(5, "Michael Wilson", "Male", "Marketing Manager", "Marketing", LocalDate.parse("2021-03-10", df), 52000, 45));
        emp.add(new Employee11(6, "Emma Taylor", "Female", "Project Manager", "IT", LocalDate.parse("2017-05-12", df), 65000, 33));
        emp.add(new Employee11(7, "Daniel Lee", "Male", "Sales Executive", "Sales", LocalDate.parse("2016-08-28", df), 47000, 37));
        emp.add(new Employee11(8, "Olivia Anderson", "Female", "Analyst", "Finance", LocalDate.parse("2022-01-25", df), 51000, 42));
        emp.add(new Employee11(9, "William Martinez", "Male", "Customer Support", "Support", LocalDate.parse("2023-04-02", df), 45000, 32));
        emp.add(new Employee11(10, "Sophia Garcia", "Female", "Software Developer", "IT", LocalDate.parse("2015-10-09", df), 70000, 39));
        emp.add(new Employee11(11, "Alexander Hernandez", "Male", "Marketing Coordinator", "Marketing", LocalDate.parse("2014-12-18", df), 49000, 41));
        emp.add(new Employee11(12, "Mia Lopez", "Female", "Recruiter", "Human Resources", LocalDate.parse("2020-06-30", df), 53000, 34));
        emp.add(new Employee11(13, "James Perez", "Male", "Quality Assurance", "IT", LocalDate.parse("2018-09-21", df), 58000, 36));
        emp.add(new Employee11(14, "Charlotte King", "Female", "Business Development Manager", "Sales", LocalDate.parse("2019-04-14", df), 62000, 44));
        emp.add(new Employee11(15, "Benjamin Wright", "Male", "Financial Analyst", "Finance", LocalDate.parse("2016-02-08", df), 59000, 47));

        System.out.println("---------------------------------------------------");
        // Query 1 : How many male and female employees are there in the organization?
        Map<String, Long> byGenderCount = emp.stream()
                .collect(Collectors.groupingBy(e -> e.getGender().toLowerCase(), Collectors.counting()));
        System.out.println("Q1 - Count by gender: " + byGenderCount);

        System.out.println("---------------------------------------------------");
        // Query 2 : Print the name of all departments in the organization?
        System.out.println("Q2 - Departments:");
        emp.stream()
                .map(Employee11::getDepartment)
                .distinct()
                .forEach(d -> System.out.println(" - " + d));

        System.out.println("---------------------------------------------------");
        // Query 3 : What is the average salary of male and female employees?
        Map<String, Double> avgSalaryByGender = emp.stream()
                .collect(Collectors.groupingBy(e -> e.getGender().toLowerCase(),
                        Collectors.averagingDouble(Employee11::getSalary)));
        System.out.println("Q3 - Average salary by gender: " + avgSalaryByGender);

        System.out.println("---------------------------------------------------");
        // Query 5 : Get the names of all employees who have joined after 2022?
        List<String> joinedAfter2022 = emp.stream()
                .filter(e -> e.getDoj()
                        .isAfter(LocalDate.of(2022, 12, 31)))
                .map(Employee11::getName)
                .toList();
        System.out.println("Q5 - Employees joined after 2022: " + joinedAfter2022);

        System.out.println("---------------------------------------------------");
        // Query 6 : Count the number of employees in each department?
        Map<String, Long> countByDept = emp.stream()
                .collect(Collectors.groupingBy(Employee11::getDepartment, Collectors.counting()));
        System.out.println("Q6 - Count by department: " + countByDept);

        System.out.println("---------------------------------------------------");
        // Query 7 : What is the average salary of each department?
        Map<String, Double> avgSalaryByDept = emp.stream()
                .collect(Collectors.groupingBy(Employee11::getDepartment, Collectors.averagingDouble(Employee11::getSalary)));
        System.out.println("Q7 - Average salary by department: " + avgSalaryByDept);

        System.out.println("---------------------------------------------------");
        // Query 8 : Get the details of youngest male employee in the IT department?
        Optional<Employee11> youngestMaleInIT = emp.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("IT"))
                .filter(e -> e.getGender().equalsIgnoreCase("Male"))
                .min(Comparator.comparingInt(Employee11::getAge)); // youngest -> min age
        System.out.println("Q8 - Youngest male in IT: " + youngestMaleInIT.orElse(null));

        System.out.println("---------------------------------------------------");
        // Query 9 : Who has the most working experience in the organization?
        // We'll compute experience in years from DOJ to now.
        Optional<Employee11> mostExperienced = emp.stream()
                .min(Comparator.comparing(Employee11::getDoj)); // earliest doj -> most experience
        Optional<Employee11> leastExperienced = emp.stream()
                .max(Comparator.comparing(Employee11::getDoj)); // latest doj -> least experience

        mostExperienced.ifPresent(e -> System.out.printf("Q9 - Most experienced: %s (%d years)%n",
                e.getName(), yearsOfExperience(e.getDoj())));
        leastExperienced.ifPresent(e -> System.out.printf("Q9 - Least experienced: %s (%d years)%n",
                e.getName(), yearsOfExperience(e.getDoj())));

        System.out.println("---------------------------------------------------");
        // Query 10 : How many male and female employees are there in the sales and marketing team?
        Map<String, Map<String, Long>> genderCountInSalesMarketing = emp.stream()
                .filter(e -> e.getDepartment()
                        .equalsIgnoreCase("Sales") || e.getDepartment().equalsIgnoreCase("Marketing"))
                .collect(Collectors.groupingBy(
                        Employee11::getDepartment,
                        Collectors.groupingBy(e -> e.getGender().toLowerCase(), Collectors.counting())
                ));
        System.out.println("Q10 - Gender count in Sales and Marketing: " + genderCountInSalesMarketing);

        System.out.println("---------------------------------------------------");
        // Query 11 : find oldest employee name from each department
        Map<String, Optional<Employee11>> oldestByDeptOptional = emp.stream()
                .collect(Collectors.groupingBy(Employee11::getDepartment,
                        Collectors.maxBy(Comparator.comparingInt(Employee11::getAge))));

        Map<String, String> oldestByDept = oldestByDeptOptional.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().map(Employee11::getName).orElse("N/A")
                ));
        System.out.println("Q11 - Oldest employee in each department: " + oldestByDept);

        System.out.println("---------------------------------------------------");
        // Extra: Print each employee with computed years of experience
        System.out.println("Employees with years of experience:");
        emp.forEach(e -> System.out.printf(" - %s | Dept: %s | DOJ: %s | Exp: %d years%n",
                e.getName(), e.getDepartment(), e.getDoj(), yearsOfExperience(e.getDoj())));
    }

    private static int yearsOfExperience(LocalDate doj) {
        return Period.between(doj, LocalDate.now()).getYears();
    }
}
