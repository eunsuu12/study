package edu.java.lambda02;

import edu.java.lambda02.Calculator.Calculable;

public class LambdaMain02 {

    public static void main(String[] args) {
        // Ex 1.
        Calculator adder = new Calculator(1, 2);
        double result = adder.calculate(new Calculable() {
            @Override
            public double calculate(double x, double y) {
                return x + y;
            }
        });
        System.out.println("adder result = " + result); // 3.0
        
        // Ex 2. 뺄셈을 계산하는 계산기 기능
        Calculator subtracter = new Calculator(1, 2);
        result = subtracter.calculate((x, y) -> x - y);
        System.out.println("subtracter result = " + result);
        
        // Ex 3. 곱셈을 계산하는 계산기
        Calculator multiplier = new Calculator(1, 2);
        result = multiplier.calculate(new Calculable() {
            @Override
            public double calculate(double x, double y) {
                return x * y;
            }
        });
        System.out.println("multiplier result = " + result);
        
        
        // Ex 4. 나눗셈을 계산하는 계산기
        Calculator divider = new Calculator(1,  2);
        result = divider.calculate((x, y) -> x / y);
        System.out.println("divider result = " + result);
        
        // Ex 5. 두 숫자 중에서 더 크거나 같은 수를 찾는 계산기
        Calculator greater = new Calculator(1, 2);
        result = greater.calculate(new Calculable() {
            @Override
            public double calculate(double x, double y) {
//                if (x > y) {
//                    return x;
//                } else {
//                    return y;
//                }
                return (x > y) ? x : y;
            }
        });
        System.out.println("greater result = " + result);

        result = greater.calculate((x, y) -> (x > y) ? x : y);
        System.out.println("greater result = " + result);
        
        result = greater.calculate((x, y) -> {
            if (x > y) {
                return x;
            } else {
                return y;
            }
        });
        System.out.println("greater result = " + result);

    }

}
