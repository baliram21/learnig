package org.nayan.design_pattern.prototype;

public class Student implements Prototype {
    int id;
    private int rollNo;
    String name;
    private Student(){}

    Student(int id, int rollNo, String name) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
    }
    @Override
    public Prototype clone() {
        return new Student(id,rollNo,name);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", rollNo=" + rollNo + ", name='" + name + '\'' + '}';
    }

}
