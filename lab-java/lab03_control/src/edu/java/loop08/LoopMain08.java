package edu.java.loop08;

public class LoopMain08 {

    public static void main(String[] args) {
        // 중첩 반복문
        for (int dan = 2; dan < 10; dan++) {
            System.out.println("--- " + dan + "단 ---");
            for (int n = 1; n < 10; n++) {
                System.out.println(dan + " x " + n + " = " + (dan * n));
            }
        }
        
        System.out.println();
        
        // while
        int x = 2;
        while (x < 10) {
            System.out.println("--- " + x + "단 ---");
            
            int y = 1;
            while (y < 10) {
                System.out.println(x + " x " + y + " = " + (x * y));
                y++;
            }
            
            x++;
        }
        
        System.out.println();
        // 2단은 2x2까지, 3단은 3x3까지, 4단은 4x4까지, ..., 9단은 9x9까지 출력
        for (int i = 2; i < 10; i++) {
            System.out.println("--- " + i + "단 ---");
            for (int j = 1; j < 10; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
                if (i == j) {
                    break; // 안쪽 for 문을 종료
                }
            } // for (j)
        } // for (i)
        
        System.out.println();
        for (int i = 2; i < 10; i++) {
            System.out.println("--- " + i + "단 ---");
            for (int j = 1; j <= i; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
        }
        
        System.out.println();
        x = 2;  // 2단부터
        while (x < 10) {
            System.out.println("--- " + x + "단 ---");
            
            int y = 1;
            while (y < 10) {
                System.out.println(x + " x " + y + " = " + (x * y));
                if (x == y) {
                    break;
                }
                y++;
            }
            
            x++;
        }
        
        System.out.println();
        x = 2;
        while (x < 10) {
            System.out.println("--- " + x + "단 ---");
            
            int y = 1;
            while (y <= x) {
                System.out.println(x + " x " + y + " = " + (x * y));
                y++;
            }
            
            x++;
        }
        
        
    }

}
