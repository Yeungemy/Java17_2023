package capstoneProject.bankAccount.service;

import java.math.BigDecimal;

import capstoneProject.bankAccount.pojo.Account;
import capstoneProject.bankAccount.pojo.CreditAccount;
import capstoneProject.bankAccount.repository.AccountRepository;

public class CreditAccountService implements AccountService {
    AccountRepository accountRepository;

    public CreditAccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    
    public void createAccount(Account account){
        this.accountRepository.createAccount(account);
    }

    public CreditAccount retrieveAccount(String id){
        return (CreditAccount) this.accountRepository.retrieveAccount(id);
    }

    public void updateAccount(Account account){
        this.accountRepository.updateAccount(account);
    }

    public void deleteAccount(String id){
        this.accountRepository.deleteAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("Account ID cannot be null or empty.");
        }

        /** retrieve the account */
        CreditAccount account = retrieveAccount(id); 
        
        /** calculate new amount */
        BigDecimal newAmt = this.accountRepository.retrieveAccount(id).getBalance().add(amount);

        /** update the balance of the account */
        account.setBalance(newAmt);

        /** update the repository */
        this.accountRepository.retrieveAccount(id).setBalance(newAmt);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("Account ID cannot be null or empty.");
        }

        /** retrieve the account */
        CreditAccount account = retrieveAccount(id); 
        
        /** calculate new amount */
        BigDecimal newAmt = this.accountRepository.retrieveAccount(id).getBalance().subtract(amount);

        /** update the balance of the account */
        account.setBalance(newAmt);

        /** update the repository */
        this.accountRepository.retrieveAccount(id).setBalance(newAmt);
    }
}
