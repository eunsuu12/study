package ver01.controller;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleDriver;
import ver01.model.MenuBtn;
import ver01.model.Sold;
import ver01.model.Table;
import ver01.view.ShowTableDetail;

import static ver01.model.MenuBtn.Menu.*;
import static ver01.model.OracleConnection.*;
import static ver01.model.Table.TableInfo.*;
import static ver01.controller.PosSql.*;
import static ver01.model.Sold.SoldList.*;

public class PosDaoImpl implements PosDao {
    
;    
    private static PosDaoImpl instance= null;
   
    private PosDaoImpl() {}
    
    public static PosDaoImpl getInstance() {
        if(instance== null) {
            instance= new PosDaoImpl();
        }
        return instance;
    }
    
    @Override
    public int insertTable(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_TABLE_INSERT);
            stmt= conn.prepareStatement(SQL_TABLE_INSERT);
            stmt.setInt(1, table.gettNo());
            stmt.setString(2, table.getsDate());
            System.out.println("선택한 테이블: "+table.gettNo());
            System.out.println("영업일자: "+table.getsDate());
            result= stmt.executeUpdate();
            
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
        
        return result;
    }
    
    @Override
    public List<Sold> readMenu(Table table) {
        List<Sold> list= new ArrayList<>();
        
        Connection conn= null;
        PreparedStatement stmt= null;
        ResultSet rs= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU_OF_TABLE_READ);
            stmt= conn.prepareStatement(SQL_MENU_OF_TABLE_READ);
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            
            rs= stmt.executeQuery();
            while(rs.next()) {
                String menuName= rs.getString(COL_MENUNAME);
                Integer unitCost= rs.getInt(COL_UNITCOST);
                Integer count= rs.getInt("count(SOLDLIST.COUNT)");
                Integer totalCost= rs.getInt("sum(SOLDLIST.TOTALCOST)");
                Sold menu= new Sold(menuName, unitCost, count, totalCost);
                list.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
    
    @Override
    public int insertMenuBtn1(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU1_INSERT);
            stmt= conn.prepareStatement(SQL_MENU1_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn2(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU2_INSERT);
            stmt= conn.prepareStatement(SQL_MENU2_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn3(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU3_INSERT);
            stmt= conn.prepareStatement(SQL_MENU3_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn4(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU4_INSERT);
            stmt= conn.prepareStatement(SQL_MENU4_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn5(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU5_INSERT);
            stmt= conn.prepareStatement(SQL_MENU5_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn6(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU6_INSERT);
            stmt= conn.prepareStatement(SQL_MENU6_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn7(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU7_INSERT);
            stmt= conn.prepareStatement(SQL_MENU7_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn8(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU8_INSERT);
            stmt= conn.prepareStatement(SQL_MENU8_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn9(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU9_INSERT);
            stmt= conn.prepareStatement(SQL_MENU9_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn10(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU10_INSERT);
            stmt= conn.prepareStatement(SQL_MENU10_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn11(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU11_INSERT);
            stmt= conn.prepareStatement(SQL_MENU11_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn12(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU12_INSERT);
            stmt= conn.prepareStatement(SQL_MENU12_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn13(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU13_INSERT);
            stmt= conn.prepareStatement(SQL_MENU13_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtn14(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU14_INSERT);
            stmt= conn.prepareStatement(SQL_MENU14_INSERT);
            // TODO
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            result= stmt.executeUpdate();

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
        
        return result;
    }
    
    @Override
    public int insertMenuBtnIncrease(String menuName, Integer unitCost) {
        int result= 0;
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_INSERT);
            stmt= conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, menuName);
            stmt.setInt(2, unitCost);
            stmt.setInt(3, 1);
            stmt.setInt(4, unitCost);
            
            result= stmt.executeUpdate();
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
        return result;
    }

    @Override
    public int deleteMenuBtnDecrease(String menuName) {
        int result= 0;
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_DELETE_BY_NO);
            stmt= conn.prepareStatement(SQL_DELETE_BY_NO);
            stmt.setString(1, menuName);
            stmt.setString(2, menuName);
            
            result= stmt.executeUpdate();
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
        System.out.println(result);
        return result;
    }
    
    @Override
    public int deleteMenuBtn() {
        int result= 0;
        Connection conn= null;
        PreparedStatement stmt= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println(SQL_MENU_DELETE_ALL);
            stmt= conn.prepareStatement(SQL_MENU_DELETE_ALL);
            
            result= stmt.executeUpdate();
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
        System.out.println(result); 
        return result;
    }
    
    @Override
    public int deleteMenuBtn(String menuName) {
        int result= 0;
      
        Connection conn= null;
        PreparedStatement stmt= null;
      
      try {
          DriverManager.registerDriver(new OracleDriver());
          conn= DriverManager.getConnection(URL, USER, PASSWORD);
          
          System.out.println(SQL_DELETE_BY_MENUNAME);
          stmt= conn.prepareStatement(SQL_DELETE_BY_MENUNAME);
          stmt.setString(1, menuName);
          
          result= stmt.executeUpdate();
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
      System.out.println(result);    
      return result;
    }

    @Override
    public List<Sold> readSalesList() {
        List<Sold> list= new ArrayList<>();
        return list;
    }

    @Override
    public String sumTotalCost() {
        return null;
    }

    @Override
    public Table getTableInfoEnt(Table table) {
        Table tableInfo= null;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        ResultSet rs= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(SQL_TABLE_INFO);
            stmt= conn.prepareStatement(SQL_TABLE_INFO);
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            rs= stmt.executeQuery();
            if(rs.next()) {
                int sNo= rs.getInt(COL_SNO);
                int tNo= rs.getInt(COL_TNO);
//                int pTotal= rs.getInt(COL_PTOTAL);
                String sDate= rs.getString(COL_SDATE);
                LocalDateTime entTime= rs.getTimestamp(COL_ENTTIME).toLocalDateTime();
//                LocalDateTime payTime= rs.getTimestamp(COL_PAYTIME).toLocalDateTime();
//                LocalDateTime stayTime= rs.getTimestamp(COL_STAYTIME).toLocalDateTime();
                tableInfo= new Table(sNo, tNo, sDate, entTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(tableInfo);
        return tableInfo;
    }
    
    @Override
    public Table getTableInfoStay(Table table) {
        Table tableInfo= null;
        
        Connection conn= null;
        PreparedStatement stmt= null;
        ResultSet rs= null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(SQL_TABLE_INFO);
            stmt= conn.prepareStatement(SQL_TABLE_INFO);
            stmt.setInt(1, table.gettNo());
            stmt.setInt(2, table.gettNo());
            rs= stmt.executeQuery();
            if(rs.next()) {
                int sNo= rs.getInt(COL_SNO);
                int tNo= rs.getInt(COL_TNO);
//                int pTotal= rs.getInt(COL_PTOTAL);
                String sDate= rs.getString(COL_SDATE);
                LocalDateTime entTime= rs.getTimestamp(COL_ENTTIME).toLocalDateTime();
//                LocalDateTime payTime= rs.getTimestamp(COL_PAYTIME).toLocalDateTime();
                LocalDateTime stayTime= rs.getTimestamp(COL_STAYTIME).toLocalDateTime();
                tableInfo= new Table(sNo, tNo, sDate, entTime, stayTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(tableInfo);
        return tableInfo;
    }

    @Override
    public int setEntTime(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
      
      try {
          DriverManager.registerDriver(new OracleDriver());
          conn= DriverManager.getConnection(URL, USER, PASSWORD);
          
          System.out.println(SQL_SET_ENTTIME);
          stmt= conn.prepareStatement(SQL_SET_ENTTIME);
          stmt.setInt(1, table.gettNo());
          stmt.setInt(2, table.gettNo());
          result= stmt.executeUpdate();
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
      System.out.println("업데이트 된 행: "+result+"개");    
      return result;
    }
    
    @Override
    public int setStayTime(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
      
      try {
          DriverManager.registerDriver(new OracleDriver());
          conn= DriverManager.getConnection(URL, USER, PASSWORD);
          
          System.out.println(SQL_SET_STAYTIME);
          stmt= conn.prepareStatement(SQL_SET_STAYTIME);
          stmt.setInt(1, table.gettNo());
          stmt.setInt(2, table.gettNo());
          System.out.println(table.gettNo());
          result= stmt.executeUpdate();
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
      System.out.println(result);    
      return result;
    }
    
    @Override
    public int setpTotal(Table table) {
        int result= 0;
        
        Connection conn= null;
        PreparedStatement stmt= null;
      
      try {
          DriverManager.registerDriver(new OracleDriver());
          conn= DriverManager.getConnection(URL, USER, PASSWORD);
          
          System.out.println(SQL_PTOTAL_UPDATE);
          stmt= conn.prepareStatement(SQL_PTOTAL_UPDATE);
          stmt.setInt(1, Integer.valueOf(ShowTableDetail.textTotal.getText()));
          stmt.setInt(2, table.gettNo());
          stmt.setInt(3, table.gettNo());
          System.out.println(table.gettNo());
          result= stmt.executeUpdate();
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
      System.out.println(result);    
      return result;
    }

    @Override
    public int insertpCash(Table table) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertpCard(Table table) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    




    



}

