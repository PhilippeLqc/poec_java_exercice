package modele;
import java.io.Serializable;

public class Fournisseur implements Serializable{
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

    public int getNumero_fournisseur() {
        return numero_fournisseur;
    }

    public void setNumero_fournisseur(int numero_fournisseur) {
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
}
