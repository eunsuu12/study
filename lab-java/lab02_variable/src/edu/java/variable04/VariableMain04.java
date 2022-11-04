package edu.java.variable04;

import java.util.Scanner;

public class VariableMain04 {

    public static void main(String[] args) {
        // 콘솔 창에서 키보드로 숫자를 입력받아서 변수에 저장:

        // 1. Scanner 타입의 변수를 선언하고 초기화.
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수를 입력>>>");

        // 2. Scanner 객체를 사용해서 콘솔 창에서 정수를 입력받고 저장.
        int number = scanner.nextInt();
        System.out.println("number = " + number);

        // Java 시험 점수(정수)를 입력
        System.out.println("Java 점수 입력>>>");
        int java = scanner.nextInt();
        System.out.println("Java 점수 = " + java);

        // SQL 시험 점수를 입력
        System.out.println("SQL 점수 입력>>>");
        int sql = scanner.nextInt();
        System.out.println("SQL 점수 = " + sql);

        // JSP 시험 점수를 입력
        System.out.println("JSP 점수 입력>>>");
        int jsp = scanner.nextInt();
        System.out.println("JSP 점수 = " + jsp);

        // 세 과목의 총점(정수)을 계산하고 출력.
        int total = java + sql + jsp;
        System.out.println("총점 = " + total);

        // 세 과목의 평균(실수)을 계산하고 출력.
        double average = (double) total / 3;
        System.out.println("평균 = " + average);

        // Ctrl+Shift+F: 소스 코드 포맷팅(자동 정렬)

    }

}
