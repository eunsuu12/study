package edu.java.file08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileMain08 {

    public static void main(String[] args) {
        // Student를 저장하는 ArrayList를 선언, 생성.
        ArrayList<Student> studentList = new ArrayList<>();
        
        // ArrayList에 Student 객체 5개를 저장.
        for (int i = 0; i < 5; i++) {
            Student stu = new Student(i, "홍길동" + i, new Score(i, i, i));
            studentList.add(stu);
        }
        System.out.println(studentList);
        
        String fileName = "data/student_list.dat";
        
        // ArrayList를 파일에 write.
        try (
                FileOutputStream out = new FileOutputStream(fileName);
                BufferedOutputStream bout = new BufferedOutputStream(out);
                ObjectOutputStream oout = new ObjectOutputStream(bout);
        ) {
            oout.writeObject(studentList);
            System.out.println("파일 작성 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 파일에서 ArrayList 객체를 read.
        // ArrayList의 원소들을 한 줄씩 출력.
        try (
                FileInputStream in = new FileInputStream(fileName);
                BufferedInputStream bin = new BufferedInputStream(in);
                ObjectInputStream oin = new ObjectInputStream(bin);
        ) {
            ArrayList<Student> list = (ArrayList<Student>) oin.readObject();
            for (Student s : list) {
                System.out.println(s);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
