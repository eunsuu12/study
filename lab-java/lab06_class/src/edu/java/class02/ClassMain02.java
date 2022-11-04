package edu.java.class02;

import java.util.Random;
import java.util.Scanner;

public class ClassMain02 {

    public static void main(String[] args) {
        // Product 타입의 객체를 생성.
        Product product1 = new Product(1234567, "신라면", 900);
        System.out.println(product1.productName + " : " + product1.price);
        
        // 신라면의 가격을 변경
        product1.setPrice(1050);
        System.out.println(product1.productName + " : " + product1.price);
        
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        
        Random random = new Random();
        int r = random.nextInt(10);
        
    }

}
