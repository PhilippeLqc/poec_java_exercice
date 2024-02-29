package dao;
import modele.Client;
import java.sql.*;

public class ClientDAO extends BaseDAO{

    // read client from the client id
    public static Client readClient(int id) {
        String sql = "SELECT * FROM clients WHERE id = ?";
        return executeSqlWithoutModifydata(sql, new Object[]{id}, resultSet -> {
            try {
                // get the client from the result set
                int clientId = resultSet.getInt("id");
                int numeroClient = resultSet.getInt("numero_client");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String adresse = resultSet.getString("adresse");
                System.out.println("Client trouvé : " + "numero client : " + numeroClient + " " + " nom : " + nom + " " + " prenom : " + prenom + " "+ " email : " + email + " " + " adresse : " + adresse);
                return new Client(clientId, numeroClient, nom, prenom, email, adresse);
            } catch (SQLException e) {
                // print the error message
                e.printStackTrace();
                System.out.println("Aucun client trouvé avec l'ID : " + id);
                return null;
            }
        });
    }

    // list all clients in the database
    public static void readAllClients() {
        String sql = "SELECT * FROM clients";
        executeSqlWithoutModifydata(sql, new Object[]{}, resultSet -> {
            try {
                while (resultSet.next()) {
                    System.out.println("id: " + resultSet.getInt("id") + ", numero_client: " + resultSet.getInt("numero_client") + ", nom: " + resultSet.getString("nom") + ", prenom: " + resultSet.getString("prenom") + ", email: " + resultSet.getString("email") + ", adresse: " + resultSet.getString("adresse"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    // write a client to the database
    public static void writeClient(Client client) {
        String sql = "INSERT INTO clients (numero_client, nom, prenom, email, adresse) VALUES (?, ?, ?, ?, ?)";
        executeUpdate(sql, client.getNumeroClient(), client.getNom(), client.getPrenom(), client.getEmail(), client.getAdresse());
        System.out.println("Client ajouté avec succès !");
    }

    // update a client in the database from the client number
    public static void updateClient(Client client) {
        String sql = "UPDATE clients SET numero_client = ?, nom = ?, prenom = ?, email = ?, adresse = ? WHERE id = ?";
        executeUpdate(sql, client.getNumeroClient(), client.getNom(), client.getPrenom(), client.getEmail(), client.getAdresse(), client.getId());
        System.out.println("Client mis à jour avec succès !");
    }

    // delete a client from the database from the client number
    public static void deleteClient(int numeroClient) {
        String sql = "DELETE FROM clients WHERE numero_client = ?";
        executeUpdate(sql, numeroClient);
        System.out.println("Client supprimé avec succès !");
    }
}
