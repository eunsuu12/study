package edu.java.array08;

import java.util.Random;

public class ArrayMain08 {

    public static void main(String[] args) {
        // Ch.5-2 Ex.5 (p201)
        // 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언.
        int[][] array = new int[3][];
        
        Random random = new Random();
        
        // 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개, 세번째 배열에는 난수 4개 저장.
        // 난수의 범위는 [70, 100). 70 이상 100 미만.
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[i + 2];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(70, 100);
            }
        }
        
        // 배열의 원소들을 출력
        for (int[] arr : array) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        
        // 2차원 배열 array의 모든 원소들의 합(int)을 계산하고 출력.
        int sum = 0; // 모든 원소들의 합계를 저장할 변수
        int count = 0; // 배열의 원소들의 개수를 저장할 변수
        for (int[] arr : array) {
            for (int x : arr) {
                sum += x;
                count++;
            }
        }
        System.out.println("sum = " + sum);
        System.out.println("count = " + count);
        
        // 차원 배열 array의 모든 원소들의 평균(double)을 계산하고 출력.
        double mean = (double) sum / count;
        System.out.println("mean = " + mean);

    }

}
