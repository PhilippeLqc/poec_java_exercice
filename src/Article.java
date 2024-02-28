import java.sql.*;
import java.io.Serializable;

public class Article implements Serializable {

    enum Type {
        ACHAT, VENTE
    }

    private static final long serialVersionUID = -6726617109010147770L;
    private int id;
    private int numero_article; // Correction du nom du champ
    private String type;
    private String nom;
    private String description;

    public Article(int id, int numero_article, String type, String nom, String description) {
        this.id = id;
        this.numero_article = numero_article; // Correction du nom du champ
        this.type = type;
        this.nom = nom;
        this.description = description;
    }

    // Getter et Setter pour le champ numero_article
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_article() {
        return numero_article;
    }

    public void setNumero_article(int numero_article) {
        this.numero_article = numero_article;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_exo", "root", "");
    }

    // Méthode pour lire un article dans la base de données
    public static Article readArticle(int numero) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Articles WHERE numero_article = " + numero);
            if (resultSet.next()) {
                int articleId = resultSet.getInt("id");
                int articleNumero = resultSet.getInt("numero_article");
                String articleType = resultSet.getString("type");
                String articleNom = resultSet.getString("nom");
                String articleDescription = resultSet.getString("description");

                System.out.println("id: " + articleId + ", numero: " + articleNumero + ", type: " + articleType +
                        ", nom: " + articleNom + ", description: " + articleDescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Méthode pour lire tous les articles dans la base de données
    public static void readAllArticles() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Articles");
            while (resultSet.next()) {
                int articleId = resultSet.getInt("id");
                int articleNumero = resultSet.getInt("numero_article");
                String articleType = resultSet.getString("type");
                String articleNom = resultSet.getString("nom");
                String articleDescription = resultSet.getString("description");

                System.out.println("id: " + articleId + ", numero: " + articleNumero + ", type: " + articleType +
                        ", nom: " + articleNom + ", description: " + articleDescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour ajouter un article dans la base de données
    public static void writeArticle(Article article) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement writeArticle = connection.prepareStatement("INSERT INTO Articles (numero_article, type, nom, description) VALUES (?, ?, ?, ?)");
            writeArticle.setInt(1, article.getNumero_article());
            writeArticle.setString(2, article.getType());
            writeArticle.setString(3, article.getNom());
            writeArticle.setString(4, article.getDescription());
            writeArticle.executeUpdate();
            System.out.println("Article ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour modifier un article dans la base de données
    public static void updateArticle(Article article) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            PreparedStatement updateArticle = connection.prepareStatement("UPDATE Articles SET numero_article = ?, type = ?, nom = ?, description = ? WHERE id = ?");
            updateArticle.setInt(1, article.getNumero_article());
            updateArticle.setString(2, article.getType());
            updateArticle.setString(3, article.getNom());
            updateArticle.setString(4, article.getDescription());
            updateArticle.setInt(5, article.getId());
            updateArticle.executeUpdate();
            System.out.println("Article modifié avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un article dans la base de données
    public static void deleteArticle(int numero_article) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM Articles WHERE numero_article = " + numero_article);
            System.out.println("Article supprimé avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
