package capstoneProject.bankAccount.pojo;

import java.math.BigDecimal;

public class CheckAccount extends Account {

    public CheckAccount(String id, BigDecimal balance){
        super(id, balance);
    }

    public Account clone(){
        return new CheckAccount(super.getId(), super.getBalance());
    }
}
