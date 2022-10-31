
/**
 * Classe qui représente un paragraphe avec une longeur maximale de caractères
 * par page, qui indente les paragraphes et qui justifie le texte
 */
public class ParagrapheJoli extends Paragraphe {
    private int maxLengthPage;

    public ParagrapheJoli(int maxLengthPage) {
        this.maxLengthPage = maxLengthPage;
    }

    /**
     * Ajoute une chaîne de caractères à la dernière ligne du texte. La fonction
     * crée une nouvelle ligne si la ligne dépasse le nombre maximal de caractères
     * par liges et justifie la ligne précédente.
     * 
     * @param c Chaîne à ajouter au texte.
     */
    @Override
    public void addChaine(ChaineCar c) {
        if (lignes.size() == 0) {
            lignes.add(new Ligne(c));
        } else {
            Ligne lastLine = lignes.getLast();
            if (lastLine.len() + c.len() <= maxLengthPage) {
                lastLine.addChaine(c);
            } else {
                lastLine.removeLastSpace();
                lastLine.justifier(Math.max(0, maxLengthPage - lastLine.len()));
                lignes.add(new Ligne());
                if (!(c instanceof Espace))
                    lignes.getLast().addChaine(c);
            }
        }
    }

    @Override
    public String toString() {
        String s = "";

        if (lignes != null)
            for (Ligne l : lignes)
                s += l.toString() + "\n";

        return s;

    }
}
