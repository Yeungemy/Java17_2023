package pojo;

import java.math.BigDecimal;

public class MarginAccount extends Account{
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

    public MarginAccount(String id, BigDecimal amount){
        super(id);
        setAmount(amount);
    }

    @Override
    public MarginAccount clone(){
        return new MarginAccount(super.getId(), this.amount);
    }
}
