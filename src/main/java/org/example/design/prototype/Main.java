package org.example.design.prototype;

public class Main {
    public static void main(String[] args) {
        Student obj= new Student(1,15,"Nayan");

        System.out.println(obj);

        Student stdObj= (Student) obj.clone();

        System.out.println(stdObj);
    }
}
