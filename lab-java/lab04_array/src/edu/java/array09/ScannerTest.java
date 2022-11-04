package edu.java.array09;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        // 시스템의 입력장치(콘솔창)를 이용하는 Scanner 객체를 만듦.
        Scanner sc = new Scanner(System.in);
        
        System.out.print("정수 입력> ");
        int n = sc.nextInt(); // 시스템 입력장치(콘솔창)에서 정수를 읽음.
        // nextInt(): 토큰(공백, 탭, 줄바꿈으로 구분되는 문자열) 단위로 읽어서 정수로 변환.
        sc.nextLine();
        System.out.println("n = " + n);
        
        System.out.print("정수 입력> ");
        n = sc.nextInt();
        sc.nextLine();
        System.out.println("n = " + n);
        
        System.out.print("문자열 입력> ");
        String s = sc.next();
        // next(): 토큰(공백, 탭, 줄바꿈으로 구분되는 문자열) 단위로 읽어서 문자열을 반환.
        sc.nextLine();
        System.out.println("s = " + s);
        
        System.out.print("문자열 입력> ");
        s = sc.nextLine();
        // nextLine(): 줄바꿈까지 읽음. 입력 버퍼를 비움.
        System.out.println("s = " + s);

        // 입력버퍼에서는 줄바꿈까지 문자열로 읽고, 
        // 읽어들인 문자열을 원하는 타입(int, double, ...)으로 변환.
        System.out.print("정수 입력> ");
        s = sc.nextLine(); // 줄바꿈까지 문자열 읽음.
        n = Integer.parseInt(s); // 문자열을 정수(int)로 변환.
        System.out.println("n = " + n);
        
    }

}
