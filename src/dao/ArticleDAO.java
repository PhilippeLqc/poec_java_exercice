package dao;

import modele.Article;
import java.sql.*;

public class ArticleDAO {
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_exo", "root", "");
    }

    private static void executeUpdate(String query, Object... values) {
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

    private static Article executeSqlWithoutModifydata(String query, Object... values) {
        Article article = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int articleId = resultSet.getInt("id");
                int articleNumero = resultSet.getInt("numero_article");
                String articleType = resultSet.getString("type");
                String articleNom = resultSet.getString("nom");
                String articleDescription = resultSet.getString("description");

                article = new Article(articleId, articleNumero, articleType, articleNom, articleDescription);

                System.out.println("Article trouvé : " + article);
            } else {
                System.out.println("Aucun article trouvé.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    public static Article readArticle(int numero) {
        String query = "SELECT * FROM Articles WHERE numero_article = ?";
        return executeSqlWithoutModifydata(query, numero);
    }

    public static void readAllArticles() {
        String query = "SELECT * FROM Articles";
        executeSqlWithoutModifydata(query);
    }

    public static void writeArticle(Article article) {
        String query = "INSERT INTO Articles (numero_article, type, nom, description) VALUES (?, ?, ?, ?)";
        executeUpdate(query, article.getNumero_article(), article.getType(), article.getNom(), article.getDescription());
    }

    public static void updateArticle(Article article) {
        String query = "UPDATE Articles SET numero_article = ?, type = ?, nom = ?, description = ? WHERE id = ?";
        executeUpdate(query, article.getNumero_article(), article.getType(), article.getNom(), article.getDescription(), article.getId());
    }

    public static void deleteArticle(int numero_article) {
        String query = "DELETE FROM Articles WHERE numero_article = ?";
        executeUpdate(query, numero_article);
    }
}
