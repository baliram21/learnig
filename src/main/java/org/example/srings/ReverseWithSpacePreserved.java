package org.example.srings;

public class ReverseWithSpacePreserved {
    public static void main(String[] args) {
        String input = "I am Java Developer";
        char[] inputChars = input.toCharArray();
        char[] result = new char[input.length()];

        // First, mark spaces in result array
        for (int i = 0; i < input.length(); i++) {
            if (inputChars[i] == ' ') {
                result[i] = ' ';  // Preserve space positions
            }
        }

        // Now, reverse characters (excluding spaces)
        int j = input.length() - 1;
        for (int i = 0; i < input.length(); i++) {
            if (inputChars[i] != ' ') {
                // Move j back to the next non-space character
                while (result[j] == ' ') {
                    j--;
                }
                result[j] = inputChars[i];
                j--;
            }
        }

        System.out.println("Output = " + new String(result));
    }
}

/*
===== Output =====
Output = r ep olev eDavajamI
*/
