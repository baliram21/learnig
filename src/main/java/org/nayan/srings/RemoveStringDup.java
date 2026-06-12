package org.nayan.srings;

public class RemoveStringDup {
    public static void main(String[] args) {
        String str = "abcddce";
        String str2 = remove_algo(str);
        System.out.println(str2); // Output: abe
    }

    private static String remove_algo(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int[] charCount = new int[256]; // Assuming ASCII characters

        // Count occurrences of each character
        for (char c : charArray) {
            charCount[c]++;
        }

        // Collect unique characters
        for (char c : charArray) {
            if (charCount[c] == 1) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
    }
