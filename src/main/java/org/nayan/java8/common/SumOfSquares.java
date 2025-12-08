package org.nayan.java8.common;

import java.util.List;

public class SumOfSquares {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        // Calculate the sum of squares of even numbers
        int sumOfSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();

        System.out.println("Sum of squares of even numbers: " + sumOfSquares);
    }
}
