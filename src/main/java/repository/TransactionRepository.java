package repository;

import model.Transaction;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private Connection connection = ConnectionClass.getInstance().getConnection();

    public void createTransactionTable() {
        String createStatement = "CREATE TABLE IF NOT EXISTS transactions (" +
                "id SERIAL    PRIMARY KEY," +
                "amount       DOUBLE PRECISION ," +
                "status       varchar(10)," +
                "types        varchar(10)," +
                "walletId     integer, " +
                "FOREIGN KEY (walletId) REFERENCES wallet (id));";
        try {
            PreparedStatement transactionPrepared = connection.prepareStatement(createStatement);
            transactionPrepared.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTransactionTable(Double amount, String status, String types, int walletId) {
        String insertStatement = "INSERT INTO transactions (amount, status, types, walletId) VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement transactionPrepared = connection.prepareStatement(insertStatement);
            transactionPrepared.setDouble(1, amount);
            transactionPrepared.setString(2, status);
            transactionPrepared.setString(3, types);
            transactionPrepared.setInt(4, walletId);
            transactionPrepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> findAllTransactionTable() {
        String insertStatement = "SELECT * FROM transactions;";

        try {
            PreparedStatement transactionPrepared = connection.prepareStatement(insertStatement);
            ResultSet result = transactionPrepared.executeQuery();
            List<Transaction> transactions = new ArrayList<>();
            while (result.next()){
                Transaction transaction = new Transaction(result.getInt("id"),
                        result.getInt("walletId"),
                        result.getDouble("amount"),
                        result.getString("status"),
                        result.getString("types"));
                transactions.add(transaction);
            }
            return transactions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Transaction findIdTransactionTable(int transactionId) {
        String insertStatement = "SELECT * FROM transactions WHERE id = ?;";

        try {
            PreparedStatement transactionPrepared = connection.prepareStatement(insertStatement);
            transactionPrepared.setInt(1, transactionId);
            ResultSet result = transactionPrepared.executeQuery();
            Transaction transaction;
            while (result.next()){
                transaction = new Transaction(result.getInt("id"),
                        result.getInt("walletId"),
                        result.getDouble("amount"),
                        result.getString("status"),
                        result.getString("types"));
                return transaction;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
