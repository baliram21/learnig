package org.example.string;

public class Substrings {
    public static void main(String[] args) {
        String str = "abcdefg";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {
                System.out.println(str.substring(i,j));
            }
        }
    }
}
