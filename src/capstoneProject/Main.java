package capstoneProject;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import capstoneProject.bankAccount.pojo.Account;
import capstoneProject.bankAccount.pojo.CheckAccount;
import capstoneProject.bankAccount.pojo.CreditAccount;
import capstoneProject.bankAccount.repository.AccountRepository;
import capstoneProject.bankAccount.service.CheckAccountService;
import capstoneProject.bankAccount.service.CreditAccountService;

public class Main {
    public static void main(String[] args) {
        final BigDecimal BAL = new BigDecimal(200);
        BigDecimal newBAL = new BigDecimal(800);
        // Assume these were obtained from user input.
        List<Account> accounts = Arrays.asList(
            new CheckAccount("A1234B", new BigDecimal("500.00")),
            new CheckAccount("E3456F", new BigDecimal("300.50")),
            new CheckAccount("I5678J", new BigDecimal("100.25")),
            new CreditAccount("A1534B", new BigDecimal("0.50")),
            new CreditAccount("G4567H", new BigDecimal("200.00"))
        );

        AccountRepository accountRep = new AccountRepository();
        CheckAccountService checkAccountService = new CheckAccountService(accountRep);
        CreditAccountService creditAccountService = new CreditAccountService(accountRep);

        /** populate accounts to the data repo */
        accounts.stream()
        .forEach(account -> {
            if(account instanceof CheckAccount){
                checkAccountService.createAccount((CheckAccount) account);
            }else{
                creditAccountService.createAccount((CreditAccount) account);
            }
        });

        System.out.println("************************************************************************");

        System.out.println(accountRep);

        System.out.println("************************************************************************");
        System.out.println(accountRep.filterAccountByBalance(BAL));

        CheckAccount ca = (CheckAccount) accountRep.retrieveAccount("A1234B");
        System.out.println("************************************************************************");
        System.out.println(ca);

        accountRep.updateAccount(ca);
        CreditAccount cr = (CreditAccount) accountRep.retrieveAccount("A1534B");
        cr.setBalance(newBAL);

        System.out.println("************************************************************************");
        System.out.println(cr);
        accountRep.updateAccount(cr);

        accountRep.deleteAccount(cr.getId());

        System.out.println("************************************************************************");
        System.out.println(accountRep);
    }
}
