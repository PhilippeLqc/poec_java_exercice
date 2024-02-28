package dao;

import java.sql.*;
import modele.Fournisseur;

public class FournisseurDAO {
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_exo", "root", "");
    }

    private static void executeUpdate(String query, Object... values) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            statement.executeUpdate(); // ou statement.executeUpdate();
            System.out.println("Requête exécutée avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Fournisseur executeSqlWithoutModifydata(String query, Object... values) {
        Fournisseur fournisseur = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int fournisseurId = resultSet.getInt("id");
                int fournisseurNumero = resultSet.getInt("numero_fournisseur");
                String fournisseurNom = resultSet.getString("nom");
                String fournisseurEmail = resultSet.getString("email");
                String fournisseurAdresse = resultSet.getString("adresse");

                fournisseur = new Fournisseur(fournisseurId, fournisseurNumero, fournisseurNom, fournisseurEmail, fournisseurAdresse);
                System.out.println("Fournisseur trouvé : " + fournisseur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fournisseur;
    }

    public static Fournisseur readFournisseur(int numero_fournisseur) {
        String query = "SELECT * FROM Fournisseurs WHERE numero_fournisseur = ?";
        return executeSqlWithoutModifydata(query, numero_fournisseur);
    }

    public static void listFournisseurs() {
        String query = "SELECT * FROM Fournisseurs";
        executeSqlWithoutModifydata(query);
    }

    public static void writeFournisseur(Fournisseur fournisseur) {
        String query = "INSERT INTO Fournisseurs (numero_fournisseur, nom, email, adresse) VALUES (?, ?, ?, ?)";
        Object[] values = {fournisseur.getNumero_fournisseur(), fournisseur.getNom(), fournisseur.getEmail(), fournisseur.getAdresse()};
        executeUpdate(query, values);
    }

    public static void updateFournisseur(Fournisseur fournisseur) {
        String query = "UPDATE Fournisseurs SET numero_fournisseur = ?, nom = ?, email = ?, adresse = ? WHERE id = ?";
        Object[] values = {fournisseur.getNumero_fournisseur(), fournisseur.getNom(), fournisseur.getEmail(), fournisseur.getAdresse(), fournisseur.getId()};
        executeUpdate(query, values);
    }

    public static void deleteFournisseur(int numero_fournisseur) {
        String query = "DELETE FROM Fournisseurs WHERE numero_fournisseur = ?";
        executeUpdate(query, numero_fournisseur);
    }
}
