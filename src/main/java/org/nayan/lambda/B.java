package org.nayan.lambda;

class B1 implements A1{

    @Override
    public void m1() {
        System.out.println("m1() method called");
    }

    @Override
    public int sum(int x, int y) {
        return x+y;
    }

    @Override
    public String greet(String s) {
        return "Hello "+s;
    }

    public static void main(String[] args) {
        B1 b = new B1();
        b.greet("nayan");
        b.sum(2,4);
        b.m1();
    }
}
