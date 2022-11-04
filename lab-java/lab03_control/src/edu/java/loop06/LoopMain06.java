package edu.java.loop06;

public class LoopMain06 {

    public static void main(String[] args) {
        // for 반복문
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        
        System.out.println("-----");
        // while 반복문
        int n = 1;
        while (n <= 5) {
            System.out.println(n);
            n++;
        }
        
        System.out.println("-----");
        // 10부터 1까지 정수들을 내림차순으로 한 줄에 출력하세요. (10 9 8 ... 3 2 1)
        for (n = 10; n > 0; n--) {
            System.out.print(n + " ");
        }
        System.out.println();
        
        n = 10;
        while (n > 0) {
            System.out.print(n + " ");
            n--;
        }
        System.out.println();
        
        System.out.println("-----");
        // 10 이하의 양의 홀수들을 한 줄에 출력하세요. (1 3 5 7 9)
        for (n = 1; n < 10; n += 2) {
            System.out.print(n + " ");
        }
        System.out.println();
        
        n = 1;
        while (n < 10) {
            System.out.print(n + " ");
            n += 2;
        }
        System.out.println();
        
        n = 1;
        while (n < 10) {
            if (n % 2 == 1) { // n이 홀수이면,
                System.out.print(n + " ");
            }
            n++;
        }
        
    }

}
