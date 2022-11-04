package ver01.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Table {
    
    public interface TableInfo{
        String TBL_TABLE= "TABLEINFO";
        String COL_SNO= "SNO";
        String COL_TNO= "TNO";
        String COL_PTOTAL= "PTOTAL";
        String COL_SDATE= "SDATE";
        String COL_ENTTIME= "ENTTIME";
        String COL_PAYTIME= "PAYTIME";
        String COL_STAYTIME= "STAYTIME";
        
        LocalDateTime sDate= LocalDateTime.now();
        DateTimeFormatter ymde= DateTimeFormatter.ofPattern("yyyy-MM-dd (E)");
        DateTimeFormatter kkmm= DateTimeFormatter.ofPattern("kk:mm"); 
    }
    
    private Integer sNo;
    private Integer tNo;
    private Integer pTotal;
    private String sDate;
    private LocalDateTime entTime;
    private LocalDateTime payTime;
    private LocalDateTime stayTime;
    
    public Table() {}
    
    public Table(Integer sNo, Integer tNo) {
        this.sNo= sNo;
        this.tNo= tNo;
    }
    
    public Table(Integer tNo, String sDate) {
        this.tNo= tNo;
        this.sDate= sDate;
    }
    
    public Table(Integer sNo, Integer tNo, String sDate) {
        this.sNo = sNo;
        this.tNo = tNo;
        this.sDate = sDate;
    }

    public Table(Integer sNo, Integer tNo, String sDate, LocalDateTime entTime) {
        this.sNo = sNo;
        this.tNo = tNo;
        this.sDate = sDate;
        this.entTime = entTime;
    }
    
    public Table(Integer sNo, Integer tNo, String sDate, LocalDateTime entTime, LocalDateTime stayTime) {
        this.sNo = sNo;
        this.tNo = tNo;
        this.sDate = sDate;
        this.entTime = entTime;
        this.stayTime= stayTime;
    }

    public Table(Integer sNo, Integer tNo, Integer pTotal, String sDate, LocalDateTime entTime, LocalDateTime payTime,
            LocalDateTime stayTime) {
        this.sNo = sNo;
        this.tNo = tNo;
        this.pTotal= pTotal;
        this.sDate = sDate;
        this.entTime = entTime;
        this.payTime = payTime;
        this.stayTime = stayTime;
    }

    public Integer getsNo() {
        return sNo;
    }
    public Integer gettNo() {
        return tNo;
    }
    public Integer getpTotal() {
        return pTotal;
    }
    public String getsDate() {
        return sDate;
    }
    public LocalDateTime getEntTime() {
        return entTime;
    }
    public LocalDateTime getPayTime() {
        return payTime;
    }
    public LocalDateTime getStayTime() {
        return stayTime;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Table(sNo=%d, tNo=%d, pTotal=%d, sDate=%s, entTime=%s, payTime=%s, stayTime=%s)", 
                sNo, tNo, pTotal, sDate, entTime, payTime, stayTime);
    }

}

