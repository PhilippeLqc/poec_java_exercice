import java.sql.*;
import java.io.Serializable;

public class Fournisseur implements Serializable{
     // La table Fournisseurs correspond aux fournisseurs de l'entreprise. Ils ont un id, un numéro unique, un nom, un email et une adresse.
    private static final long serialVersionUID = 1822501311985843059L;
    private int id;
    private int numero_fournisseur;
    private String nom;
    private String email;
    private String adresse;

    public Fournisseur(int id, int numero_fournisseur, String nom, String email, String adresse) {
        this.id = id;
        this.numero_fournisseur = numero_fournisseur;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero_fournisseur;
    }

    public void setNumero(int numero_fournisseur) {
        this.numero_fournisseur = numero_fournisseur;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_exo", "root", "");
    }

    // Méthode pour lire un fournisseur dans la base de données
    public static Fournisseur readFournisseur(int numero_fournisseur) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Fournisseurs WHERE numero_fournisseur = " + numero_fournisseur);
            if (resultSet.next()) {
                int fournisseurId = resultSet.getInt("id");
                int fournisseurNumero = resultSet.getInt("numero_fournisseur");
                String fournisseurNom = resultSet.getString("nom");
                String fournisseurEmail = resultSet.getString("email");
                String fournisseurAdresse = resultSet.getString("adresse");

                System.out.println("id: " + fournisseurId + ", numero_fournisseur: " + fournisseurNumero + ", nom: " + fournisseurNom +
                        ", email: " + fournisseurEmail + ", adresse: " + fournisseurAdresse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
    }
    // Méthode pour lire tous les fournisseurs dans la base de données
    public static void readAllFournisseurs() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Fournisseurs");
            while (resultSet.next()) {
                int fournisseurId = resultSet.getInt("id");
                int fournisseurNumero = resultSet.getInt("numero_fournisseur");
                String fournisseurNom = resultSet.getString("nom");
                String fournisseurEmail = resultSet.getString("email");
                String fournisseurAdresse = resultSet.getString("adresse");

                System.out.println("id: " + fournisseurId + ", numero_fournisseur: " + fournisseurNumero + ", nom: " + fournisseurNom +
                        ", email: " + fournisseurEmail + ", adresse: " + fournisseurAdresse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Méthode pour écrire un fournisseur dans la base de données
    public static void writeFournisseur(Fournisseur fournisseur) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement writeFournisseur = connection.prepareStatement("INSERT INTO Fournisseurs (numero_fournisseur, nom, email, adresse) VALUES (?, ?, ?, ?)");
            writeFournisseur.setInt(1, fournisseur.getNumero());
            writeFournisseur.setString(2, fournisseur.getNom());
            writeFournisseur.setString(3, fournisseur.getEmail());
            writeFournisseur.setString(4, fournisseur.getAdresse());
            writeFournisseur.executeUpdate();
            System.out.println("Fournisseur ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Méthode pour modifier un fournisseur dans la base de données
    public static void updateFournisseur(Fournisseur fournisseur) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement updateFournisseur = connection.prepareStatement("UPDATE Fournisseurs SET numero_fournisseur = ?, nom = ?, email = ?, adresse = ? WHERE id = ?");
            updateFournisseur.setInt(1, fournisseur.getNumero());
            updateFournisseur.setString(2, fournisseur.getNom());
            updateFournisseur.setString(3, fournisseur.getEmail());
            updateFournisseur.setString(4, fournisseur.getAdresse());
            updateFournisseur.setInt(5, fournisseur.getId());
            updateFournisseur.executeUpdate();
            System.out.println("Fournisseur modifié avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Méthode pour supprimer un fournisseur dans la base de données
    public static void deleteFournisseur(int numero_fournisseur) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM Fournisseurs WHERE numero_fournisseur = " + numero_fournisseur);
            System.out.println("Fournisseur supprimé avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
