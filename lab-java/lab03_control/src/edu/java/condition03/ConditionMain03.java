package edu.java.condition03;

import java.util.Scanner;

public class ConditionMain03 {

    public static void main(String[] args) {
        // Scanner 타입의 변수 선언, 초기화.
        Scanner scanner = new Scanner(System.in);
        
        // int 타입 변수에 콘솔에서 입력한 정수를 저장.
        System.out.println("점수 입력>>>");
        int score = scanner.nextInt();
        
        // 입력한 점수가 90 이상이면, A
        // 80 이상이면, B
        // 70 이상이면, C
        // 60 이상이면, D
        // 60 미만이면, F 출력
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

    }

}
