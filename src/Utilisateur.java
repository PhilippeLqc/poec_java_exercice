import java.sql.*;
import java.io.Serializable;

public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 6428611557675044486L;
    private int id;
    private int numero_employe;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String mot_de_passe;

    public Utilisateur(int id, int numero_employe, String nom, String prenom, String email, String login, String mot_de_passe) {
        this.id = id;
        this.numero_employe = numero_employe;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
    }

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
            statement.executeUpdate("INSERT INTO Utilisateurs (numero_employe, nom, prenom, email, login, mot_de_passe) VALUES (" +
                    user.getNumero_employe() + ", '" + user.getNom() + "', '" + user.getPrenom() + "', '" + user.getEmail() + "', '" +
                    user.getLogin() + "', '" + user.getMot_de_passe() + "')");
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(Utilisateur user) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE Utilisateurs SET numero_employe = " + user.getNumero_employe() +
                    ", nom = '" + user.getNom() + "', prenom = '" + user.getPrenom() + "', email = '" + user.getEmail() +
                    "', login = '" + user.getLogin() + "', mot_de_passe = '" + user.getMot_de_passe() + "' WHERE id = " + user.getId());
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_employe() {
        return numero_employe;
    }

    public void setNumero_employe(int numero_employe) {
        this.numero_employe = numero_employe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
}
