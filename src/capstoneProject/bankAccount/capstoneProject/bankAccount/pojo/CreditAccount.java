package capstoneProject.bankAccount.pojo;

import java.math.BigDecimal;

public class CreditAccount extends Account {
    public CreditAccount(String id, BigDecimal balance){
        super(id, balance);
    }

    public Account clone(){
        return new CreditAccount(super.getId(), super.getBalance());
    }
}
