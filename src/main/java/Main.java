import model.Wallet;
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
        Wallet wallet1 = wallet.findIdWalletTable(1);
        double newAmount = wallet1.getAmount() + 10.0;
        transaction.deposit(newAmount, wallet1.getId());

    }
}
