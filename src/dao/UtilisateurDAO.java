package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modele.Utilisateur;
public class UtilisateurDAO {
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_exo", "root", "");
    }

    public static Utilisateur readUser(int id) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Utilisateurs WHERE id = " + id);
            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                int userNumeroEmploye = resultSet.getInt("numero_employe");
                String userNom = resultSet.getString("nom");
                String userPrenom = resultSet.getString("prenom");
                String userEmail = resultSet.getString("email");
                String userLogin = resultSet.getString("login");
                String userMotDePasse = resultSet.getString("mot_de_passe");

                System.out.println("id: " + userId + ", numero_employe: " + userNumeroEmploye + ", nom: " + userNom +
                        ", prenom: " + userPrenom + ", email: " + userEmail + ", login: " + userLogin +
                        ", mot_de_passe: " + userMotDePasse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeUser(Utilisateur user) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement writeUser = connection.prepareStatement("INSERT INTO Utilisateurs (numero_employe, nom, prenom, email, login, mot_de_passe) VALUES (?, ?, ?, ?, ?, ?)");
            writeUser.setInt(1, user.getNumero_employe());
            writeUser.setString(2, user.getNom());
            writeUser.setString(3, user.getPrenom());
            writeUser.setString(4, user.getEmail());
            writeUser.setString(5, user.getLogin());
            writeUser.setString(6, user.getMot_de_passe());
            writeUser.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(Utilisateur user) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement updateUser = connection.prepareStatement("UPDATE Utilisateurs SET numero_employe = ?, nom = ?, prenom = ?, email = ?, login = ?, mot_de_passe = ? WHERE id = ?");
            updateUser.setInt(1, user.getNumero_employe());
            updateUser.setString(2, user.getNom());
            updateUser.setString(3, user.getPrenom());
            updateUser.setString(4, user.getEmail());
            updateUser.setString(5, user.getLogin());
            updateUser.setString(6, user.getMot_de_passe());
            updateUser.setInt(7, user.getId());
            updateUser.executeUpdate();
            System.out.println("Utilisateur modifié avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(int numero_employe) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM Utilisateurs WHERE numero_employe = " + numero_employe);
            System.out.println("Utilisateur supprimé avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listUsers() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Utilisateurs");
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                int userNumeroEmploye = resultSet.getInt("numero_employe");
                String userNom = resultSet.getString("nom");
                String userPrenom = resultSet.getString("prenom");
                String userEmail = resultSet.getString("email");
                String userLogin = resultSet.getString("login");
                String userMotDePasse = resultSet.getString("mot_de_passe");

                System.out.println("id: " + userId + ", numero_employe: " + userNumeroEmploye + ", nom: " + userNom +
                        ", prenom: " + userPrenom + ", email: " + userEmail + ", login: " + userLogin +
                        ", mot_de_passe: " + userMotDePasse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
