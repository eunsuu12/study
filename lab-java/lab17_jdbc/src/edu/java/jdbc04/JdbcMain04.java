package edu.java.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

import static edu.java.ojdbc.OracleJdbc.*;
import static edu.java.ojdbc.model.Blog.Entity.*;

public class JdbcMain04 {

    public static void main(String[] args) {
        // JDBC를 사용한 delete
        
        Scanner scanner = new Scanner(System.in);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            DriverManager.registerDriver(new OracleDriver());
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = String.format(
                    "delete from %s where %s = ?", 
                    TBL_BLOGS, COL_BLOG_NO);
            System.out.println(sql);
            
            stmt = conn.prepareStatement(sql);
            
            System.out.print("삭제할 글 번호>> ");
            int no = Integer.parseInt(scanner.nextLine());
            
            stmt.setInt(1, no);
            
            int result = stmt.executeUpdate();
            System.out.println(result + "개 행이 삭제됐습니다.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
