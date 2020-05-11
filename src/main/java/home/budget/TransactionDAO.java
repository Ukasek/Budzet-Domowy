package home.budget;

import java.sql.*;
import java.util.Optional;
import java.util.Scanner;

public class TransactionDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/transaction?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Lubieplacki123412";
    private Connection connection;
    private Scanner scanner;

    public TransactionDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException exception) {
            System.err.println("Nie znaleziono sterownika");
        } catch (SQLException exception) {
            System.err.println("Nie można nawiązać połączenia");
        }
    }

    public void save(Transaction transaction) {
        String insertTransaction = "INSERT INTO transaction(type, description, amount, date) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(insertTransaction);
            statement.setString(1, transaction.getType());
            statement.setString(2, transaction.getDescription());
            statement.setDouble(3, transaction.getAmount());
            statement.setInt(4, transaction.getDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Nie udało się zapisać rekordu");
        }
        close();

    }

    public Optional<Transaction> read(long id) {
        String selectTransactionSql = "SELECT * FROM employee WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(selectTransactionSql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getLong("id"));
                transaction.setType(resultSet.getString("type"));
                transaction.setDescription(resultSet.getString("description"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setDate(resultSet.getInt("date"));
                return Optional.of(transaction);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return Optional.empty();
    }

    public void update(Transaction transaction) {
        String sql = "UPDATE transaction SET type = ?, description = ?, amount = ?, date = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, transaction.getType());
            statement.setString(2, transaction.getDescription());
            statement.setDouble(3, transaction.getAmount());
            statement.setInt(4, transaction.getDate());
            statement.setLong(5, transaction.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Błąd podczas edytowania danych " + e.getMessage());
        }
        close();
    }

    public void delete(long id) {
        String sql = "DELETE FROM transaction WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
    }

    public Transaction findByType(String type) {

        String sql = "SELECT * FROM transaction WHERE type = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, type);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String typeFromDataBase = resultSet.getString("type");
                String description = resultSet.getString("description");
                double amount = resultSet.getDouble("amount");
                int date = resultSet.getInt("date");
                Transaction transaction = new Transaction(id, typeFromDataBase, description, amount, date);
                return transaction;
            }
        } catch (SQLException e) {
            System.err.println("Nie udało się zapisać rekordu");
        }
        close();
        return null;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Nie udało się zamknąć połączenia");
        }
    }
}
