package edu.java.modifier04;

public class ModifierMain04 {

    public static void main(String[] args) {
        // Member 타입의 객체 생성.
        Member m = new Member("guest", "0000");
        System.out.println(m);
        System.out.println(m.getMemberId());
//        m.memberId = ""; // private 멤버는 다른 클래스에서 직접 사용할 수 없음.
        // private 멤버 변수의 setter 메서드를 제공하지 않기 때문에 값을 변경할 수 없음.
        System.out.println(m.getPassword());
        m.setPassword("!@#$");
        System.out.println(m.getPassword());

    }

}
