package edu.java.array09;

import java.util.Scanner;

public class ArrayMain09 {

    public static void main(String[] args) {
        // Ch.5-2 Ex.6 (p201)
        boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
        int studentNum = 0; // 입력받은 학생수를 저장할 변수.
        int[] scores = null; // 학생들의 점수들을 저장할 배열.
        // null: 배열이 만들어지지 않음.
        Scanner scanner = new Scanner(System.in);
        
        while (run) {
            // 프로그램 메뉴(기능) 보여줌.
            System.out.println("------------------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("------------------------------------------------------------");
            System.out.print("선택> ");
            
            // 콘솔창에서 문자열을 입력받아서 int로 변환.
            int selectNo = Integer.parseInt(scanner.nextLine());
            if (selectNo == 1) { // 학생수
                // 학생수 입력 받기.
                System.out.print("학생수> ");
                studentNum = Integer.parseInt(scanner.nextLine());
                // 입력받은 학생수 크기의 배열을 생성.
                scores = new int[studentNum];
                System.out.println("scores length = " + scores.length);
            } else if (selectNo == 2) { // 점수 입력
                if (scores == null) {
                    System.out.println("학생수를 먼저 입력하세요...");
                    continue; // while 반복문을 처음부터 다시 시작.
                }
                
                // 배열 scores의 길이만큼 반복하면서 점수를 입력받고, 배열에 저장.
                for (int i = 0; i < scores.length; i++) {
                    System.out.printf("scores[%d]> ", i);
                    scores[i] = Integer.parseInt(scanner.nextLine());
                }
                
            } else if (selectNo == 3) { // 점수리스트
                if (scores == null) {
                    System.out.println("학생수를 먼저 입력하세요...");
                    continue;
                }
                
                // 배열 scores에 저장된 모든 점수 출력.
//                for (int i = 0; i < scores.length; i++) {
//                    System.out.println("scores[" + i + "]> " + scores[i]);
//                }
                int count = 0;
                for (int x : scores) {
                    System.out.println("scores[" + count + "]> " + x);
                    count++;
                }
                
            } else if (selectNo == 4) { // 분석
                if (scores == null) {
                    System.out.println("학생수를 먼저 입력하세요...");
                    continue;
                }
                
                // 최댓값
                int max = scores[0];
                for (int x : scores) {
                    max = (x > max) ? x : max;
                }
                System.out.println("최고 점수: " + max);
                
                // 합계 -> 평균
                int sum = 0;
                for (int x : scores) {
                    sum += x;
                }
                double mean = (double) sum / scores.length;
                System.out.println("평균 점수: " + mean);
                
            } else if (selectNo == 5) { // 종료
                run = false;
            } else {
                System.out.println("메뉴(1 ~ 5)를 다시 선택...");
            }
            
        } // end while
        
        System.out.println("프로그램 종료");
        
    }

}
