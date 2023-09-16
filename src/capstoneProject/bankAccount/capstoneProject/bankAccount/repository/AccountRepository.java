package capstoneProject.bankAccount.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import capstoneProject.bankAccount.pojo.Account;

public class AccountRepository {
    private Map<String, Account> dataRep = new HashMap<>();

    public void createAccount(Account account) {
        if(account == null){
            throw new IllegalArgumentException("Account cannot be null");
        }

        this.dataRep.put(account.getId(), account.clone());
    }

    public Account retrieveAccount(String id) {
        if(id == null || id.isBlank() || ! this.dataRep.containsKey(id)){
            throw new IllegalArgumentException("ID cannot be empty or null");
        }

        return this.dataRep.get(id).clone();                          
    }

    public void updateAccount(Account account) {
        if(account == null){
            throw new IllegalArgumentException("Account cannot be null");
        }

        this.dataRep.put(account.getId(), account.clone());
    }

    public void deleteAccount(String id) {
        if(id == null || id.isBlank() || ! this.dataRep.containsKey(id)){
            throw new IllegalArgumentException("ID cannot be empty or null");
        }

        this.dataRep.remove(id);
    }

    public void createAccounts(List<Account> accounts) {
        accounts.forEach(account -> {
            createAccount(account);
        });
    }

    public String toString() {
        String temp = "";

        for (Entry<String, Account> entry : dataRep.entrySet()) {
            temp += entry.getValue();
        }

        return temp;
    }

    public String filterAccountByBalance(BigDecimal bal) {
        return this.dataRep.entrySet()
                .stream()
                .filter(entry -> (entry.getValue().getBalance()).compareTo(bal) > 0)
                .sorted((a, b) -> a.getValue().getBalance().compareTo(b.getValue().getBalance()))
                .map(entry -> entry.getValue().toString())
                .collect(Collectors.joining());
    }
}