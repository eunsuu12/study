package edu.java.array07;

import java.util.Random;

public class ArrayMain07 {

    public static void main(String[] args) {
        // Chapter 5-2 Ex.4 (p200)
        // 정수(int) 10개를 저장하는 배열(array)을 선언.
        int[] array = new int[10];
        
        // 배열에 0 이상 10 이하의 정수 난수 10개를 저장.
        Random random = new Random();
        
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(11);
        }
        
        // 배열의 내용 출력.
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
        
        // 배열에서 최댓값을 찾으세요.
        // max = array[0] 가정
        // for (array의 모든 원소들):
        //     if (max < array 원소):
        //         max = array 원소
        int max = array[0];
        for (int x : array) { // 배열 array에서 원소를 하나씩 꺼내면서
//            if (max < x) { // 배열에서 꺼낸 원소 x가 max보다 크다면
//                max = x; // 최댓값을 더 큰 값으로 설정.
//            }
            max = (max < x) ? x : max;
        }
        System.out.println("max = " + max);

    }

}
