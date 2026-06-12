package org.nayan.extra;



import java.util.List;
import java.util.stream.Collectors;

public class IntegerToWord {

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 1, 6, 8, 7, 3, 9, 2);
        List<String> str = list.stream().map(IntegerToWord::intToWord).collect(Collectors.toList());
        System.out.println(str);
    }

    private static String intToWord(int n) {
        return switch (n) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "unknown";
        };
    }
}
