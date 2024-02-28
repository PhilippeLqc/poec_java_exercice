import java.util.Scanner;

public class Utilitaires {

    public static void displayMenu() {
        System.out.println("Choisissez une option : ");
        System.out.println("1. Gestion des utilisateurs");
        System.out.println("2. Gestion des clients");
        System.out.println("3. Gestion des fournisseurs");
        System.out.println("4. Gestion des articles");
        System.out.println("0. Quitter");
    }
// Utilitaire pour la gestion des utilisateurs
    public static void handleUserManagement(Scanner sc) {
        boolean userManagementRunning = true;
        while (userManagementRunning) {
            displayUserMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Lire la table complete
                    Utilisateur.listUsers();
                    break;
                case 2:
                    // Lire un enregistrement selon l'id
                    System.out.println("Entrez l'id de l'utilisateur : ");
                    int id = sc.nextInt();
                    Utilisateur.readUser(id);
                    break;
                case 3:
                    // Ecrire un nouvel utilisateur
                    createUser(sc);
                    break;
                case 4:
                    // Modifier un utilisateur
                    modifyUser(sc);
                    break;
                case 5:
                    // Supprimer un utilisateur
                    System.out.println("Entrez le numéro de l'employé à supprimer : ");
                    int numero_employe = sc.nextInt();
                    Utilisateur.deleteUser(numero_employe);
                    System.out.println("Utilisateur supprimé.");
                    break;
                case 0:
                    userManagementRunning = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }
    }

    // Utilitaire pour afficher le menu de gestion des clients
    public static void handleClientManagement(Scanner sc) {
        boolean clientManagementRunning = true;
        while (clientManagementRunning) {
            displayClientMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Lire la table complete
                    Client.readAllClients();
                    break;
                case 2:
                    // Lire un enregistrement selon l'id
                    System.out.println("Entrez l'id du client : ");
                    int id = sc.nextInt();
                    Client.readClient(id);
                    break;
                case 3:
                    // Ecrire un nouveau client
                    createClient(sc);
                    break;
                case 4:
                    // Modifier un client
                    modifyClient(sc);
                    break;
                case 5:
                    // Supprimer un client
                    System.out.println("Entrez le numéro du client à supprimer : ");
                    int numero = sc.nextInt();
                    Client.deleteClient(numero);
                    System.out.println("Client supprimé.");
                    break;
                case 0:
                    clientManagementRunning = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }
    }

    // Utilitaire pour afficher le menu de gestion des fournisseurs
    public static void handleFournisseurManagement(Scanner sc) {
        boolean fournisseurManagementRunning = true;
        while (fournisseurManagementRunning) {
            displayFournisseurMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Lire la table complete
                    Fournisseur.readAllFournisseurs();
                    break;
                case 2:
                    // Lire un enregistrement selon l'id
                    System.out.println("Entrez l'id du fournisseur : ");
                    int id = sc.nextInt();
                    Fournisseur.readFournisseur(id);
                    break;
                case 3:
                    // Ecrire un nouveau fournisseur
                    createFournisseur(sc);
                    break;
                case 4:
                    // Modifier un fournisseur
                    modifyFournisseur(sc);
                    break;
                case 5:
                    // Supprimer un fournisseur
                    System.out.println("Entrez le numéro du fournisseur à supprimer : ");
                    int numero = sc.nextInt();
                    Fournisseur.deleteFournisseur(numero);
                    System.out.println("Fournisseur supprimé.");
                    break;
                case 0:
                    fournisseurManagementRunning = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }
    }

