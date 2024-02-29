package dao;

import java.sql.*;
import modele.Fournisseur;

public class FournisseurDAO extends BaseDAO{

    public static Fournisseur readFournisseur(int numero_fournisseur) {
        String query = "SELECT * FROM Fournisseurs WHERE numero_fournisseur = ?";
        return executeSqlWithoutModifydata(query, new Object[]{numero_fournisseur}, ResultSet -> {
            try {
                int id = ResultSet.getInt("id");
                int numero_fournisseur1 = ResultSet.getInt("numero_fournisseur");
                String nom = ResultSet.getString("nom");
                String email = ResultSet.getString("email");
                String adresse = ResultSet.getString("adresse");
                System.out.println("Fournisseur trouvé : " + "numero fournisseur : " + numero_fournisseur1 + " " + " nom : " + nom + " " + " email : " + email + " "+ " adresse : " + adresse);
                return new Fournisseur(id, numero_fournisseur1, nom, email, adresse);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Aucun fournisseur trouvé avec le numéro : " + numero_fournisseur);
                return null;
            }
        });
    }

    public static void listFournisseurs() {
        String query = "SELECT * FROM Fournisseurs";
        executeSqlWithoutModifydata(query, new Object[]{}, ResultSet -> {
            try {
                while (ResultSet.next()) {
                    System.out.println("id: " + ResultSet.getInt("id") + ", numero_fournisseur: " + ResultSet.getInt("numero_fournisseur") + ", nom: " + ResultSet.getString("nom") + ", email: " + ResultSet.getString("email") + ", adresse: " + ResultSet.getString("adresse"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
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
