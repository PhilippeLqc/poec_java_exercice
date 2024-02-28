package modele;
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
