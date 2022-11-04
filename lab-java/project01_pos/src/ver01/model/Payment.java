package ver01.model;

public class Payment {

    public interface Pay{
        String TBL_PAYMENT= "PAYMENT";
        String COL_PCASH= "PCASH";
        String COL_PCARD= "PCARD";
        String COL_PDC= "PDC";
    }

    private Integer sNo;
    private Integer pTotal;
    private Integer pCash;
    private Integer pCard;
    private Integer pDc;
    
    public Payment() {}
    
    public Payment(Integer sNo, Integer pTotal) {
        this.sNo= sNo;
        this.pTotal= pTotal;
    }

    public Payment(Integer sNo, Integer pTotal, Integer pCash, Integer pCard, Integer pDc) {
        this.sNo = sNo;
        this.pTotal = pTotal;
        this.pCash = pCash;
        this.pCard = pCard;
        this.pDc = pDc;
    }

    public Integer getsNo() {
        return sNo;
    }

    public Integer getpTotal() {
        return pTotal;
    }

    public Integer getpCash() {
        return pCash;
    }

    public Integer getpCard() {
        return pCard;
    }

    public Integer getpDc() {
        return pDc;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Payment(sNo=%d, pTotal=%d, pCash=%d, pCard=%d, pDc=%d)", 
                sNo, pTotal, pCash, pCard, pDc);
    }
}
