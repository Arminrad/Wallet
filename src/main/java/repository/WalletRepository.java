package repository;

import model.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WalletRepository {
    private Connection connection = ConnectionClass.getInstance().getConnection();
    public void createWalletTable(){
        String createStatement = "CREATE TABLE IF NOT EXISTS wallet(" +
                "id SERIAL PRIMARY KEY," +
                "amount DOUBLE PRECISION );";
        try {
            PreparedStatement walletPrepared = connection.prepareStatement(createStatement);
            walletPrepared.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertNewWalletTable(Double amount) {
        String insertStatement = "INSERT INTO wallet (amount) VALUES (?);";

        try {
            PreparedStatement transactionPrepared = connection.prepareStatement(insertStatement);
            transactionPrepared.setDouble(1, amount);
            transactionPrepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Wallet> findAllWalletTable() {
        String findAllStatement = "SELECT * FROM wallet;";

        try {
            PreparedStatement walletPrepared = connection.prepareStatement(findAllStatement);
            ResultSet result = walletPrepared.executeQuery();
            List<Wallet> wallets = new ArrayList<>();
            while (result.next()){
                Wallet wallet = new Wallet(result.getInt("id"), result.getDouble("amount"));
                wallets.add(wallet);
            }
            return wallets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Wallet findIdWalletTable(int walletId) {
        String findIdStatement = "SELECT * FROM wallet WHERE id = ?;";

        try {
            PreparedStatement walletPrepared = connection.prepareStatement(findIdStatement);
            walletPrepared.setInt(1, walletId);
            ResultSet result = walletPrepared.executeQuery();
            while (result.next()){
                Wallet wallet = new Wallet(result.getInt("id"), result.getDouble("amount"));
                return wallet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
