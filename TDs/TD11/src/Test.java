import java.util.Arrays;

public class Test {
    public static void testContent() throws InvalidContentException {
        Integer[][] tab = {
                { 0, 2, 0, 0, 0 },
                { 6, 0, 0, 0, 0 },
                { 0, 0, 0, 12, 0 },
                { 0, 0, 0, 0, 3 }
        };
        FunctionalMatrix<Integer> matrix = new FunctionalMatrix<>(tab);

        Integer[] expected = { 6, 2, 0, 12, 3 };
        Number[] actual = matrix.content();

        // Vérifie que les tableaux expected et actual sont égaux.

        for (int i = 0; i < expected.length; i++) {
            System.out.println("expected[" + i + "] = " + expected[i] + ", actual[" + i + "] = " + actual[i]);
        }
    }

    public static void main(String[] args) {
        try {

            testContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
