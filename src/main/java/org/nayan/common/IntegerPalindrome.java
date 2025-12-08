package org.nayan.common;

public class IntegerPalindrome {
    public static void main(String[] args) {
        int n = 12122;

        int temp = n;
        int rev = 0;

        while (temp>0){
            int rem = temp%10;
            rev = rev*10 + rem;
            temp = temp/10;
        }

        if (rev==n){
            System.out.println("palindrome");
        }else {
            System.out.println("not palindrome");
        }
    }
}
