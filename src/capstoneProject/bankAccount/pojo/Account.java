package capstoneProject.bankAccount.pojo;

import java.math.BigDecimal;

public abstract class Account {
    private String id;
    private BigDecimal balance;

    public Account(String id, BigDecimal balance) {
        setId(id);
        setBalance(balance);
    }

    public Account() {

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String toString() {
        return "\nAccount ID: " + this.id + ", and Balance: " + this.balance;
    }

    public abstract Account clone();
}
