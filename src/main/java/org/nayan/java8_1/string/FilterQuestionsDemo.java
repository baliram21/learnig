package org.nayan.java8_1.string;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterQuestionsDemo {

    public static void main(String[] args) {

        String[] arr = {"abc", "", "ABC", "def", "  ", "abc", "DEF", null, "ghi", "GHI"};

        // -------------------------------------------------------------------------
        // 1️⃣ QUESTION: How to remove duplicates while filtering?
        // -------------------------------------------------------------------------
        String[] q1 = Arrays.stream(arr)
                .filter(Objects::nonNull)
                .filter(s -> !s.isBlank())
                .distinct()
                .toArray(String[]::new);

        /* Expected Output:
           [abc, ABC, def, ghi, GHI]
        */
        System.out.println("Q1 Output: " + Arrays.toString(q1));

        // -------------------------------------------------------------------------
        // 2️⃣ QUESTION: How to remove duplicates (case-insensitive)?
        // -------------------------------------------------------------------------
        Set<String> seenLower = new HashSet<>();
        String[] q2 = Arrays.stream(arr)
                .filter(Objects::nonNull)
                .filter(s -> !s.isBlank())
                .filter(s -> seenLower.add(s.toLowerCase()))
                .toArray(String[]::new);

        /* Expected Output:
           [abc, def, ghi]
           Because: abc == ABC, def == DEF, ghi == GHI
        */
        System.out.println("Q2 Output: " + Arrays.toString(q2));

        // -------------------------------------------------------------------------
        // 3️⃣ QUESTION: How to remove duplicates using distinctByKey?
        // -------------------------------------------------------------------------
        String[] q3 = Arrays.stream(arr)
                .filter(distinctByKey(String::toLowerCase))
                .toArray(String[]::new);

        /* Expected Output:
           [abc, "", "def", "  ", null, "ghi"]
           Note: No filtering of blanks/null here — only distinct by lowercase.
        */
        System.out.println("Q3 Output: " + Arrays.toString(q3));

        // -------------------------------------------------------------------------
        // 4️⃣ QUESTION: How to filter using Predicate chaining?
        // -------------------------------------------------------------------------
        Predicate<String> nonNull = Objects::nonNull;
        Predicate<String> notBlank = s -> !s.isBlank();
        Predicate<String> finalPredicate = nonNull.and(notBlank);

        String[] q4 = Arrays.stream(arr)
                .filter(finalPredicate)
                .distinct()
                .toArray(String[]::new);

        /* Expected Output:
           [abc, ABC, def, ghi, GHI]
        */
        System.out.println("Q4 Output: " + Arrays.toString(q4));

        // -------------------------------------------------------------------------
        // 5️⃣ QUESTION: How to remove blank or empty strings?
        // -------------------------------------------------------------------------
        String[] q5 = Arrays.stream(arr)
                .filter(Objects::nonNull)
                .filter(s -> !s.isBlank())
                .toArray(String[]::new);

        /* Expected Output:
           [abc, ABC, def, abc, DEF, ghi, GHI]
        */
        System.out.println("Q5 Output: " + Arrays.toString(q5));

        // -------------------------------------------------------------------------
        // 6️⃣ QUESTION: How to remove null values safely in streams?
        // -------------------------------------------------------------------------
        String[] q6 = Arrays.stream(arr)
                .filter(Objects::nonNull)
                .toArray(String[]::new);

        /* Expected Output:
           [abc, "", ABC, def,   , abc, DEF, ghi, GHI]
        */
        System.out.println("Q6 Output: " + Arrays.toString(q6));

        // -------------------------------------------------------------------------
        // 7️⃣ QUESTION: Difference between isEmpty() and isBlank() filtering
        // -------------------------------------------------------------------------
        String[] blankTest = {"", "  ", "abc"};

        String[] emptyFiltered = Arrays.stream(blankTest)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        String[] blankFiltered = Arrays.stream(blankTest)
                .filter(s -> !s.isBlank())
                .toArray(String[]::new);

        /* Expected:
           Using isEmpty(): ["  ", "abc"]
           Using isBlank(): ["abc"]
        */
        System.out.println("Q7 isEmpty Output: " + Arrays.toString(emptyFiltered));
        System.out.println("Q7 isBlank Output: " + Arrays.toString(blankFiltered));

        // -------------------------------------------------------------------------
        // 8️⃣ QUESTION: How to remove blank spaces using regex?
        // -------------------------------------------------------------------------
        String regexResult = " j  av  a ".replaceAll("\\s+", "");

        /* Expected Output:
           java
        */
        System.out.println("Q8 Output: " + regexResult);

        // -------------------------------------------------------------------------
        // 9️⃣ QUESTION: How to remove spaces using replaceAll(" ", "")?
        // -------------------------------------------------------------------------
        String replaceAllResult = " j  av  a ".replaceAll(" ", "");

        /* Expected Output:
           java
        */
        System.out.println("Q9 Output: " + replaceAllResult);
    }

    // Supporting distinct-by-key predicate
    public static <T> Predicate<T> distinctByKey(java.util.function.Function<? super T, ?> keyExtractor) {
        Set<Object> seen = new HashSet<>();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
