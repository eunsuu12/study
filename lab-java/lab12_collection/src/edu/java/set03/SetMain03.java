package edu.java.set03;

import java.util.HashSet;
import java.util.Random;

public class SetMain03 {

    public static void main(String[] args) {
        // HashSet<E> 사용.
        // [0, 10) 범위의 서로 다른 정수 난수 5개를 저장.
        // Set의 내용을 출력.

        Random random = new Random();
        HashSet<Integer> numbers = new HashSet<>();
        
        while (true) {
            int r = random.nextInt(10); // 난수 만듦.
            System.out.println("r = " + r);
            
            numbers.add(r); // 난수를 set에 저장.
            System.out.println("set = " + numbers);
            
            if (numbers.size() == 5) { // set의 원소 개수가 5개이면
                break; // 반복문 멈춤.
            }
        }
        
    }

}
