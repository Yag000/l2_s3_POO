package utilities;

/**
 * Interface pour simplifier les test des fonctions.
 */
public interface TestFunction {

    /**
     * Fonction a tester.
     */
    public abstract void function();

    /**
     * Lance le test.
     * 
     * @param testName Nom du test
     */
    default void runTest(String testName) {
        System.out.println();
        System.out.println("-----------\\ Test " + testName + " /-----------");
        System.out.println();

        function();

        System.out.println();
        System.out.println("-------------------------------" + "-".repeat(testName.length()));
    }
}