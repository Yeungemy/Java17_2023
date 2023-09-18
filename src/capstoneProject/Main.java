package capstoneProject;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// import java.util.Arrays;
// import java.util.List;

import constants.AccountType;
import constants.Transaction;
import capstoneProject.bankAccount.pojo.Account;
import capstoneProject.bankAccount.pojo.CheckAccount;
import capstoneProject.bankAccount.pojo.CreditAccount;
import capstoneProject.bankAccount.repository.AccountRepository;
import capstoneProject.bankAccount.service.AccountService;
import capstoneProject.bankAccount.service.CheckAccountService;
import capstoneProject.bankAccount.service.CreditAccountService;

public class Main {
    static Path fpAccount = Paths.get("src/capstoneProject/bankAccount/data/accounts.txt");
    static Path fpTransaction = Paths.get("src/capstoneProject/bankAccount/data/transactions.txt");
    static AccountRepository accountRep = new AccountRepository();
    static CheckAccountService checkAccountService = new CheckAccountService(accountRep);
    static CreditAccountService creditAccountService = new CreditAccountService(accountRep);
    static final String SEPARATOR = " ";

    public static void main(String[] args) {
        final BigDecimal BAL = new BigDecimal(200);
        BigDecimal newBAL = new BigDecimal(800);

        // // Assume these were obtained from user input.
        // List<Account> accounts = Arrays.asList(
        // new CheckAccount("A1234B", new BigDecimal("500.00")),
        // new CheckAccount("E3456F", new BigDecimal("300.50")),
        // new CheckAccount("I5678J", new BigDecimal("100.25")),
        // new CreditAccount("A1534B", new BigDecimal("0.50")),
        // new CreditAccount("G4567H", new BigDecimal("200.00"))
        // );

        // /** populate accounts to the data repo */
        // accounts.stream()
        // .forEach(account -> {
        // if(account instanceof CheckAccount){
        // checkAccountService.createAccount((CheckAccount) account);
        // }else{
        // creditAccountService.createAccount((CreditAccount) account);
        // }
        // });

        // System.out.println("************************************************************************");

        // System.out.println(accountRep);

        // System.out.println("************************************************************************");
        // System.out.println(accountRep.filterAccountByBalance(BAL));

        // CheckAccount ca = (CheckAccount) accountRep.retrieveAccount("A1234B");
        // System.out.println("************************************************************************");
        // System.out.println(ca);

        // accountRep.updateAccount(ca);
        // CreditAccount cr = (CreditAccount) accountRep.retrieveAccount("A1534B");
        // cr.setBalance(newBAL);

        // System.out.println("************************************************************************");
        // System.out.println(cr);
        // accountRep.updateAccount(cr);

        // accountRep.deleteAccount(cr.getId());

        try{
            loadAccounts(fpAccount, SEPARATOR);
            finalTest();

            applyTransactions(fpTransaction, SEPARATOR);
            finalTest();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void loadAccounts(Path filePath, String separator) throws IOException {
        Files.lines(filePath)
                .forEach(line -> {
                    String[] temp = line.split(separator);

                    if (temp[0].toUpperCase().equals(AccountType.CHECKING.toString())) {
                        // create an account
                        Account account = new CheckAccount(temp[1], new BigDecimal(temp[2]));

                        // insert into repository
                        checkAccountService.createAccount(account);
                    } else {
                        // create an account
                        Account account = new CreditAccount(temp[1], new BigDecimal(temp[2]));

                        // insert into repository
                        creditAccountService.createAccount(account);
                    }
                });
    }

    public static void applyTransactions(Path filePath, String separator) throws IOException {
        Files.lines(filePath)
                .forEach(line -> {
                    String[] temp = line.split(separator);
                    boolean isChecking = temp[0].toUpperCase().equals(AccountType.CHECKING.toString());
                    AccountService accountService = isChecking ? checkAccountService : creditAccountService;
                    boolean isDeposit = temp[2].toUpperCase().equals(Transaction.DEPOSIT.toString());

                    if (isDeposit) {
                        accountService.deposit(temp[1], new BigDecimal(temp[3]));
                    } else {
                        accountService.withdraw(temp[1], new BigDecimal(temp[3]));
                    }
                });
    }

    public static void finalTest() throws IOException {
        System.out.println("\n\n************************************************************************");
        // System.out.println("Account A1234B Balance: " + checkAccountService.retrieveAccount("A1234B").getBalance());
        // System.out.println("Account E3456F Balance: " + checkAccountService.retrieveAccount("E3456F").getBalance());
        // System.out.println("Account I5678J Balance: " + checkAccountService.retrieveAccount("I5678J").getBalance());
        // System.out.println("Account C2345D Credit: " + creditAccountService.retrieveAccount("C2345D").getBalance());
        // System.out.println("Account G4567H Credit: " + creditAccountService.retrieveAccount("G4567H").getBalance());
        System.out.println(accountRep);
    }
}
