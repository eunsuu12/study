package ver01.controller;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

import ver01.model.MenuBtn;
import ver01.model.Sold;
import ver01.model.Table;

public interface PosDao {
    
    // TableInfo
    int insertTable(Table table);
    
    int setEntTime(Table table);
    int setStayTime(Table table);
    
    int setpTotal(Table table);
    
    // MenuBtn
    List<Sold> readMenu(Table table);
    
    int insertMenuBtn1(Table table);
    int insertMenuBtn2(Table table);
    int insertMenuBtn3(Table table);
    int insertMenuBtn4(Table table);
    int insertMenuBtn5(Table table);
    int insertMenuBtn6(Table table);
    int insertMenuBtn7(Table table);
    int insertMenuBtn8(Table table);
    int insertMenuBtn9(Table table);
    int insertMenuBtn10(Table table);
    int insertMenuBtn11(Table table);
    int insertMenuBtn12(Table table);
    int insertMenuBtn13(Table table);
    int insertMenuBtn14(Table table);
    
    Table getTableInfoEnt(Table table);
    Table getTableInfoStay(Table table);
    
    int insertpCash(Table table);
    int insertpCard(Table table);
    
    
    
    
    int deleteMenuBtn(); // 전체취소
    int deleteMenuBtn(String menuName); // 선택취소
    int deleteMenuBtnDecrease(String menuName); // 수량 -1
    int insertMenuBtnIncrease(String menuName, Integer unitCost); // 수량 +1
    
    
    // Payment
    String sumTotalCost();
    
    // SalesList
    List<Sold> readSalesList();
}

