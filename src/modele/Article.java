package modele;
import java.io.Serializable;
public class Article implements Serializable{
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
}
