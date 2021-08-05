import java.sql.*;

public class TransactionDao {

    private Connection connection = connect();
    private PreparedStatement preparedStatement = null;

    public void insert(Transaction transaction) {
        try {
            String sql = "INSERT INTO transactions(type, description, amount, date) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setDate(4, Date.valueOf(transaction.getDate()));
            preparedStatement.executeUpdate();
        } catch (IllegalArgumentException e) {
            System.out.println("Niepoprawny format daty.");
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + e.getMessage());
        }
        closeConnection(connection);
    }

    public void update(Transaction transaction) {
        try {
            String sql = "UPDATE transactions SET type = ? , description = ?, amount = ?, date = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setDate(4, Date.valueOf(transaction.getDate()));
            preparedStatement.setLong(5, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + e.getMessage());
        }
        closeConnection(connection);
    }

    public void deleteById(Long id) {
        try {
            String sql = "DELETE FROM transactions WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + e.getMessage());
        }
        closeConnection(connection);
    }

    public Transaction findByType(String type) {
        try {
            String sql = "SELECT * FROM transactions WHERE type = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String transactionType = resultSet.getString("type");
                String description = resultSet.getString("description");
                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");
                Transaction transaction = new Transaction(id, transactionType, description, amount, date);
                return transaction;
            }
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + e.getMessage());
        }
        closeConnection(connection);
        return null;
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/wallet?serverTimezone=UTC&characterEncoding=utf8";
        try {
            return DriverManager.getConnection(url, "root", "9019");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
