package dao;
import java.sql.*;
import java.util.function.Function;

public abstract class BaseDAO {

    // This method is used to get a connection to the database
    protected static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_exo", "root", "");
    }

    // This method is used to execute an update query
    protected static void executeUpdate(String query, Object... values) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            statement.executeUpdate();
            System.out.println("Requête exécutée avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // This method is used to execute a query that does not modify the database
    protected static <T> T executeSqlWithoutModifydata(String query, Object[] values, Function<ResultSet, T> mapper) {
        T result = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = mapper.apply(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
