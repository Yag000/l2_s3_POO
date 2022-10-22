
import java.util.LinkedList;

/**
 * Classe qui représente un paragraphe
 */
public class Paragraphe extends ChaineCar {

    LinkedList<Ligne> lignes = new LinkedList<Ligne>();

    public Paragraphe(LinkedList<Ligne> lignes) {
        if (lignes.size() != 0)
            this.lignes = lignes;
    }

    public Paragraphe() {
    }

    public int len() {
        int length = 0;

        for (Ligne l : lignes)
            length += l.len();

        return length;
    }

    /**
     * @return renvoie true si le paragraphe est vide, false sinon.
     */
    public boolean isEmpty() {
        if (lignes.size() == 0)
            return true;
        for (Ligne l : lignes)
            if (!l.isEmpty())
                return false;

        return true;
    }

    /**
     * Ajoute une chaîne de caractères à la dernière ligne du texte
     * 
     * @param c Chaîne à ajouter au texte.
     */
    public void addChaine(ChaineCar c) {
        if (lignes.size() == 0)
            lignes.add(new Ligne());

        lignes.getLast().addChaine(c);
    }

    @Override
    public String toString() {
        String s = "";

        if (lignes != null) {
            for (ChaineCar c : lignes)
                s += c;
        }
        return s;
    }
}
