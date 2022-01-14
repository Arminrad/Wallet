package Service;

import model.Wallet;
import repository.TransactionRepository;

public class TransactionService {
   private TransactionRepository transactionRepository = new TransactionRepository();
   private WalletService walletService = new WalletService();


    public void deposit(double amount, int walletId){
        Wallet wallet = walletService.findById(walletId);
        if(wallet == null){
            System.out.println("Wallet not finde");
        }else {
            transactionRepository.insertTransactionTable(amount, "ACCEPTED", "DEPOSIT", walletId);
            transactionRepository.deposit(wallet.getAmount() + amount, walletId);
        }
    }

    public void withdraw(double amount, int walletId){

    }

}
