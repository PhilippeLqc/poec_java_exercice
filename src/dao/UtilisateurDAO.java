package dao;
import java.sql.*;
import modele.Utilisateur;

public class UtilisateurDAO extends BaseDAO{

    // read user from database by user id
    public static Utilisateur readUser(int id) {
        String query = "SELECT * FROM Utilisateurs WHERE id = ?";
        return executeSqlWithoutModifydata(query, new Object[]{id}, ResultSet -> {
            try {
                // get user data from database
                int userId = ResultSet.getInt("id");
                int numero_employe = ResultSet.getInt("numero_employe");
                String nom = ResultSet.getString("nom");
                String prenom = ResultSet.getString("prenom");
                String email = ResultSet.getString("email");
                String login = ResultSet.getString("login");
                String mot_de_passe = ResultSet.getString("mot_de_passe");
                System.out.println("Utilisateur trouvé : " + "numero employe : " + numero_employe + " " + " nom : " + nom + " " + " prenom : " + prenom + " "+ " email : " + email + " " + " login : " + login);
                return new Utilisateur(userId, numero_employe, nom, prenom, email, login, mot_de_passe);
            } catch (SQLException e) {
                // if user not found in database return null and print error message
                e.printStackTrace();
                System.out.println("Aucun utilisateur trouvé avec l'ID : " + id);
                return null;
            }
        });
    }

    // read all users from database
    public static void listUsers() {
      String query = "SELECT * FROM Utilisateurs";
      executeSqlWithoutModifydata(query, new Object[]{}, ResultSet -> {
          try {
              while (ResultSet.next()) {
                  System.out.println("id: " + ResultSet.getInt("id") + ", numero_employe: " + ResultSet.getInt("numero_employe") + ", nom: " + ResultSet.getString("nom") + ", prenom: " + ResultSet.getString("prenom") + ", email: " + ResultSet.getString("email") + ", login: " + ResultSet.getString("login"));
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return null;
      });
    }

    // add user to database
    public static void writeUser(Utilisateur user) {
        String query = "INSERT INTO Utilisateurs (numero_employe, nom, prenom, email, login, mot_de_passe) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] values = {user.getNumero_employe(), user.getNom(), user.getPrenom(), user.getEmail(), user.getLogin(), user.getMot_de_passe()};
        executeUpdate(query, values);
    }

    // update user in database by user number
    public static Utilisateur updateUser(Utilisateur user) {
        String query = "UPDATE Utilisateurs SET numero_employe = ?, nom = ?, prenom = ?, email = ?, login = ?, mot_de_passe = ? WHERE id = ?";
        Object[] values = {user.getNumero_employe(), user.getNom(), user.getPrenom(), user.getEmail(), user.getLogin(), user.getMot_de_passe(), user.getId()};
        executeUpdate(query, values);
        return null;
    }

    // delete user from database by user number
    public static void deleteUser(int numero_employe) {
        String query = "DELETE FROM Utilisateurs WHERE numero_employe = ?";
        executeUpdate(query, numero_employe);
    }

}
