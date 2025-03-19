package org.example.arrays;

public class ToggleString {
    public static void main(String[] args) {
        String str= "NaYaN";   // o/p- nAyAn

        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()){
            if (Character.isUpperCase(ch)){
                sb.append(Character.toLowerCase(ch));
            }else {
                sb.append(Character.toUpperCase(ch));
            }
        }
        String togglestr = sb.toString();

        System.out.println(togglestr);
    }
}
