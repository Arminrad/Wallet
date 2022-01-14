package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void withdraw(Double amount, int id ){
        String withdrawStatement = "UPDATE wallet SET amount = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(withdrawStatement);
            preparedStatement.setDouble(1, amount);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deposit(Double amount, int id ){
        String depositStatement = "UPDATE wallet SET amount = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(depositStatement);
            preparedStatement.setDouble(1, amount);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
