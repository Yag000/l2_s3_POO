import java.util.Scanner;

public class Joueur {
    private String nom;
    private Scanner scanReponse;


    public Joueur (){
        this.nom = "Anonyme";
        this.scanReponse = new Scanner(System.in);
    }

    public void setNom(){
        System.out.println("Quel est votre nom?");
        this.nom = scanReponse.nextLine();
    }

    /**
     * Fermeture de l'instance de Scanner
     */
    public void finir(){
        this.scanReponse.close();
    }


    /**
     * Demande au joeur s'il veut jouer
     * @return True s'il repond: oui, Oui, y, yes, Yes
     */
    public boolean veutJouer(){
        System.out.println("Voulez-vous jouer (oui/non) ?");
        String answer = this.scanReponse.nextLine(); 
        return  answer.equals("oui") ||answer.equals("Oui")
        || answer.equals("y") ||answer.equals("yes") ||answer.equals("Yes");
    }

    /**
     * Demande le nom du joueur
     * @return Le nom introduit par le joueur
     */
    public String demanderNom(){
        System.out.println("Ecrivez votre nom: ");

        return this.scanReponse.nextLine();
    }

    /**
     * Demande au joeur le nombre de mines qu'il veut
     * @return Le nombre de mines choisi
     */
    public int demanderMines(){
        System.out.println("Ecrivez le nombre de mines que vous voulez");
        return Integer.valueOf(this.scanReponse.nextLine());
    }


    /**
     * Demande au joueur la dimnesion du plateau,
     * separe par une virgule   
     * 
     * @return
     */

    public int[] demanderDimensions(){
        System.out.println("Ecrivez les dimesions du plateau, separees par une virgule: ");

        String[] parts =  this.scanReponse.nextLine().split(",");

        int[] dimensions = new int[parts.length];
        
        for (int i = 0; i < dimensions.length; i++){
            dimensions[i] = Integer.valueOf(parts[i]);
        }

        return dimensions;
    }


    /**
     * Demande au joueur le type d'action
     * qu'il eut realiser (d, r)
     * 
     * @return Renvoie la reponse du joueur
     */

    public char demanderAction(){
        System.out.println("Voulez-vous reveler une case (r) ou placer un drapeau (d) ?");
        return this.scanReponse.nextLine().charAt(0);
    }
    

    /**
     * Demande au joueur d'introduir les coordonees
     * de son acton, sous la form d'une lettre en mayusule
     * et une nombre 
     * 
     * @return Renvoi les coordones sous la forme d'un index
     */
    public int[] demanderCoordonnes(){
        System.out.println("Ecrivez les coordonees, en format LettreNumero");
        String answer = this.scanReponse.nextLine();
        int xAxis = ((((int) answer.charAt(0)) - ((int) 'A')) + 1);
        System.out.println(xAxis +"," + Integer.parseInt(answer.substring(1)));
        return new int[] {xAxis, Integer.parseInt(answer.substring(1))};
    }

}
