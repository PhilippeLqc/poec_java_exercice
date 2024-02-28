package dao;

import java.sql.*;
import modele.Utilisateur;

public class UtilisateurDAO {
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_exo", "root", "");
    }

    private static void executeUpdate(String query, Object... values) {
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

    private static Utilisateur executeSqlWithoutModifydata(String query, Object... values) {
        Utilisateur user = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                int userNumeroEmploye = resultSet.getInt("numero_employe");
                String userNom = resultSet.getString("nom");
                String userPrenom = resultSet.getString("prenom");
                String userEmail = resultSet.getString("email");
                String userLogin = resultSet.getString("login");
                String userMotDePasse = resultSet.getString("mot_de_passe");

                user = new Utilisateur(userId, userNumeroEmploye, userNom, userPrenom, userEmail, userLogin, userMotDePasse);
                System.out.println("Utilisateur trouvé : " + user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static Utilisateur readUser(int id) {
        String query = "SELECT * FROM Utilisateurs WHERE id = ?";
        return executeSqlWithoutModifydata(query, id);
    }

    public static void listUsers() {
        String query = "SELECT * FROM Utilisateurs";
        executeSqlWithoutModifydata(query);
    }

    public static void writeUser(Utilisateur user) {
        String query = "INSERT INTO Utilisateurs (numero_employe, nom, prenom, email, login, mot_de_passe) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] values = {user.getNumero_employe(), user.getNom(), user.getPrenom(), user.getEmail(), user.getLogin(), user.getMot_de_passe()};
        executeUpdate(query, values);
    }

    public static Utilisateur updateUser(Utilisateur user) {
        String query = "UPDATE Utilisateurs SET numero_employe = ?, nom = ?, prenom = ?, email = ?, login = ?, mot_de_passe = ? WHERE id = ?";
        Object[] values = {user.getNumero_employe(), user.getNom(), user.getPrenom(), user.getEmail(), user.getLogin(), user.getMot_de_passe(), user.getId()};
        executeUpdate(query, values);
        return null;
    }

    public static void deleteUser(int numero_employe) {
        String query = "DELETE FROM Utilisateurs WHERE numero_employe = ?";
        executeUpdate(query, numero_employe);
    }

}
