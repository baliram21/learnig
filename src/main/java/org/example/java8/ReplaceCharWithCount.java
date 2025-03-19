package org.example.java8;

public class ReplaceCharWithCount {
    public static void main(String[] args) {
        String str = "abcadeaf";  // Expected output: 1bc2de3f
        char targetChar = 'a';
        int count = 1;

        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == targetChar) {
                sb.replace(i, i + 1, String.valueOf(count));
                count++;
            }
        }

        System.out.println(sb.toString());
    }
}
