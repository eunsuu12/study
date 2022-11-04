package edu.java.file03;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileMain03 {

    public static void main(String[] args) {
        // data/ratings.dat 파일을 읽고  ratings_copy.dat 파일에 복사.
        //  (1) read(), write(int b)를 사용했을 때와
        //  (2) read(byte[] b), write(byte[] b, int off, int len)를 사용했을 때의
        // 복사 시간의 차이를 비교.
        
        FileInputStream in = null;
        FileOutputStream out = null;
        
        try {
            in = new FileInputStream("data/ratings.dat");
            out = new FileOutputStream("data/ratings_copy.dat");
            
            long startTime = System.currentTimeMillis(); // 시작 시간
            while (true) {
//                int result = in.read(); // (1) 파일에서 1바이트 읽기.
                byte[] buffer = new byte[4 * 1024]; // (2) 4,096 Byte(=4KB) 배열 생성
                int result = in.read(buffer); // (2) 파일에서 4KB씩 읽기.
                
                if (result == -1) { // EOF(End Of File)
                    break;
                }
                
//                out.write(result); // (1) 파일에 1바이트 쓰기.
                out.write(buffer, 0, result); // (2) byte 배열의 내용을 result 크기 만큼만 쓰기.
            }
            long endTime = System.currentTimeMillis(); // 종료 시간
            long elapsedTime = endTime - startTime; // 경과 시간
            System.out.println("복사 종료 - " + elapsedTime + "ms");
            // (1) -> 2분 이상 소요
            // (2) -> 약 0.1초 소요
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
