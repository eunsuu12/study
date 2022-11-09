package edu.web.jsp02.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariDataSource;

import edu.web.jsp02.datasource.HikariDataSourceUtil;
import edu.web.jsp02.domain.User;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDaoImpl implements UserDao {

    private static UserDaoImpl instance= null;
    private HikariDataSource ds;
    private UserDaoImpl() {
        ds= HikariDataSourceUtil.getInstance().getDataSource();
    }
    public static UserDaoImpl getInstance() {
        if(instance== null) {
            instance= new UserDaoImpl();
        }
        return instance;
    }
    
    
    public static final String SQL_USER_SELECT= "select * from USERS order by ID desc";
    @Override
    public List<User> select() {
        log.info("select()");
        log.info("SQL: {}", SQL_USER_SELECT);
        
        List<User> list= new ArrayList<>();
        
        try {
            @Cleanup
            Connection conn= ds.getConnection();
            @Cleanup
            PreparedStatement stmt= conn.prepareStatement(SQL_USER_SELECT);
            @Cleanup
            ResultSet rs= stmt.executeQuery();
            
            while(rs.next()) {
                Integer id= rs.getInt("ID");
                String userName= rs.getString("USERNAME");
                String password= rs.getString("PASSWORD");
                String email= rs.getString("EMAIL");
                Integer points= rs.getInt("POINTS");
                
                User user= User.builder()
                        .id(id).userName(userName).password(password)
                        .email(email).points(points)
                        .build();
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    public static final String SQL_USER_INSERT=
            "insert into USERS (USERNAME, PASSWORD, EMAIL) "
            +"values (?, ?, ?)";
    @Override
    public int insert(User entity) {
        log.info("insert(entity= {}", entity);
        log.info(SQL_USER_INSERT);
        
        int result= 0;
        
        try {
            @Cleanup
            Connection conn= ds.getConnection();
            @Cleanup
            PreparedStatement stmt= conn.prepareStatement(SQL_USER_INSERT);
            stmt.setString(1, entity.getUserName());
            stmt.setString(2, entity.getPassword());
            stmt.setString(3, entity.getEmail());
            
            result= stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    
    public static final String SQL_USER_SELECT_BY_ID= "select * from USERS where ID= ?";
    @Override
    public User selectById(Integer id) {
        log.info("selectById(id= {})", id);
        
        User entity= null;
        
        try {
            @Cleanup // 리소스 사용이 끝난 후에 close()메서드를 자동으로 호출.
            Connection conn= ds.getConnection();
            @Cleanup
            PreparedStatement stmt= conn.prepareStatement(SQL_USER_SELECT_BY_ID);
            log.info("SQL: {}", SQL_USER_SELECT_BY_ID);
            stmt.setInt(1, id);
            @Cleanup
            ResultSet rs= stmt.executeQuery();
            
            if(rs.next()) {
                String userName= rs.getString("USERNAME");
                String password= rs.getString("PASSWORD");
                String email= rs.getString("EMAIL");
                Integer points= rs.getInt("POINTS");
               
                entity= User.builder()
                        .id(id).userName(userName).password(password)
                        .email(email).points(points)
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }
    
    
    public static final String SQL_USER_UPDATE=
            "update USERS set PASSWORD=?, EMAIL=? where ID=?";
    @Override
    public int update(User entity) {
        log.info("update(User= {})", entity);
        int result= 0;
        try {
            @Cleanup
            Connection conn= ds.getConnection();
            @Cleanup
            PreparedStatement stmt= conn.prepareStatement(SQL_USER_UPDATE);
            log.info("SQL: {}", SQL_USER_UPDATE);
            stmt.setString(1, entity.getPassword());
            stmt.setString(2, entity.getEmail());
            stmt.setInt(3, entity.getId());
            result= stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
