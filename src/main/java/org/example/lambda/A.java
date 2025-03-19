package org.example.lambda;

// Interface A
public interface A {
    public void m1();
    public int sum(int x, int y);
    public String greet(String s);
}


// Class B implements Interface A
class B implements A {

    @Override
    public void m1() {
        System.out.println("m1() method called");
    }

    @Override
    public int sum(int x, int y) {
        return x + y;
    }

    @Override
    public String greet(String s) {
        return "Hello " + s;
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.greet("nayan")); // This will print "Hello nayan"
        System.out.println(b.sum(2, 4)); // This will print 6
        b.m1(); // This will print "m1() method called"
    }
}
