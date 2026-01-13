package org.nayan.srings.string;

public class ReverseOnlyCharacters {
    public static void main(String[] args) {
        String str = "a-bC-dEf-ghIj";   //j-Ih-gfE-dCba

        //  String str = "I Love Java";  // output- a vaJe voLI (keep the space in place)
        System.out.println(reverseOnlyLetters(str));
    }

    public static String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (!Character.isLetter(arr[left])) {
                left++;
            } else if (!Character.isLetter(arr[right])) {
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
