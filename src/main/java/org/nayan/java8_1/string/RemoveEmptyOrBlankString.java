package org.nayan.java8_1.string;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RemoveEmptyOrBlankString {
    public static void main(String[] args) {

        // Input array with empty strings ("")
        String[] str = {"lld", "", "def", ""};

        // 1️⃣ Convert array to stream → filter out empty strings → collect to List
        List<String> stringList = Arrays.stream(str)
                .filter(s -> !s.isEmpty())     // remove empty ("") strings
                .collect(Collectors.toList());
        System.out.println(stringList);        // Output: [abc, def]

        // 2️⃣ Same filtering, but collecting result as Object[]
        Object[] array = Arrays.stream(str)
                .filter(s -> !s.isEmpty())
                .toArray();                    // returns Object[]
        System.out.println(Arrays.toString(array));  // Output: [abc, def]

        // 3️⃣ Converting to String[] instead of Object[]
        String[] array1 = Arrays.stream(str)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);       // returns String[]
        System.out.println(Arrays.toString(array1)); // Output: [abc, def]


        // New input array with blank spaces ("   ")
        String[] str1 = {"lld", "", "def", "", "   "};

        // 4️⃣ filter using isEmpty() → removes only "" but not "   "
        String[] array2 = Arrays.stream(str1)
                .filter(s -> !s.isEmpty())     // "   " will NOT be removed
                .toArray(String[]::new);
        System.out.println(Arrays.toString(array2)); // Output: [abc, def, "   "]

        // 5️⃣ Using isBlank() → removes both "" and "   "
        String[] array3 = Arrays.stream(str1)
                .filter(s -> !s.isBlank())     // removes empty & blank
                .toArray(String[]::new);
        System.out.println(Arrays.toString(array3)); // Output: [abc, def]


        // New array with null value
        String[] str2 = {"lld", "", "def", "", "   ", null};

        /*
         ❌ Below code would throw NullPointerException because s.isEmpty()
            or s.isBlank() cannot be called on null.
         String[] array4 = Arrays.stream(str2).filter(s -> !s.isEmpty()).toArray(String[]::new);
         String[] array5 = Arrays.stream(str2).filter(s -> !s.isBlank()).toArray(String[]::new);
        */

        // 6️⃣ Correct way: first remove nulls → then remove blank strings
        String[] array6 = Arrays.stream(str2)
                .filter(s -> s != null)        // remove null values first
                .filter(s -> !s.isBlank())     // now safely remove empty & blank
                .toArray(String[]::new);
        System.out.println("Array with null removed = " + Arrays.toString(array6));
        // Output: [abc, def]

        Arrays.stream(str2)
                .filter(Objects::nonNull)
                .filter(s -> !s.isBlank())
                .toArray(String[]::new);
    }
}
