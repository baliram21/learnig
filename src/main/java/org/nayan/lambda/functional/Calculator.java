package org.nayan.lambda.functional;

public interface Calculator {

    int calculate(int a, int b);
}

class CalculatorClass {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        System.out.println(add.calculate(2,3));
        Calculator mul =(a, b)->a*b;
        System.out.println(mul.calculate(1,2));
        Calculator div =(a,b)->{
            if (a<=0 || b<=0) {
                throw new ArithmeticException("Division by zero");
            }else {
                return a/b;
            }
        };
        System.out.println(div.calculate(9,1));
    }
}