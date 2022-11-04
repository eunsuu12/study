package ver01.model;

public class Sold {
    
    public interface SoldList{
        String TBL_SOLDLIST= "SOLDLIST";
        String COL_COUNT= "COUNT";
        String COL_TOTALCOST= "TOTALCOST";
    }
    
    private Integer sNo;
    private Integer tNo;
    private String menuName;
    private Integer unitCost;
    private Integer count;
    private Integer totalCost;
    
    public Sold(){}
    
    public Sold(String menuName, Integer unitCost, Integer count, Integer totalCost) {
        this.menuName = menuName;
        this.unitCost= unitCost;
        this.count = count;
        this.totalCost= totalCost;
    }

    public Sold(Integer sNo, Integer tNo, String menuName, Integer count, Integer totalCost) {
        this.sNo = sNo;
        this.tNo = tNo;
        this.menuName = menuName;
        this.count = count;
        this.totalCost = totalCost;
    }

    public Integer getsNo() {
        return sNo;
    }

    public Integer gettNo() {
        return tNo;
    }

    public String getMenuName() {
        return menuName;
    }
    
    public Integer getUnitCost() {
        return unitCost;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getTotalCost() {
        return totalCost;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Sold(sNo=%d, tNo=%d, totalCost=%d", 
                sNo, tNo, totalCost);
    }
    
    
    
}
