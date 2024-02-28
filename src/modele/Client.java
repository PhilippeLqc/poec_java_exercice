package modele;

import java.io.Serializable;

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
    }
