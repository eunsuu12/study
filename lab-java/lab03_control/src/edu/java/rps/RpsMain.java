package edu.java.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsMain {

    public static void main(String[] args) {
        // 가위바위보 게임
        // 가위-0, 바위-1, 보-2
        
        // 컴퓨터의 가위/바위/보는 (정수) 난수로 만듦.
        Random random = new Random();
        int computer = random.nextInt(3);
        
        // 사용자는 콘솔창에서 키보드로 가위/바위/보에 해당하는 정수를 입력.
        System.out.println("가위/바위/보 게임");
        System.out.println("-----------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("-----------------");
        System.out.println("선택>>>");
        
        Scanner scanner = new Scanner(System.in);
        int user = scanner.nextInt();
        
        // print(computer : user)
        System.out.println("computer(" + computer + ") : user(" + user + ")");
        
        // 누가 이겼는 지(조건문) 출력
        if (user == 0) { // 사용자 - 가위 
            if (computer == 0) { // 컴퓨터 - 가위
                System.out.println("Tie");
            } else if (computer == 1) { // 컴퓨터 - 바위
                System.out.println("Computer win");
            } else { // 컴퓨터 - 보
                System.out.println("User win");
            }
        } else if (user == 1) { // 사용자 - 바위
            if (computer == 0) { // 컴퓨터 - 가위
                System.out.println("User win");
            } else if (computer == 1) { // 컴퓨터 - 바위
                System.out.println("Tie");
            } else { // 컴퓨터 - 보
                System.out.println("Computer win");
            }
        } else { // 사용자 - 보
            if (computer == 0) { // 컴퓨터 - 가위
                System.out.println("Computer win");
            } else if (computer == 1) { // 컴퓨터 - 바위
                System.out.println("User win");
            } else { // 컴퓨터 - 보
                System.out.println("Tie");
            }
        }

        if (user == computer) { // 비긴 경우
            System.out.println("Tie");
        } else if (user == 0) { // 사용자 - 가위
            if (computer == 1) { // 컴퓨터 - 바위
                System.out.println("Computer win");
            } else { // 컴퓨터(2) - 보
                System.out.println("User win");
            }
        } else if (user == 1) { // 사용자 - 바위
            if (computer == 0) { // 컴퓨터 - 가위
                System.out.println("User win");
            } else { // 컴퓨터(2) - 보
                System.out.println("Computer win");
            }
        } else { // 사용자(2) - 보
            if (computer == 0) { // 컴퓨터 - 가위
                System.out.println("Computer win");
            } else { // 컴퓨터(1) - 바위
                System.out.println("User win");
            }
        }
        
        if (user == computer) {
            // 비기는 경우
            System.out.println("Tie");
        } else if ((user == 0 && computer == 2) 
                || (user == 1 && computer == 0) 
                || (user == 2 && computer == 1)) {
            // 사용자가 이기는 경우
            System.out.println("User win");
        } else {
            System.out.println("Computer win");
        }
        
        int diff = user - computer;
        if (diff == 0) {
            System.out.println("Tie");
        } else if (diff == 1 || diff == -2) {
            System.out.println("User win");
        } else {
            System.out.println("Computer win");
        }
        
    }

}
