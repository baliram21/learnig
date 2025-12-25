package org.nayan.srings;

public class StringMethods {
    public static void main(String[] args) {
        String str = "hello";

        System.out.println(str+10);
        System.out.println(10+8+str);
        System.out.println(10+str+5);
        System.out.println(str+10+5);
        System.out.println(str+10/5);
       // System.out.println(str+10-5);

        String s1 = "hello";
        String s2 = "world";
        System.out.println(s1+s2);
        System.out.println(s1.concat(s2));
        System.out.println(String.join("-",s1,s2));
        System.out.println(String.join("",s1,s2));
        System.out.println(String.join(s1,s2));

        String s = new String("nayan");
        String s3 = "nayan";
        String s4 = new String("nayan");
        //how many object how ??
        System.out.println(s==s3);
        System.out.println(s.equals(s3));
        System.out.println(s==s4);
        System.out.println(s3==s4);
        System.out.println(s.intern()==s3);
    }
    //why string is immutable in java
}
