import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import constants.TradeAccountType;
import constants.Transaction;
import pojo.CashAccount;
import pojo.MarginAccount;
import repository.TradeAccountRepository;
import service.CashAccountService;
import service.MarginAccountService;
import service.TradeAccountService;

public class Main {
    static TradeAccountRepository repository = new TradeAccountRepository();
    static CashAccountService cashAccountService = new CashAccountService(repository);
    static MarginAccountService marginAccountService = new MarginAccountService(repository);

    public static void main(String[] args) {
        Path[] paths = new Path[] { Paths.get("src/capstoneProject/tradeAccount/data/accounts.txt"), Paths.get("src/capstoneProject/tradeAccount/data/transactions.txt") };
        final String SEPARATOR = " ";

        try{
            loadTradeAccounts(paths[0], SEPARATOR);
            finalTest();

            applyTransactions(paths[1], SEPARATOR);
            finalTest();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void loadTradeAccounts(Path filePath, String separator) throws IOException {
        Files.lines(filePath)
                .forEach(line -> {
                    String[] temp = line.split(separator);

                    if (temp[0].toUpperCase().equals(TradeAccountType.CASH.toString())) {
                        cashAccountService.createTradeAccount(new CashAccount(temp[1], new BigDecimal(temp[2])));
                    } else {
                        marginAccountService.createTradeAccount(new MarginAccount(temp[1], new BigDecimal(temp[2])));
                    }
                });
    }

    public static void applyTransactions(Path filePath, String separator) throws IOException {
        Files.lines(filePath)
                .forEach(line -> {
                    String[] temp = line.split(separator);
                    boolean isCashAccount = temp[0].toUpperCase().equals(TradeAccountType.CASH.toString());
                    TradeAccountService accountService = isCashAccount? cashAccountService : marginAccountService;
                    
                    if (temp[2].toUpperCase().equals(Transaction.DEPOSIT.toString())) {
                        accountService.deposit(temp[1], new BigDecimal(temp[3]));
                    } else {
                        accountService.withdraw(temp[1], new BigDecimal(temp[3]));
                    }
                });
    }

    public static void finalTest() throws IOException {
        System.out.println("\n\n************************************************************************");
        System.out.println("Account A1234B Cash Balance: " + cashAccountService.retrieveTradeAccount("A1234B").getCashBalance());
        System.out.println("Account E3456F Cash Balance: " + cashAccountService.retrieveTradeAccount("E3456F").getCashBalance());
        System.out.println("Account I5678J Cash Balance: " + cashAccountService.retrieveTradeAccount("I5678J").getCashBalance());
        System.out.println("Account C2345D Margin: " + marginAccountService.retrieveTradeAccount("C2345D").getMargin());
        System.out.println("Account G4567H Margin: " + marginAccountService.retrieveTradeAccount("G4567H").getMargin());
    }
}
