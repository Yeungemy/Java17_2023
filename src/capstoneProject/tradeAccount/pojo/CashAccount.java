package pojo;

import java.math.BigDecimal;

public class CashAccount extends TradeAccount{
    private BigDecimal cashBalance;

    public CashAccount(String id, BigDecimal cashBalance) {
        super(id);
        setCashBalance(cashBalance);
    }

    public BigDecimal getCashBalance() {
        return this.cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        if(cashBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Balance cannot be less than 0.");
        }

        this.cashBalance = cashBalance;
    }

    /** Override the clone method in the CashAccount class. 
     * return a new CashAccount object with the same id and cashBalance. 
     */
    @Override
    public CashAccount clone(){
        return new CashAccount(super.getId(), this.cashBalance);
    }

    public String toString() {
        return "\nAccount ID: " + super.getId() + ", Account balance: " + getCashBalance();
    }
}
