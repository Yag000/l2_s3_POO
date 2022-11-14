import java.io.FileNotFoundException;

public abstract class TestFunction {

    public abstract void function(Arbre a);

    private void test(String path) {
        Arbre test1;

        try {
            test1 = new Arbre(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Le fichier n'existe pas");
            return;
        }

        function(test1);
    }

    public void runTest(String testName, String path) {
        System.out.println();
        System.out.println("-----------\\ Test " + testName + " /-----------");
        System.out.println();
        test(path);
        System.out.println();
        System.out.println("-------------------------------" + "-".repeat(testName.length()));
    }

}