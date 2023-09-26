package pojo;

import java.math.BigDecimal;

public class CashAccount extends Account{
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Balance cannot be less than 0.");
        }

        this.amount = amount;
    }

    public CashAccount(String id, BigDecimal amount){
        super(id);
        setAmount(amount);
    }

    @Override
    public CashAccount clone(){
        return new CashAccount(super.getId(), this.amount);
    }
}
