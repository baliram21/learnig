package org.nayan.recursion;

public class ReverseWordsRecursion {

    public static String reverseWords(String sentence) {
        String[] arr = sentence.split(" ", 2);

        if (arr.length == 1) {
            return arr[0];
        }

        return reverseWords(arr[1]) + " " + arr[0];
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("I love Java"));
        // Java love I
    }
}
