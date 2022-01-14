package Service;

import repository.TransactionRepository;

public class TransactionService {
    TransactionRepository transactionRepository = new TransactionRepository();



    public void deposit(double amount, int walletId){
        transactionRepository.insertTransactionTable(amount, "ACCEPTED", "DEPOSIT", walletId);
        transactionRepository.deposit(amount, walletId);
    }

    public void withdraw(double amount, int walletId){

    }

}
