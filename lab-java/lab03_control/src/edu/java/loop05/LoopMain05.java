package edu.java.loop05;

public class LoopMain05 {

    public static void main(String[] args) {
        // 369 게임 출력
        for (int i = 1; i <= 100; i++) {
            // 1의 자릿수 - 10으로 나눈 나머지
            int n1 = i % 10;
            // 10의 자릿수 - 10으로 나눈 몫
            int n10 = i / 10;
            
            boolean b1 = (n1 == 3) || (n1 == 6) || (n1 == 9); // 1의 자릿수가 3, 6, 9이면
            boolean b10 = (n10 == 3) || (n10 == 6) || (n10 == 9); // 10의 자릿수가 3, 6, 9이면
            
            if (b1 && b10) {
                // 만약에 1의 자릿수가 3, 6, 9이고, 10의 자릿수가 3, 6, 9이면
                System.out.print("**\t");
            } else if (b1 || b10) {
                // 만약에 1의 자릿수 또는 10의 자릿수가 3, 6, 9이면
                System.out.print("*\t");
            } else {
                System.out.print(i + "\t");
            }
            
            if (i % 10 == 0) { // 한 줄에 10개를 출력했으면
                System.out.println(); // 줄바꿈
            }
        }

    }

}
