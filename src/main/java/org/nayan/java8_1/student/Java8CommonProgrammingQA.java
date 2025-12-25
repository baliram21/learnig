package org.nayan.java8_1.student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8CommonProgrammingQA {

    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929")),
                new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList("+912632632762", "+1673434723929")),
                new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164, Arrays.asList("+912632633882", "+1673434709929")),
                new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26, Arrays.asList("+9126325832782", "+1671434729929")),
                new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, Arrays.asList("+012632632782")),
                new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90, Arrays.asList("+9126254632782", "+16736784729929")),
                new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324, Arrays.asList("+912632632782", "+1671234729929")),
                new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList("+9126326355782", "+1673434729929")),
                new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
                new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98, Arrays.asList("+912632646482", "+16734323229929")))
                .collect(Collectors.toList());

        System.out.println("==== Q1: Students with rank between 50 and 100 (inclusive) ====");
        List<Student> q1 = studentList.stream()
                .filter(s -> s.getRank() >= 50 && s.getRank() <= 100)   // inclusive
                .collect(Collectors.toList());
        q1.forEach(System.out::println);

        System.out.println("\n==== Q2: Students who stay in Karnataka, sorted by name (ascending) ====");
        List<Student> q2 = studentList.stream()
                .filter(s -> "Karnataka".equalsIgnoreCase(s.getCity()))
                .sorted(Comparator.comparing(Student::getFirstName)) // ascending
                .collect(Collectors.toList());
        q2.forEach(System.out::println);

        System.out.println("\n==== Q2.1: Students who stay in Karnataka, sorted by name (descending) ====");
        List<Student> que2 = studentList.stream()
                .filter(s -> "Karnataka".equalsIgnoreCase(s.getCity()))
                .sorted(Comparator.comparing(Student::getFirstName).reversed()) // descending
                .collect(Collectors.toList());

        que2.forEach(System.out::println);


        System.out.println("\n==== Q3: All department names (distinct) ====");
        List<String> deptNames = studentList.stream()
                .map(Student::getDept)
                .distinct()
                .collect(Collectors.toList());
        deptNames.forEach(System.out::println);

        System.out.println("\n==== Q4: All distinct contact numbers (flattened) ====");
        List<String> contacts = studentList.stream()
                .flatMap(s -> s.getContacts().stream())
                .distinct()
                .collect(Collectors.toList());
        contacts.forEach(System.out::println);

        System.out.println("\n==== Q5: Group students by department ====");
        Map<String, List<Student>> groupByDept = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept));
        groupByDept.forEach((dept, students) -> {
            System.out.println("Dept: " + dept);
            students.forEach(s -> System.out.println("  " + s));
        });

        System.out.println("\n==== Q6: Department with maximum number of students ====");
        Map<String, Long> countByDept = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept, Collectors.counting()));
        // safe extraction of max
        Optional<Map.Entry<String, Long>> maxEntry = countByDept.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        maxEntry.ifPresentOrElse(
                e -> System.out.println("Department with max students: " + e.getKey() + " -> " + e.getValue()),
                () -> System.out.println("No departments found")
        );

        System.out.println("\n==== Q7: Average age by gender ====");
        Map<String, Double> avgAgeByGender = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        avgAgeByGender.forEach((g, avg) -> System.out.println(g + " -> " + avg));

        System.out.println("\n==== Q8: Highest (best) rank in each department ====");
        // Since rank 1 is best, we use minBy to get the best rank per dept
        Map<String, Optional<Student>> bestByDeptOptional = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept,
                        Collectors.minBy(Comparator.comparingInt(Student::getRank))));
        bestByDeptOptional.forEach((dept, optStudent) ->
                System.out.println(dept + " -> " + optStudent.map(Student::toString).orElse("N/A")));

        System.out.println("\n==== Q9: Student who has second rank (i.e., rank == 2). Fallback: 2nd element when sorted by rank asc ====");
        // Preferred: find rank == 2
        Optional<Student> rank2 = studentList.stream()
                .filter(s -> s.getRank() == 2)
                .findFirst();

        if (rank2.isPresent()) {
            System.out.println("Found by direct rank == 2: " + rank2.get());
        } else {
            // fallback to second in sorted order (if exists)
            Optional<Student> secondInOrder = studentList.stream()
                    .sorted(Comparator.comparingInt(Student::getRank))
                    .skip(1)   // skip(1) to get 2nd element (0-based)
                    .findFirst();
            System.out.println("Fallback (2nd by sorted rank): " + secondInOrder.orElse(null));
        }

        System.out.println("\n==== Q10: Highest (best) rank in each department, then sort departments by that rank (ascending) ====");
        // Map dept -> best student (min rank)
        Map<String, Student> bestByDept = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(Student::getRank)),
                                opt -> opt.orElse(null)
                        )));

        // Sort departments by their best rank (ascending)
        bestByDept.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .sorted(Comparator.comparingInt(e -> e.getValue().getRank()))
                .forEach(e -> System.out.println(e.getKey() + " -> Best: " + e.getValue().getFirstName() + " (rank=" + e.getValue().getRank() + ")"));
    }

}