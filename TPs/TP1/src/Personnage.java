import java.util.Random;

public class Personnage {
    private String nom;
    private Informations etatInitial, etatActuel;

    public Personnage(String nom, Informations etatInitial) {
        this.nom = nom;
        this.etatInitial = new Informations(etatInitial);
        this.etatActuel = new Informations(etatInitial);
    }

    public String toString() {
        return "Nom: " + this.nom + "  Etat initial: " + etatInitial.toString()
                + "  Etat actuel: " + etatActuel.toString();
    }

    public boolean estVivant() {
        return this.etatActuel.getVitalite() > 0;
    }

    public void rebirth() {
        this.etatActuel = new Informations(etatInitial);
    }

    public void attaque(Personnage def) {
        Random rd = new Random();
        // n appartient a [1,this.etatActuel.getForce() - def.etatActuel.getForce())]
        int n = rd.nextInt(Math.max(1, this.etatActuel.getForce() - def.etatActuel.getForce())) + 1;

        if (this.etatActuel.getAgilite() > def.etatActuel.getAgilite()) {
            def.etatActuel.setVitalite(def.etatActuel.getVitalite() - n);
        } else {
            def.etatActuel.setVitalite((int) (def.etatActuel.getVitalite() - n / 2));
            def.etatActuel.setAgilite((int) (def.etatActuel.getAgilite() - def.etatActuel.getAgilite() / 3));

        }
    }

    public static void lutteIt(Personnage p1, Personnage p2) {
        // Version iterative de la lutte
        int n = 0;

        while (p1.estVivant() && p2.estVivant()) {
            if (n % 2 == 0)
                p1.attaque(p2);
            else
                p2.attaque(p1);

            System.out.println("====== Round " + n + ", " + ((n % 2 == 0) ? p1.nom : p2.nom) + " ======");
            System.out.println(p1.toString());
            System.out.println(p2.toString());

            n++;
        }
    }

    public static void lutteRec(Personnage p1, Personnage p2) {
        // Version recursive de lutte
        lutteRecN(p1, p2, 1);
    }

    private static void lutteRecN(Personnage p1, Personnage p2, int n) {
        // J'utilise une fonction auxiliare juste pour pouvoir
        // afficher le numero du round.
        if (p1.estVivant() && p2.estVivant()) {
            p1.attaque(p2);
            System.out.println("====== Round, " + n + " " + p1.nom + " ======");
            System.out.println(p1.toString());
            System.out.println(p2.toString());
            lutteRecN(p2, p1, n + 1);
        }
    }

    /*
     * Version recursive sans affichage du round et donc
     * sans fonction recursive auxiliare
     *
     * public static void lutteRecN(Personnage p1, Personnage p2){
     *
     * if (p1.estVivant() && p2.estVivant()){
     * p1.attaque(p2);
     * System.out.println("====== " + p1.nom + " ======");
     * System.out.println(p1.toString());
     * System.out.println(p2.toString());
     * lutteRec(p2, p1);
     * }
     * 
     * 
     * 
     */
}
