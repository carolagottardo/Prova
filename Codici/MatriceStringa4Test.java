import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MatriceStringa4Test {

    private MatriceStringa4 matrice;
    private final int rows = 5;
    private final int columns = 3;

    @Before
    public void initialize() {
        matrice = new MatriceStringa4(rows, columns, "");
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidConstructor() {
        new MatriceStringa4(0, 0, "");
    }

    @Test
    public void testValidSet() {
        matrice.set(1, 1, "test");
        assertEquals("test", matrice.rigaToString(1, ","));
    }

    @Test(expected = MatriceException4.class)
    public void testSetOutOfBounds() {
        matrice.set(rows, columns, "outOfBounds");
    }

    @Test
    public void testRigaToStringValid() {
        matrice.set(0, 0, "first");
        matrice.set(0, 1, "second");
        assertEquals("first,second", matrice.rigaToString(0, ","));
    }

    @Test(expected = MatriceException4.class)
    public void testRigaToStringInvalidRow() {
        matrice.rigaToString(-1, ",");
    }

    @Test(expected = MatriceException4.class)
    public void testRigaToStringNullSeparator() {
        matrice.rigaToString(0, null);
    }

    @Test
    public void testEmptyMatrix() {
        assertEquals("", matrice.rigaToString(0, ","));
    }

    @Test
    public void testFullyPopulatedMatrix() {
        // Populate the matrix with a loop and then test each row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrice.set(i, j, "val" + i + j);
            }
            assertEquals("val" + i + "0,val" + i + "1,val" + i + "2", matrice.rigaToString(i, ","));
        }
    }

    @Test
    public void testSingleCellMatrix() {
        MatriceStringa4 singleCellMatrix = new MatriceStringa4(1, 1, "single");
        assertEquals("single", singleCellMatrix.rigaToString(0, ","));
    }
}
