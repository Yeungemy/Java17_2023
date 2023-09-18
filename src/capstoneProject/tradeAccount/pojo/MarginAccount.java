package pojo;

import java.math.BigDecimal;

public class MarginAccount extends TradeAccount {
    private BigDecimal margin;

    public MarginAccount(String id, BigDecimal margin){
        super(id);
        setMargin(margin);
    }

    /** Override the clone method in the MarginAccount class
     * return a new MarginAccount object with the same id and margin. 
     */
    @Override
    public MarginAccount clone(){
        return new MarginAccount(super.getId(), this.margin);
    }

    public BigDecimal getMargin() {
        return this.margin;
    }

    public void setMargin(BigDecimal margin) {
        if(margin.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Balance cannot be less than 0.");
        }

        this.margin = margin;
    }

    public String toString(){
        return "\nAccount ID: " + super.getId() + ", Margin: " + this.margin;
    }
}
