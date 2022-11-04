package ver01.controller;

import static ver01.model.MenuBtn.Menu.*;
import static ver01.model.Sold.SoldList.*;
import static ver01.model.Table.TableInfo.*;

public interface PosSql {
    
    /* Table */
    // 추가
    String SQL_TABLE_INSERT= String.format(
            "insert into %s(%s, %s) values (?, ?)", 
            TBL_TABLE, COL_TNO, COL_SDATE);
    
    // 테이블 정보
    String SQL_TABLE_INFO= String.format(
            "select * from %s where %s=(select max(%s) from %s where %s=?) and %s= ?", 
                    TBL_TABLE, COL_SNO, COL_SNO, TBL_TABLE, COL_TNO, COL_TNO);
    
    // 입장시각 입력
    String SQL_SET_ENTTIME= String.format(
            "update %s set %s= sysdate where %s is null and %s=(select max(%s) from %s where %s=?) and %s= ?", 
            TBL_TABLE, COL_ENTTIME, COL_ENTTIME, COL_SNO, COL_SNO, TBL_TABLE, COL_TNO, COL_TNO);
    
    // 경과시간 입력
    String SQL_SET_STAYTIME= String.format(
            "update %s set %s= sysdate where %s is null and %s=(select max(%s) from %s where %s=?) and %s= ?", 
            TBL_TABLE, COL_ENTTIME, COL_ENTTIME, COL_SNO, COL_SNO, TBL_SOLDLIST, COL_TNO, COL_TNO);
    
    // 총금액 업데이트
    String SQL_PTOTAL_UPDATE= String.format(
            "update %s set %s=? where %s is not null and %s=(select max(%s) from %s where %s=?) and %s= ?", 
            TBL_TABLE, COL_PTOTAL, COL_ENTTIME, COL_SNO, COL_SNO, TBL_SOLDLIST, COL_TNO, COL_TNO);
    
    
    /* MENU */
    // 추가
    String SQL_MENU1_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴1'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴1'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU2_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴2'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴2'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU3_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴3'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴3'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU4_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴4'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴4'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU5_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴5'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴5'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU6_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴6'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴6'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU7_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴7'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴7'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU8_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴8'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴8'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU9_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴9'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴9'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU10_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴10'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴10'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU11_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴11'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴11'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU12_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴12'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴12'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU13_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴13'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴13'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
    String SQL_MENU14_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) "
            + "values ((select max(sno) from tableinfo where tno= ?), "
            + "?, "
            + "(select menuname from menu where menuname like '메뉴14'), "
            + "1, "
            + "(select unitcost from menu where menuname like '메뉴14'))", 
            TBL_SOLDLIST, COL_SNO, COL_TNO, COL_MENUNAME, COL_COUNT, COL_TOTALCOST);
    
   // 목록
    String SQL_MENU_OF_TABLE_READ= String.format(
            "select %s.%s, %s.%s, count(%s.%s), sum(%s.%s) "
            + "from %s join %s on %s.%s= %s.%s "
            + "where %s.%s=(select max(%s) from %s where %s=?) and %s.%s= ? "
            + "group by %s.%s, %s.%s", 
            TBL_SOLDLIST, COL_MENUNAME, TBL_MENU, COL_UNITCOST, 
            TBL_SOLDLIST, COL_COUNT, TBL_SOLDLIST, COL_TOTALCOST,
            TBL_SOLDLIST, TBL_MENU,
            TBL_SOLDLIST, COL_MENUNAME, TBL_MENU, COL_MENUNAME,
            TBL_SOLDLIST, COL_SNO, COL_SNO, TBL_SOLDLIST, COL_TNO, 
            TBL_SOLDLIST, COL_TNO, TBL_SOLDLIST, 
            COL_MENUNAME, TBL_MENU, COL_UNITCOST);
    
    
//    /* Payment */
//    // 목록
//    String SQL_PAYMENT_READ= String.format(
//            "select ", 
//            null);
//    
//    // 결제금액 입력
//    String SQL_INPUT_PAYMENT= String.format(
//            "", 
//            null);
//    
    
 
    
    // TODO 전체 취소
    String SQL_MENU_DELETE_ALL= String.format(
            "delete from %s", 
            TBL_MENU);
    
    
    
    
    
    
    String SQL_SUM_TOTALCOST= String.format(
            "select sum(%s) from %s", 
            COL_TOTALCOST, TBL_MENU);
    
    
    
    
    // 전체 목록
    String SQL_SELECT_ALL_FROM_MENU= String.format(
            "select * from %s", 
            TBL_MENU);
    
    
    
    // 추가
    String SQL_INSERT= String.format(
            "insert into %s (%s, %s, %s, %s, %s) values (?, ?, ?, ?, ?)", 
            TBL_MENU, COL_SNO, COL_MENUNAME, COL_UNITCOST, COL_COUNT, COL_TOTALCOST);

    
    // 선택 취소
    String SQL_DELETE_BY_MENUNAME= String.format(
            "delete from %s where %s= ?", 
            TBL_MENU, COL_MENUNAME);
    
    // 수량 -1
    String SQL_DELETE_BY_NO= String.format(
            "delete from %s where %s= ? and %s>= all(select %s from %s where %s= ?)", 
            TBL_MENU, COL_MENUNAME, COL_NO, COL_NO, TBL_MENU, COL_MENUNAME);
    
    
    
    
    /* SALESLIST */
    // 전체 목록
    String SQL_SELECT_ALL_FROM_SALESLIST= String.format(
            "select * from %s", 
            TBL_SOLDLIST);
}

