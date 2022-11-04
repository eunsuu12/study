package edu.java.condition05;

import java.util.Random;
// Ctrl+Shift+O: optimize import(import 문 최적화)

public class ConditionMain05 {

    public static void main(String[] args) {
        // Random 타입 변수를 선언하고, 초기화
        Random random = new Random();
        
        // Java 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        int java = random.nextInt(101);
        
        // SQL 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        int sql = random.nextInt(101);
        
        // JSP 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        int jsp = random.nextInt(101);
        
        // 세 과목의 평균을 계산.
        double avg = (double) (java + sql + jsp) / 3;
        
        System.out.println("Java = " + java);
        System.out.println("SQL = " + sql);
        System.out.println("JSP = " + jsp);
        System.out.println("평균 = " + avg);
        
        // 모든 과목의 점수가 40점 이상이고, 평균이 60점 이상이면 "합격",
        // 그렇지 않으면 "불합격" 출력
        if (java >= 40 && sql >= 40 && jsp >= 40 && avg >= 60) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }
        
        if (java < 40 || sql < 40 || jsp < 40) {
            System.out.println("불합격");
        } else if (avg >= 60) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }

        String result = (java >= 40 && sql >= 40 && jsp >= 40 && avg >= 60) ? "합격" : "불합격";
        System.out.println(result);
        
    }

}
