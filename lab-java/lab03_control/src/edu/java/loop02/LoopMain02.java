package edu.java.loop02;

public class LoopMain02 {

    public static void main(String[] args) {
        // 복합 할당 연산자: +=, -=, *=, /=, %=, ...
        int x = 1;
        // x = x + 3;
        x += 3;
        System.out.println("x = " + x);
        
        // 0 2 4 6 8 10을 한 줄씩 출력
        for (int n = 0; n <= 10; n += 2) {
            System.out.println(n);
        }

        System.out.println("-----");
        for (int n = 0; n <= 5; n++) {
            System.out.println(n * 2);
        }
        
        System.out.println("-----");
        for (int n = 0; n <= 10; n++) {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        }
    }

}
