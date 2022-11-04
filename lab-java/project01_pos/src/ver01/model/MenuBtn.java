package ver01.model;

public class MenuBtn {
    
    public interface Menu{
        String TBL_MENU= "MENU";
        String COL_NO= "NO";
        String COL_MENUNAME= "MENUNAME";
        String COL_UNITCOST= "UNITCOST";
    }
    
    private String menuName;
    private Integer unitCost;
    private Integer count;
    private Integer totalCost;
    
    public MenuBtn() {}
    
    public MenuBtn(String menuName, Integer unitCost) {
        this.menuName= menuName;
        this.unitCost= unitCost;
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
                "MenuBtn(menuName=%s, unitCost=%d)", 
                menuName, unitCost);
    }
    

}
