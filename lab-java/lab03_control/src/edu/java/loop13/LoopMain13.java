package edu.java.loop13;

import java.util.Scanner;

public class LoopMain13 {

    public static void main(String[] args) {
        // Ex 4-7.
        boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정할 변수.
        int balance = 0; // 은행 계좌의 잔고를 저장할 변수.
        Scanner scanner = new Scanner(System.in); // 콘솔창에서 키보드로 입력받기 위한 도구.
        
        while (run) {
            System.out.println("----------------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("----------------------------------------");
            System.out.print("선택> ");
            
            int menu = scanner.nextInt(); // 1 ~ 4 정수 입력
            switch (menu) {
            case 1:
                System.out.print("예금액> ");
                int deposit = scanner.nextInt();
                balance += deposit; // 잔고에 예금액만큼 추가.
                break;
            case 2:
                System.out.print("출금액> ");
                int withdraw = scanner.nextInt();
                balance -= withdraw; // 잔고에서 출금액만큼 뺌.
                break;
            case 3:
                System.out.println("잔고>" + balance);
                break;
            case 4:
                run = false; // 프로그램을 종료하기 위해서
                break;
            default:
                System.out.println("잘못 입력했습니다. 메뉴를 다시 선택.");
            }
            
        }
        
        System.out.println("프로그램 종료");

    }

}
