package service;

import dataRepository.DataRepo;
import pojo.Account;
import pojo.CashAccount;

import java.math.BigDecimal;

public class CashAccountService implements AccountService{
    private DataRepo dataRepo;

    public CashAccountService(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    /**
     * Create an account
     * @param {Account} account - an account object
     * @return return no value
     */
    public void createAccount(Account account){
        this.dataRepo.createAccount(account);
    }

    /**
     * Retrieve an Account by id.
     * @param {String} id - the account id, and
     * return a clone of account.
     */
    public CashAccount retrieveAccount(String id){
        return (CashAccount) (this.dataRepo.retrieveAccount(id));
    }

    /**
     * update an Account by id.
     * @param {Account} account - an account object
     * return a clone of account.
     */
    public void updateAccount(Account account){
        this.dataRepo.updateAccount(account);
    }

    /**
     * delete an Account by id.
     * @param {String} id - the account id, and
     * return a clone of account.
     */
    public void deleteAccount(String id){
        this.dataRepo.deleteAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        // retrieve the account by id
        CashAccount account = (CashAccount) retrieveAccount(id);

        // calculate the new amount
        BigDecimal newAmt = account.getAmount().add(amount);

        // update the amount
        account.setAmount(newAmt);

        // update data store
        this.dataRepo.updateAccount(account);
    }
    @Override
    public void withdraw(String id, BigDecimal amount) {
        // retrieve the account by id
        CashAccount account = (CashAccount) retrieveAccount(id);

        // calculate the new amount
        BigDecimal newAmt = account.getAmount().subtract(amount);

        // update the amount
        account.setAmount(newAmt);

        // update data store
        this.dataRepo.updateAccount(account);
    }
}