    // Utilitaire pour afficher le menu de gestion des articles
    public static void handleArticleManagement(Scanner sc) {
        boolean articleManagementRunning = true;
        while (articleManagementRunning) {
            displayArticleMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Lire la table complete
                    Article.readAllArticles();
                    break;
                case 2:
                    // Lire un enregistrement selon l'id
                    System.out.println("Entrez l'id de l'article : ");
                    int id = sc.nextInt();
                    Article.readArticle(id);
                    break;
                case 3:
                    // Ecrire un nouvel article
                    createArticle(sc);
                    break;
                case 4:
                    // Modifier un article
                    modifyArticle(sc);
                    break;
                case 5:
                    // Supprimer un article
                    System.out.println("Entrez le numéro de l'article à supprimer : ");
                    int numero = sc.nextInt();
                    Article.deleteArticle(numero);
                    System.out.println("Article supprimé.");
                    break;
                case 0:
                    articleManagementRunning = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }
    }
    // menu de gesion des différentes classes
    public static void displayUserMenu() {
        System.out.println("Menu Gestion des utilisateurs : ");
        System.out.println("1. Lire la table complete");
        System.out.println("2. Lire un enregistrement selon l'id");
        System.out.println("3. Ecrire un nouvel utilisateur");
        System.out.println("4. Modifier un utilisateur");
        System.out.println("5. Supprimer un utilisateur");
        System.out.println("0. Retour");
    }
    public static void displayClientMenu() {
        System.out.println("Menu Gestion des clients : ");
        System.out.println("1. Lire la table complete");
        System.out.println("2. Lire un enregistrement selon l'id");
        System.out.println("3. Ecrire un nouveau client");
        System.out.println("4. Modifier un client");
        System.out.println("5. Supprimer un client");
        System.out.println("0. Retour");
    }
    public static void displayFournisseurMenu() {
        System.out.println("Menu Gestion des fournisseurs : ");
        System.out.println("1. Lire la table complete");
        System.out.println("2. Lire un enregistrement selon l'id");
        System.out.println("3. Ecrire un nouveau fournisseur");
        System.out.println("4. Modifier un fournisseur");
        System.out.println("5. Supprimer un fournisseur");
        System.out.println("0. Retour");
    }
    public static void displayArticleMenu() {
        System.out.println("Menu Gestion des articles : ");
        System.out.println("1. Lire la table complete");
        System.out.println("2. Lire un enregistrement selon l'id");
        System.out.println("3. Ecrire un nouvel article");
        System.out.println("4. Modifier un article");
        System.out.println("5. Supprimer un article");
        System.out.println("0. Retour");
    }

    // méthode de création dans les différentes classes
    private static void createUser(Scanner sc) {
        System.out.println("Entrez le numero d'employe : ");
        int numero_employe = sc.nextInt();
        System.out.println("Entrez le nom : ");
        String nom = sc.next();
        System.out.println("Entrez le prenom : ");
        String prenom = sc.next();
        System.out.println("Entrez l'email : ");
        String email = sc.next();
        System.out.println("Entrez le login : ");
        String login = sc.next();
        System.out.println("Entrez le mot de passe : ");
        String mot_de_passe = sc.next();
        Utilisateur new_user = new Utilisateur(0, numero_employe, nom, prenom, email, login, mot_de_passe);
        Utilisateur.writeUser(new_user);
        System.out.println("Utilisateur ajouté.");
    }

    private static void createClient(Scanner sc) {
        System.out.println("Entrez le numero du client : ");
        int numeroClient = sc.nextInt();
        System.out.println("Entrez le nom : ");
        String nom = sc.next();
        System.out.println("Entrez le prenom : ");
        String prenom = sc.next();
        System.out.println("Entrez l'email : ");
        String email = sc.next();
        System.out.println("Entrez l'adresse : ");
        String adresse = sc.next();
        Client new_client = new Client ( 0, numeroClient, nom, prenom, email, adresse);
        Client.writeClient(new_client);
        System.out.println("Client ajouté.");
    }

    private static void createFournisseur(Scanner sc) {
        System.out.println("Entrez le numero du fournisseur : ");
        int numero = sc.nextInt();
        System.out.println("Entrez le nom : ");
        String nom = sc.next();
        System.out.println("Entrez l'email : ");
        String email = sc.next();
        System.out.println("Entrez l'adresse : ");
        String adresse = sc.next();
        Fournisseur new_fournisseur = new Fournisseur(0, numero, nom, email, adresse);
        Fournisseur.writeFournisseur(new_fournisseur);
        System.out.println("Fournisseur ajouté.");
    }

    private static void createArticle(Scanner sc) {
        System.out.println("Entrez le numero de l'article : ");
        int numero_article = sc.nextInt();
        System.out.println("Entrez le type (ACHAT ou VENTE) : ");
        String type = sc.next();
        System.out.println("Entrez le nom : ");
        String nom = sc.next();
        System.out.println("Entrez la description : ");
        String description = sc.next();
        Article new_article = new Article(0, numero_article, type, nom, description);
        Article.writeArticle(new_article);
        System.out.println("Article ajouté.");
    }

