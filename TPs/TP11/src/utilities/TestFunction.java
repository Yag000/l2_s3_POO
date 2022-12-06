package utilities;

/**
 * Classe abstraite pour simplifier les test des fonctions.
 */
public abstract class TestFunction {

    /**
     * Fonction a tester.
     */
    public abstract void function();

    /**
     * Lance le test.
     * 
     * @param testName Nom du test
     */
    public void runTest(String testName) {
        System.out.println();
        System.out.println("-----------\\ Test " + testName + " /-----------");
        System.out.println();
        function();
        System.out.println();
        System.out.println("-------------------------------" + "-".repeat(testName.length()));
    }
}