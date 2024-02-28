package dao;

import modele.Client;
import java.sql.*;

public class ClientDAO {
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_exo", "root", "");
    }

    private static void updateDatabase(String query, Object... values) {
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

    public static Client readClient(int id) {
        Client client = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM clients WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int clientId = resultSet.getInt("id");
                int clientNumeroClient = resultSet.getInt("numero_client");
                String clientNom = resultSet.getString("nom");
                String clientPrenom = resultSet.getString("prenom");
                String clientEmail = resultSet.getString("email");
                String clientAdresse = resultSet.getString("adresse");

                client = new Client(clientId, clientNumeroClient, clientNom, clientPrenom, clientEmail, clientAdresse);

                System.out.println("Client trouvé : " + client);
            } else {
                System.out.println("Aucun client trouvé avec l'ID : " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }




    public static void readAllClients() {
        String sql = "SELECT * FROM clients";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id") + ", numero_client: " + resultSet.getInt("numero_client") + ", nom: " + resultSet.getString("nom") + ", prenom: " + resultSet.getString("prenom") + ", email: " + resultSet.getString("email") + ", adresse: " + resultSet.getString("adresse"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void writeClient(Client client) {
        String sql = "INSERT INTO clients (numero_client, nom, prenom, email, adresse) VALUES (?, ?, ?, ?, ?)";
        updateDatabase(sql, client.getNumeroClient(), client.getNom(), client.getPrenom(), client.getEmail(), client.getAdresse());
        System.out.println("Client ajouté avec succès !");
    }

    public static void updateClient(Client client) {
        String sql = "UPDATE clients SET numero_client = ?, nom = ?, prenom = ?, email = ?, adresse = ? WHERE id = ?";
        updateDatabase(sql, client.getNumeroClient(), client.getNom(), client.getPrenom(), client.getEmail(), client.getAdresse(), client.getId());
        System.out.println("Client mis à jour avec succès !");
    }

    public static void deleteClient(int numeroClient) {
        String sql = "DELETE FROM clients WHERE numero_client = ?";
        updateDatabase(sql, numeroClient);
        System.out.println("Client supprimé avec succès !");
    }
}
