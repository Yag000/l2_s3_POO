import java.util.Scanner;

public class Communication {
    private static Scanner scanner = new Scanner(System.in);

    public static Deplacement demanderDeplacement(boolean joueur, int longeur){
        System.out.println("Joueur " + (joueur ? "blanc" : "noir") + ", entrez votre deplacement (ex: a2 a3):");
        String[] deplacement = scanner.nextLine().split(" ");
        return new Deplacement(deplacement[0], deplacement[1],longeur);
    }

    public static void finir(){
        scanner.close();
    }
}
