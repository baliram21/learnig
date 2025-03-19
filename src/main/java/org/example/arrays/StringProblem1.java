package org.example.arrays;

public class StringProblem1 {
    public static void main(String[] args) {
        String str = "abcadeaf";  // o/p- 1bc2de3f
        char targetChar= 'a';
        if (str.indexOf(targetChar)==-1){
            System.out.println("given character not present in string");
            return;
        }
        int count=1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==targetChar){
               str= str.replaceFirst(String.valueOf(targetChar),String.valueOf(count));
                ++count;
            }
        }
        System.out.println(str);

    }
}
