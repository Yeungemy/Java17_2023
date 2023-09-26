package dataRepository;
import pojo.Account;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DataRepo {
    private Map<String, Account> dataStore = new HashMap<>();

    /**
     * Create an account
     * @param {Account} account - an account object
     * @return return no value
     */
    public void createAccount(Account account){
        this.dataStore.put(account.getId(), account.clone());
    }

    /**
     * Retrieve an Account by id.
     * @param {String} id - the account id, and
     * return a clone of account.
     */
    public Account retrieveAccount(String id){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID cannot be null or blank.");
        }

        return this.dataStore.get(id).clone();
    }

    /**
     * update an Account by id.
     * @param {Account} account - an account object
     * return a clone of account.
     */
    public void updateAccount(Account account){
        if(account == null){
            throw new IllegalArgumentException("Account cannot be null.");
        }

        this.dataStore.put(account.getId(), account.clone());
    }

    /**
     * delete an Account by id.
     * @param {String} id - the account id, and
     * return a clone of account.
     */
    public void deleteAccount(String id){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID cannot be null or blank.");
        }

        this.dataStore.remove(id);
    }
}
