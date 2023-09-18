package service;

import java.math.BigDecimal;

import pojo.MarginAccount;
import repository.TradeAccountRepository;

public class MarginAccountService implements TradeAccountService {
    private TradeAccountRepository accountRepository;

    public MarginAccountService(TradeAccountRepository repository) {
        this.accountRepository = repository;
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        // retrieve an account by id
        MarginAccount account = retrieveTradeAccount(id);

        // update margin amount
        account.setMargin(amount.add(account.getMargin()));
        
        // updat data strore
        updateTradeAccount(account);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        // retrieve an account by id
        MarginAccount account = retrieveTradeAccount(id);

        // update margin amount
        account.setMargin(account.getMargin().subtract(amount));
        
        // updat data strore
        updateTradeAccount(account);
    }

    public void createTradeAccount(MarginAccount account) {
        this.accountRepository.createTradeAccount(account);
    }

    public MarginAccount retrieveTradeAccount(String id) {
        return (MarginAccount) (this.accountRepository.retrieveTradeAccount(id));
    }

    public void updateTradeAccount(MarginAccount account) {
        this.accountRepository.updateTradeAccount(account);
    }

    public void deleteTradeAccount(String id) {
        this.accountRepository.deleteTradeAccount(id);
    }
}
