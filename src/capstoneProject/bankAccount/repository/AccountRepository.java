package capstoneProject.bankAccount.repository;

import java.util.HashMap;
import java.util.Map;

import capstoneProject.bankAccount.pojo.Account;

public class AccountRepository {
    private Map<String, Account> dataRep = new HashMap<>();

    public void creatAccount(Account account){
        this.dataRep.put(account.getId(), account.clone());
    }

    public Account retrieveAccount(String id){
        return this.dataRep.get(id).clone();
    }

    public void updateAccount(Account account){
        this.dataRep.put(account.getId(), account.clone());
    }

    public void deleteAccount(String id){
        this.dataRep.remove(id);
    }
}
