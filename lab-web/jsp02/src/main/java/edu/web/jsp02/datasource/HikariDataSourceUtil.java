package edu.web.jsp02.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// HikariCP 라이브러리를 사용한 DataSource를 이용할 수 있는 유틸리티 클래스.
// -> Singleton패턴
public class HikariDataSourceUtil {

    private static HikariDataSourceUtil instance= null;
    
    private HikariDataSource ds;

    private HikariDataSourceUtil() {
        // HikariCP을 사용하기 위한 설정(configuration)
        HikariConfig config= new HikariConfig();
        config.setDriverClassName("oracle.jdbc.OracleDriver"); // 연결을 맺기 위한 DB드라이버.
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe"); // DB서버 URL.
        config.setUsername("scott"); // 접속 계정.
        config.setPassword("tiger"); // 접속 비밀번호.
        config.addDataSourceProperty("cachePrepStmt", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        
        // HikariDataSource 객체 생성.
        ds= new HikariDataSource(config);
    }
    
    public static HikariDataSourceUtil getInstance() {
        if(instance== null) {
            instance= new HikariDataSourceUtil();
        }
        return instance;
    }
    
    public HikariDataSource getDataSource() {
        return ds;
    }
    
}
