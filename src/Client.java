import java.io.Serializable;
import java.sql.*;

public class Client implements Serializable {
     // La table Clients contiendra les client de l'entreprise. Ils ont un id, un numero unique, un nom, un prenom, un email et une adresse.
    private static final long serialVersionUID = 931005453988987006L;
    private int id;
    private int numeroClient;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;

    public Client(int id, int numeroClient, String nom, String prenom, String email, String adresse) {
        this.id = id;
        this.numeroClient = numeroClient;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroClient() {
        return numeroClient;
    }

    public void setNumeroClient(int numeroClient) {
        this.numeroClient = numeroClient;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_exo", "root", "");
    }

    // Méthode pour lire un client dans la base de données
    public static Client readClient(int id) {
        try (Connection connection = getConnection();
            Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM clients WHERE id = " + id);
                if (resultSet.next()) {
                    int clientId = resultSet.getInt("id");
                    int clientNumeroClient = resultSet.getInt("numero_client");
                    String clientNom = resultSet.getString("nom");
                    String clientPrenom = resultSet.getString("prenom");
                    String clientEmail = resultSet.getString("email");
                    String clientAdresse = resultSet.getString("adresse");
                    System.out.println("id: " + clientId + ", numero_client: " + clientNumeroClient + ", nom: " + clientNom + ", prenom: " + clientPrenom + ", email: " + clientEmail + ", adresse: " + clientAdresse);
                }
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    // Méthode pour lire la liste des clients dans la base de données
    public static void readAllClients() {
        try (Connection connection = getConnection()) {
            PreparedStatement readAllClients = connection.prepareStatement("SELECT * FROM clients");
            ResultSet result = readAllClients.executeQuery();
            while (result.next()) {
                System.out.println("id: " + result.getInt("id") + ", numero_client: " + result.getInt("numero_client") + ", nom: " + result.getString("nom") + ", prenom: " + result.getString("prenom") + ", email: " + result.getString("email") + ", adresse: " + result.getString("adresse"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Méthode pour ajouter un client dans la base de données
public static void writeClient(Client client) {
        try (Connection connection = getConnection()) {
            PreparedStatement writeClient = connection.prepareStatement("INSERT INTO clients (numero_client, nom, prenom, email, adresse) VALUES (?, ?, ?, ?, ?)");
            writeClient.setInt(1, client.getNumeroClient());
            writeClient.setString(2, client.getNom());
            writeClient.setString(3, client.getPrenom());
            writeClient.setString(4, client.getEmail());
            writeClient.setString(5, client.getAdresse());
            writeClient.executeUpdate();
            System.out.println("Client ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Méthode pour mettre à jour un client dans la base de données
    public static void updateClient(Client client) {
        try (Connection connection = getConnection()) {
            PreparedStatement updateClient = connection.prepareStatement("UPDATE clients SET numero_client = ?, nom = ?, prenom = ?, email = ?, adresse = ? WHERE id = ?");
            updateClient.setInt(1, client.getNumeroClient());
            updateClient.setString(2, client.getNom());
            updateClient.setString(3, client.getPrenom());
            updateClient.setString(4, client.getEmail());
            updateClient.setString(5, client.getAdresse());
            updateClient.setInt(6, client.getId());
            updateClient.executeUpdate();
            System.out.println("Client mis à jour avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Méthode pour supprimer un client dans la base de données
    public static void deleteClient(int numeroClient) {
        try (Connection connection = getConnection()) {
            PreparedStatement deleteClient = connection.prepareStatement("DELETE FROM clients WHERE numero_client = ?");
            deleteClient.setInt(1, numeroClient);
            deleteClient.executeUpdate();
            System.out.println("Client supprimé avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
