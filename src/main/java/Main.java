import repository.ConnectionClass;
import repository.TransactionRepository;
import repository.WalletRepository;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        WalletRepository wallet = new WalletRepository();
        TransactionRepository transaction = new TransactionRepository();
        wallet.createWalletTable();
        transaction.createTransactionTable();
        wallet.insertNewWalletTable(2000000.0);
        wallet.deposit(1000000.0, 1);

    }
}
