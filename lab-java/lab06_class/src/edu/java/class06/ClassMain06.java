package edu.java.class06;

public class ClassMain06 {

    public static void main(String[] args) {
        // Account 타입 변수 선언, Account 객체 생성
        Account account1 = new Account(123456, 1000);
        System.out.println(account1);
        
        account1.printAccountInfo(); // 계좌 정보 출력
        
        double money = account1.deposit(10000); // 입금
        System.out.println(money);
        account1.printAccountInfo();
        
        money = account1.withdraw(5000); // 출금
        System.out.println(money);
        
        // 이체할 계좌 생성
        Account account2 = new Account(456789, 1000);
        account2.printAccountInfo();
        
        // account1에서 account2으로 5,000원을 이체
        account1.transfer(account2, 5000);
        account1.printAccountInfo();
        account2.printAccountInfo();

    }

}
