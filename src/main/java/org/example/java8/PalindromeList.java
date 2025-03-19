package org.example.java8;

import java.util.List;
import java.util.stream.IntStream;

public class PalindromeList {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 2, 1);

        // Check if list is palindrome
        boolean isPalindrome = IntStream.range(0, list.size() / 2)
                .allMatch(i -> list.get(i).equals(list.get(list.size() - 1 - i)));

        System.out.println("Is the list a palindrome? " + isPalindrome); // Output: true
    }
}
