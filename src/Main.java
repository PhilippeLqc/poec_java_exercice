import Utilitaires.Utilitaires;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    private void start() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            Utilitaires.displayMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Utilitaires.handleUserManagement(sc);
                    break;
                case 2:
                    Utilitaires.handleClientManagement(sc);
                    break;
                case 3:
                    Utilitaires.handleFournisseurManagement(sc);
                    break;
                case 4:
                    Utilitaires.handleArticleManagement(sc);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }
        sc.close();
    }
}
