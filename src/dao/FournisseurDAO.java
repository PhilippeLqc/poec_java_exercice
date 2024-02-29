package dao;

import java.sql.*;
import modele.Fournisseur;

public class FournisseurDAO extends BaseDAO{

    // Read a fournisseur from the database using the numero_fournisseur
    public static Fournisseur readFournisseur(int numero_fournisseur) {
        String query = "SELECT * FROM Fournisseurs WHERE numero_fournisseur = ?";
        return executeSqlWithoutModifydata(query, new Object[]{numero_fournisseur}, ResultSet -> {
            try {
                // Get the fournisseur's data from the ResultSet
                int id = ResultSet.getInt("id");
                int numero_fournisseur1 = ResultSet.getInt("numero_fournisseur");
                String nom = ResultSet.getString("nom");
                String email = ResultSet.getString("email");
                String adresse = ResultSet.getString("adresse");
                System.out.println("Fournisseur trouvé : " + "numero fournisseur : " + numero_fournisseur1 + " " + " nom : " + nom + " " + " email : " + email + " "+ " adresse : " + adresse);
                return new Fournisseur(id, numero_fournisseur1, nom, email, adresse);
            } catch (SQLException e) {
                // If the fournisseur is not found, print an error message and return null
                e.printStackTrace();
                System.out.println("Aucun fournisseur trouvé avec le numéro : " + numero_fournisseur);
                return null;
            }
        });
    }

    // List all fournisseurs in the database
    public static void listFournisseurs() {
        String query = "SELECT * FROM Fournisseurs";
        executeSqlWithoutModifydata(query, new Object[]{}, ResultSet -> {
            try {
                // Print all fournisseurs in the ResultSet
                while (ResultSet.next()) {
                    System.out.println("id: " + ResultSet.getInt("id") + ", numero_fournisseur: " + ResultSet.getInt("numero_fournisseur") + ", nom: " + ResultSet.getString("nom") + ", email: " + ResultSet.getString("email") + ", adresse: " + ResultSet.getString("adresse"));
                }
            } catch (SQLException e) {
                // Print an error message if the fournisseurs cannot be listed
                e.printStackTrace();
            }
            return null;
        });
    }

    // Write a fournisseur to the database
    public static void writeFournisseur(Fournisseur fournisseur) {
        String query = "INSERT INTO Fournisseurs (numero_fournisseur, nom, email, adresse) VALUES (?, ?, ?, ?)";
        Object[] values = {fournisseur.getNumero_fournisseur(), fournisseur.getNom(), fournisseur.getEmail(), fournisseur.getAdresse()};
        executeUpdate(query, values);
    }

    // Update a fournisseur in the database
    public static void updateFournisseur(Fournisseur fournisseur) {
        String query = "UPDATE Fournisseurs SET numero_fournisseur = ?, nom = ?, email = ?, adresse = ? WHERE id = ?";
        Object[] values = {fournisseur.getNumero_fournisseur(), fournisseur.getNom(), fournisseur.getEmail(), fournisseur.getAdresse(), fournisseur.getId()};
        executeUpdate(query, values);
    }

    // Delete a fournisseur from the database using the numero_fournisseur
    public static void deleteFournisseur(int numero_fournisseur) {
        String query = "DELETE FROM Fournisseurs WHERE numero_fournisseur = ?";
        executeUpdate(query, numero_fournisseur);
    }
}
