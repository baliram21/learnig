package org.nayan.srings.string;

public class RemoveDuplicate {
    public static void main(String[] args) {
        String str="aabbccd";

        // String str1 = remove_java8(str);
        //System.out.println(str1);
        String str2 = remove_algo(str);
        System.out.println(str2);

    }

    private static String remove_algo(String str) {
        char[] charstr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charstr.length-1; i++) {
            boolean isDuplicate=true;
            for (int j = i+1; j < charstr.length; j++) {
                if (charstr[i]==charstr[j] && i!=j){
                    isDuplicate=false;
                    break;
                }
            }
            if (isDuplicate){
                sb.append(i);
            }
        }
        return sb.toString();
    }
    public static String remove_java8(String str){

        StringBuilder sb = new StringBuilder();

        str.chars().distinct().forEach(s->sb.append((char) s));
        return sb.toString();
        // System.out.println(sb);
    }
}
