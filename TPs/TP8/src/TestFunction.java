import java.io.FileNotFoundException;

/**
 * Classe abstraite pour simplifier les test des fonctions.
 */
public abstract class TestFunction {

    /**
     * Fonction a tester.
     * 
     * @param a Arbre sur lequel les test sont faits
     */
    public abstract void function(Arbre a);

    /**
     * Creation d'un arbre pour le test à partir d'un path et application de la
     * fonction a cette arbre.
     * 
     * @param path Chemin vers la racine de l'arborescence
     */
    private void test(String path) {
        Arbre test1;

        try {
            test1 = new Arbre(path);
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas");
            e.printStackTrace();
            return;
        }

        function(test1);
    }

    /**
     * Affichage et lancement du test.
     * 
     * @param testName Nom du test
     * @param path     Chemin ver la racine de l'arborescence sur laquelle le teste
     *                 va se faire
     */
    public void runTest(String testName, String path) {
        System.out.println();
        System.out.println("-----------\\ Test " + testName + " /-----------");
        System.out.println();
        test(path);
        System.out.println();
        System.out.println("-------------------------------" + "-".repeat(testName.length()));
    }

}