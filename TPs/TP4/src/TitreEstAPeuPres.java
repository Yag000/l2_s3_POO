public class TitreEstAPeuPres extends Predicat {
    private String titre;
    private int distance;

    public TitreEstAPeuPres(String titre, int distance) {
        this.titre = titre;
        this.distance = distance;
    }

    /**
     * Elle renvoie vrai si la distance de Levenshtein entre le titre du document et
     * le titre de la requête est inférieure ou égale à la distance spécifiée dans
     * la requête.
     * 
     * Pour cette implementation du calcul j'utilise l'algorithme de Wagner–Fischer.
     * Source: "https://en.wikipedia.org/wiki/Wagner%E2%80%93Fischer_algorithm"
     * 
     * @param doc le document à tester
     * @return true si le nombre de differences est inférieur ou égale a
     *         this.distance, false sinon
     */
    @Override
    public boolean estVrai(Media doc) {
        String docTitre = doc.getTitre();
        int[][] matrice = new int[docTitre.length() + 1][titre.length() + 1];

        // Initialisation de la matrice.
        for (int i = 0; i <= docTitre.length(); i++) {
            matrice[i][0] = i;
        }
        for (int j = 0; j <= titre.length(); j++) {
            matrice[0][j] = j;
        }

        // Remplissage de la matrice avec l'algorithme de Wagner–Fischer.
        for (int i = 1; i <= docTitre.length(); i++) {
            for (int j = 1; j <= titre.length(); j++) {
                int cout = 0;
                if (docTitre.charAt(i - 1) != titre.charAt(j - 1)) {
                    cout = 1;
                }
                matrice[i][j] = Math.min(matrice[i - 1][j] + 1,
                        Math.min(matrice[i][j - 1] + 1, matrice[i - 1][j - 1] + cout));
            }
        }

        // On retourne vrai si la distance de Levenshtein est inférieur ou égale a
        return matrice[docTitre.length()][titre.length()] <= distance;
    }

}
