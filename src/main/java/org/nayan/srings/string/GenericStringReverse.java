package org.nayan.srings.string;

import java.util.function.Predicate;

public class GenericStringReverse {

    public static void main(String[] args) {
        String str = "I Love Java 123";

        // Reverse only letters
        System.out.println(reverseByCondition(str, Character::isLetter));

        // Reverse only vowels
        System.out.println(reverseByCondition(str, GenericStringReverse::isVowel));

        // Reverse characters but keep numbers fixed
        System.out.println(reverseByCondition(str, c -> !Character.isDigit(c)));
    }

    public static String reverseByCondition(String s, Predicate<Character> condition) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (!condition.test(arr[left])) {
                left++;
            } else if (!condition.test(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