    // Méthode de modification des différentes classes
    private static void modifyUser(Scanner sc) {
        System.out.println("Entrez l'id de l'utilisateur à modifier : ");
        int id = sc.nextInt();
        Utilisateur user = Utilisateur.readUser(id);
        if (user != null) {
            updateUserDetails(user, sc);
        } else {
            System.out.println("Utilisateur non trouvé.");
        }
    }

    private static void modifyClient(Scanner sc) {
        System.out.println("Entrez l'id du client à modifier : ");
        int id = sc.nextInt();
        Client client = Client.readClient(id);
        if (client != null) {
            updateClientDetails(client, sc);
        } else {
            System.out.println("Client non trouvé.");
        }
    }

    private static void modifyFournisseur(Scanner sc) {
        System.out.println("Entrez l'id du fournisseur à modifier : ");
        int id = sc.nextInt();
        Fournisseur fournisseur = Fournisseur.readFournisseur(id);
        if (fournisseur != null) {
            updateFournisseurDetails(fournisseur, sc);
        } else {
            System.out.println("Fournisseur non trouvé.");
        }
    }

    private static void modifyArticle(Scanner sc) {
        System.out.println("Entrez l'id de l'article à modifier : ");
        int id = sc.nextInt();
        Article article = Article.readArticle(id);
        if (article != null) {
            updateArticleDetails(article, sc);
        } else {
            System.out.println("Article non trouvé.");
        }
    }

    private static void updateUserDetails(Utilisateur user, Scanner sc) {
        System.out.println("Entrez le nouveau numero d'employe : ");
        int numero_employe = sc.nextInt();
        System.out.println("Entrez le nouveau nom : ");
        String nom = sc.next();
        System.out.println("Entrez le nouveau prenom : ");
        String prenom = sc.next();
        System.out.println("Entrez le nouvel email : ");
        String email = sc.next();
        System.out.println("Entrez le nouveau login : ");
        String login = sc.next();
        System.out.println("Entrez le nouveau mot de passe : ");
        String mot_de_passe = sc.next();

        user.setNumero_employe(numero_employe);
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setEmail(email);
        user.setLogin(login);
        user.setMot_de_passe(mot_de_passe);

        Utilisateur.updateUser(user);
        System.out.println("Utilisateur modifié.");
    }

    private static void updateClientDetails(Client client, Scanner sc) {
        System.out.println("Entrez le nouveau numero du client : ");
        int numeroClient = sc.nextInt();
        System.out.println("Entrez le nouveau nom : ");
        String nom = sc.next();
        System.out.println("Entrez le nouveau prenom : ");
        String prenom = sc.next();
        System.out.println("Entrez le nouvel email : ");
        String email = sc.next();
        System.out.println("Entrez la nouvelle adresse : ");
        String adresse = sc.next();

        client.setNumeroClient(numeroClient);
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setEmail(email);
        client.setAdresse(adresse);

        Client.updateClient(client);
        System.out.println("Client modifié.");
    }

    private static void updateFournisseurDetails(Fournisseur fournisseur, Scanner sc) {
        System.out.println("Entrez le nouveau numero du fournisseur : ");
        int numero = sc.nextInt();
        System.out.println("Entrez le nouveau nom : ");
        String nom = sc.next();
        System.out.println("Entrez le nouvel email : ");
        String email = sc.next();
        System.out.println("Entrez la nouvelle adresse : ");
        String adresse = sc.next();

        fournisseur.setNumero(numero);
        fournisseur.setNom(nom);
        fournisseur.setEmail(email);
        fournisseur.setAdresse(adresse);

        Fournisseur.updateFournisseur(fournisseur);
        System.out.println("Fournisseur modifié.");
    }

    private static void updateArticleDetails(Article article, Scanner sc) {
        System.out.println("Entrez le nouveau numero de l'article : ");
        int numero = sc.nextInt();
        System.out.println("Entrez le nouveau type (ACHAT ou VENTE) : ");
        String type = sc.next();
        System.out.println("Entrez le nouveau nom : ");
        String nom = sc.next();
        System.out.println("Entrez la nouvelle description : ");
        String description = sc.next();

        article.setNumero_article(numero);
        article.setNom(nom);
        article.setType(type);
        article.setDescription(description);

        Article.updateArticle(article);
        System.out.println("Article modifié.");
    }

}
