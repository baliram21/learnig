package org.nayan.java8_1;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        List<Employee11> emp = new ArrayList<>();

        // Adding 15 Employee objects to the list with doj as strings
        emp.add(new Employee11(1, "John Doe", "Male", "Manager", "Sales", "2020-02-04", 50000, 35));
        emp.add(new Employee11(2, "Jane Smith", "Female", "Software Engineer", "IT", "2013-09-05", 60000, 40));
        emp.add(new Employee11(3, "David Johnson", "Male", "HR Manager", "Human Resources", "2018-07-15", 55000, 30));
        emp.add(new Employee11(4, "Emily Brown", "Female", "Accountant", "Finance", "2019-11-20", 48000, 38));
        emp.add(new Employee11(5, "Michael Wilson", "Male", "Marketing Manager", "Marketing", "2021-03-10", 52000, 45));
        emp.add(new Employee11(6, "Emma Taylor", "Female", "Project Manager", "IT", "2017-05-12", 65000, 33));
        emp.add(new Employee11(7, "Daniel Lee", "Male", "Sales Executive", "Sales", "2016-08-28", 47000, 37));
        emp.add(new Employee11(8, "Olivia Anderson", "Female", "Analyst", "Finance", "2022-01-25", 51000, 42));
        emp.add(new Employee11(9, "William Martinez", "Male", "Customer Support", "Support", "2023-04-02", 45000, 32));
        emp.add(new Employee11(10, "Sophia Garcia", "Female", "Software Developer", "IT", "2015-10-09", 70000, 39));
        emp.add(new Employee11(11, "Alexander Hernandez", "Male", "Marketing Coordinator", "Marketing", "2014-12-18", 49000, 41));
        emp.add(new Employee11(12, "Mia Lopez", "Female", "Recruiter", "Human Resources", "2020-06-30", 53000, 34));
        emp.add(new Employee11(13, "James Perez", "Male", "Quality Assurance", "IT", "2018-09-21", 58000, 36));
        emp.add(new Employee11(14, "Charlotte King", "Female", "Business Development Manager", "Sales", "2019-04-14", 62000, 44));
        emp.add(new Employee11(15, "Benjamin Wright", "Male", "Financial Analyst", "Finance", "2016-02-08", 59000, 47));




        //===============================================================================

        // Query 1 : How many male and female employees are there in the organization?
        Map<String, Long> collect = emp.stream().collect(Collectors.groupingBy(Employee11::getGender,Collectors.counting()));
        System.out.println(collect);
        // Query 2 : Print the name of all departments in the organization?
        emp.stream().map(Employee11::getDepartment).distinct().forEach(System.out::println);
        // Query 3 : What is the average salary of male and female employees?
        Map<String, Double> collect1 = emp.stream().collect(Collectors.groupingBy(Employee11::getGender,
                Collectors.averagingDouble(Employee11::getSalary)));
        System.out.println(collect1);
        // Query 5 : Get the names of all employees who have joined after 2022?
        //List<Employee> collect2 = emp.stream().filter(e -> e.getDoj() >= "2022").collect(Collectors.toList());
        // Query 6 : Count the number of employees in each department?

        // Query 7 : What is the average salary of each department?
        // Query 8 : Get the details of youngest male employee in the  IT department?
        Employee11 employee11 = emp.stream().filter(e -> e.getDepartment() == "IT")
                .max(Comparator.comparingInt(Employee11::getAge)).get();
        System.out.println(employee11.getName());
        // Query 9 : Who has the most working experience in the organization?
        // Query 9 : Who has the least working experience in the organization?
        // Query 10 : How many male and female employees are there in the sales and marketing team?
        // Query 11 : find oldest employee name from each department
    }
}
