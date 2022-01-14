package Service;

import model.Wallet;
import repository.WalletRepository;

public class WalletService {
    private WalletRepository walletRepository = new WalletRepository();



    public void createWallet(double amount){
        walletRepository.insertNewWalletTable(amount);
    }

    public double showBalance(int walletId){
        Wallet wallet = findById(walletId);
        return wallet.getAmount();
    }

    public Wallet findById(int walletId){
        return walletRepository.findIdWalletTable(walletId);
    }
}
