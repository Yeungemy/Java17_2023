import constants.AccountType;
import constants.Transaction;
import dataRepository.DataRepo;
import pojo.CashAccount;
import pojo.MarginAccount;
import service.AccountService;
import service.CashAccountService;
import service.MarginAccountService;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    static DataRepo dataRepo = new DataRepo();
    static CashAccountService cashAccountService = new CashAccountService(dataRepo);
    static MarginAccountService marginAccountService = new MarginAccountService(dataRepo);
    static Path accountFile = Paths.get("src/data/accounts.txt");
    static Path transactionsFile = Paths.get("src/data/transactions.txt");

    public static void main(String[] args) {
        try {
            loadAccounts();
            applyTransactions();
            finalTest();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void loadAccounts() throws IOException {
        Files.lines(accountFile)
                .forEach(line -> {
                    String[] temp = line.split(" ");

                    if(temp[0].equals(AccountType.CASH.toString())){
                        // create a cash account
                        CashAccount account = new CashAccount(temp[1], new BigDecimal(temp[2]));

                        // add to account store
                        cashAccountService.createAccount(account);
                    }else {
                        // create a margin account
                        MarginAccount account = new MarginAccount(temp[1], new BigDecimal(temp[2]));

                        // add to account store
                        marginAccountService.createAccount(account);
                    }
                });
    }

    public static void applyTransactions() throws IOException {
        Files.lines(transactionsFile)
                .forEach(line -> {
                    String[] temp = line.split(" ");
                    boolean isCash = temp[0].equals(AccountType.CASH.toString());
                    AccountService accountService = isCash? cashAccountService : marginAccountService;

                    if(temp[2].equals(Transaction.DEPOSIT.toString())){
                        accountService.deposit(temp[1], new BigDecimal(temp[3]));
                    }else {
                        accountService.withdraw(temp[1], new BigDecimal(temp[3]));
                    }
                });
    }

    public static void finalTest(){
        System.out.println("\n\n************************************************************************");
        System.out.println("Account A1234B Cash Balance: " + cashAccountService.retrieveAccount("A1234B").getAmount());
        System.out.println("Account E3456F Cash Balance: " + cashAccountService.retrieveAccount("E3456F").getAmount());
        System.out.println("Account I5678J Cash Balance: " + cashAccountService.retrieveAccount("I5678J").getAmount());
        System.out.println("Account C2345D Margin: " + marginAccountService.retrieveAccount("C2345D").getAmount());
        System.out.println("Account G4567H Margin: " + marginAccountService.retrieveAccount("G4567H").getAmount());
    }
}