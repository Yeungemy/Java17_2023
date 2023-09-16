package capstoneProject.bankAccount.pojo;

import java.math.BigDecimal;

public abstract class Account {
    private String id;
    private BigDecimal balance;

    public Account(String id, BigDecimal balance) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID cannot be empty or null");
        }

        if(balance.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("The balance should be greater than 0.");
        }
        
        setId(id);
        setBalance(balance);
    }

    public Account() {

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID cannot be empty or null");
        }

        this.id = id;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        if(balance.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("The balance to be deposited should be greater than 0.");
        }
        
        this.balance = balance;
    }

    public String toString() {
        return "\nAccount ID: " + this.id + ", and Balance: " + this.balance;
    }

    public abstract Account clone();
}
