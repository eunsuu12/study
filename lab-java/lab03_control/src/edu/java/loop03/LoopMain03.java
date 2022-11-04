package edu.java.loop03;

public class LoopMain03 {

    public static void main(String[] args) {
        /* 아래와 같은 형식으로 구구단 2단을 출력하세요.
           2 x 1 = 2
           2 x 2 = 4
           2 x 3 = 6
           ...
           2 x 8 = 16
           2 x 9 = 18
         */
        for (int n = 1; n < 10; n++) {
//            System.out.println("2 x " + n + " = " + (2 * n));
            // Ctrl+/: 현재 커서가 있는 라인을 주석 토글
            System.out.printf("2 x %d = %d\n", n, (n * 2));
        }
        // System.out.printf(): 문자열을 포맷(템플릿)에 맞춰서 출력.
        // %d: 정수, %f: 실수, %s: 문자열
        // \n: new line(줄바꿈), \t: tab(탭)

        /* 아래와 같이 출력하세요.
           1     2     3     4     5     6     7     8     9     10
           11    12    13    14    15    16    17    18    19    20
           21    22    23    24    25    26    27    28    29    30
           31    32    33    34    35    36    37    38    39    40
           41    42    43    44    45    46    47    48    49    50
           51    52    53    54    55    56    57    58    59    60
           61    62    63    64    65    66    67    68    69    70
           71    72    73    74    75    76    77    78    79    80
           81    82    83    84    85    86    87    88    89    90
           91    92    93    94    95    96    97    98    99    100
         */
        for (int n = 1; n <= 100; n++) {
            System.out.print(n + "\t");
            if (n % 10 == 0) {
                System.out.println();
            }
        }
        
    }

}
