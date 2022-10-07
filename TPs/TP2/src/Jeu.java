public class Jeu {
    private Joueur joueur;
    private Plateau plateau;

    public Jeu(Joueur j, Plateau p) {
        this.joueur = j;
        this.plateau = p;
    }

    /**
     * Boucle principale du jeu:
     * - Affiche le tableau courant
     * - Demande une action et des coordonnés
     * - Réalise l'action
     * - Teste si le jeu est fini
     * 
     * @return True si le joueur a gagne
     */

    public boolean jouer() {
        while (!this.plateau.jeuGagne() && !this.plateau.jeuPerdu()) {
            this.plateau.afficheCourant();
            char action = this.joueur.demanderAction();
            int[] coordonnes = this.joueur.demanderCoordonnes();
            if (action == 'r')
                this.plateau.revelerCase(coordonnes[0], coordonnes[1]);
            else
                this.plateau.drapeauCase(coordonnes[0], coordonnes[1]);
        }

        this.plateau.afficheCourant();
        return this.plateau.jeuGagne();
    }
}
