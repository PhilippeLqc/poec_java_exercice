package dao;

import modele.Article;
import java.sql.*;

public class ArticleDAO extends BaseDAO{

    public static Article readArticle(int numero) {
        String query = "SELECT * FROM Articles WHERE numero_article = ?";
        return executeSqlWithoutModifydata(query, new Object[]{numero}, ResultSet -> {
            try {
                int id = ResultSet.getInt("id");
                int numero_article = ResultSet.getInt("numero_article");
                String type = ResultSet.getString("type");
                String nom = ResultSet.getString("nom");
                String description = ResultSet.getString("description");
                System.out.println("Article trouvé : " + "numero article : " + numero_article + " " + " type : " + type + " " + " nom : " + nom + " "+ " description : " + description);
                return new Article(id, numero_article, type, nom, description);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Aucun article trouvé avec le numéro : " + numero);
                return null;
            }
        });
    }

    public static void readAllArticles() {
        String query = "SELECT * FROM Articles";
        executeSqlWithoutModifydata(query, new Object[]{}, ResultSet -> {
            try {
                while (ResultSet.next()) {
                    System.out.println("id: " + ResultSet.getInt("id") + ", numero_article: " + ResultSet.getInt("numero_article") + ", type: " + ResultSet.getString("type") + ", nom: " + ResultSet.getString("nom") + ", description: " + ResultSet.getString("description"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
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
