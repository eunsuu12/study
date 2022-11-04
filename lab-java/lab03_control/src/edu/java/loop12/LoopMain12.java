package edu.java.loop12;

public class LoopMain12 {

    public static void main(String[] args) {
        // Ex 4-5.
        for (int i = 1; i <= 4; i++) { // 4번 반복하면서
            for (int j = 1; j <= i; j++) { // i번 반복하면서
                System.out.print("*"); // "*"를 (줄바꿈 없이) 옆으로 출력
            }
            System.out.println(); // i번째 줄의 "*"들을 출력 후 줄바꿈.
        }
        
        System.out.println();
        // Ex 4-6.
        for (int i = 1; i <= 4; i++) {
            int spaces = 4 - i; // i번째 줄에서 출력할 공백 개수
            for (int j = 1; j <= spaces; j++) { // spaces 갯수만큼 반복하면서
                System.out.print(" "); // 공백 출력
            }
            for (int j = 1; j <= i; j++) { // 라인 수만큼 반복하면서
                System.out.print("*"); // "*" 출력
            }
            System.out.println(); // 줄바꿈
        }

        System.out.println();
        for (int i = 1; i <= 4; i++) { // 라인 수가 1 ~ 4까지
            for (int j = 4; j >= 1; j--) { // 각 줄에서 자릿수 4 ~ 1까지 
                if (j > i) { // 출력할 자릿수가 라인 숫자보다 크면
                    System.out.print(" ");
                } else { // 출력 위치가 라인 숫자보다 작거나 같으면
                    System.out.print("*");
                }
            }
            System.out.println(); // 줄바꿈
        }
        
    }

}
