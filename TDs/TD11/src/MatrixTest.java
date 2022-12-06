import org.junit.jupiter.api.Test;

public class MatrixTest {

    @Test
    public void testMatrix() {
        Integer[][] array = { { 1, 2, 3 }, { 4, 5, 6 } };
        Matrix<Integer> matrix = new Matrix<>(array);

        // Vérifier que nbRows et nbColumns retournent les valeurs correctes
        assertEquals(matrix.nbRows(), 2);
        assertEquals(matrix.nbColumns(), 3);

        // Vérifier que rowScanner retourne un MatrixScanner avec les valeurs correctes
        AccFunction<Integer, Integer> sumAcc = (acc, x) -> acc + x;
        MatrixScanner<Integer> rowScanner = matrix.rowScanner(0, sumAcc, 0);
        assertEquals(rowScanner.acc, 0);
        assertEquals(rowScanner.x, 0);
        assertEquals(rowScanner.y, 0);
        assertEquals(rowScanner.stepX, 1);
        assertEquals(rowScanner.stepY, 0);
        assertEquals(rowScanner.accFunction, sumAcc);

        // Vérifier que colScanner retourne un MatrixScanner avec les valeurs correctes
        MatrixScanner<Integer> colScanner = matrix.colScanner(0, sumAcc, 0);
        assertEquals(colScanner.acc, 0);
        assertEquals(colScanner.x, 0);
        assertEquals(colScanner.y, 0);
        assertEquals(colScanner.stepX, 0);
        assertEquals(colScanner.stepY, 1);
        assertEquals(colScanner.accFunction, sumAcc);

        // Vérifier que accumulate et read des objets MatrixScanner fonctionnent
        // correctement
        colScanner.accumulate(0);
        assertEquals(colScanner.read(), 5);
        colScanner.accumulate(0);
        assertEquals(colScanner.read(), 11);

        // Vérifier que isOver des objets MatrixScanner retourne la valeur correcte
        assertFalse(colScanner.isOver());
        colScanner.accumulate(0);
        assertTrue(colScanner.isOver());
    }
}