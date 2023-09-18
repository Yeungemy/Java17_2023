package service;

import java.math.BigDecimal;

import pojo.CashAccount;
import repository.TradeAccountRepository;

public class CashAccountService implements TradeAccountService {
    private TradeAccountRepository accountRepository;

    public CashAccountService(TradeAccountRepository repository) {
        this.accountRepository = repository;
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        // retrieve an account by id
        CashAccount account = retrieveTradeAccount(id);

        // update margin amount
        account.setCashBalance(amount.add(account.getCashBalance()));
        
        // updat data strore
        updateTradeAccount(account);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        // retrieve an account by id
        CashAccount account = retrieveTradeAccount(id);

        // update margin amount
        account.setCashBalance(account.getCashBalance().subtract(amount));
        
        // updat data strore
        updateTradeAccount(account);
    }

    public void createTradeAccount(CashAccount account) {
        this.accountRepository.createTradeAccount(account);
    }

    public CashAccount retrieveTradeAccount(String id) {
        return (CashAccount) (this.accountRepository.retrieveTradeAccount(id));
    }

    public void updateTradeAccount(CashAccount account) {
        this.accountRepository.updateTradeAccount(account);
    }

    public void deleteTradeAccount(String id) {
        this.accountRepository.deleteTradeAccount(id);
    }
}
