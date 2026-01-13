package org.nayan.srings.string;

public class ReverseCharactersKeepSpaces {
    public static void main(String[] args) {
        String str = "I Love Java";
        System.out.println(reverseOnlyCharacters(str));
    }

    public static String reverseOnlyCharacters(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (arr[left] == ' ') {
                left++;
            } else if (arr[right] == ' ') {
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
}
