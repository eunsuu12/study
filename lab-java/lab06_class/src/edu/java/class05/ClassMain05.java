package edu.java.class05;

public class ClassMain05 {

    public static void main(String[] args) {
        // Score 타입의 객체 생성, 메서드들을 테스트.
        Score score1 = new Score();
        System.out.println("score1 = " + score1);
//        System.out.println("score1 korean = " + score1.korean);
//        System.out.println("score1 english = " + score1.english);
//        System.out.println("score1 math = " + score1.math);
        
        score1.printScore();
//        int total = score1.getTotal();
//        System.out.println("총점: " + total);
        System.out.println("총점: " + score1.getTotal());
        System.out.println("평균: " + score1.getAverage());

        System.out.println("-----");
        Score score2 = new Score(100, 90, 81);
        System.out.println("score2 = " + score2);
        
        score2.printScore();
        System.out.println("총점: " + score2.getTotal());
        System.out.println("평균: " + score2.getAverage());
        
        // Student 타입의 객체 생성, 메서드를 테스트.
        System.out.println("-----");
        Student stu1 = new Student();
//        stu1.score = score1;
        System.out.println("stu1 = " + stu1);
        stu1.printStuInfo();
     
        System.out.println("-----");
        Student stu2 = new Student(1, "홍길동", score2);
        stu2.printStuInfo();
        
        System.out.println("-----");
        Student stu3 = new Student(2, "허균", null);
        stu3.printStuInfo();
        
        System.out.println("-----");
        Student stu4 = new Student(3, "오쌤", new Score());
        stu4.printStuInfo();
        
        System.out.println("-----");
        Student stu5 = new Student(5, "철수", 10, 20, 30);
        stu5.printStuInfo();
        
    }

}
