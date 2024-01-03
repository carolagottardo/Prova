import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MatriceStringa3Test {

    private MatriceStringa3 matrice;

    // This method is executed before each test. It's a good place to initialize
    // common objects.
    @Before
    public void setUp() {
        // Initialize with some common values if needed.
    }

    // 1. Constructor Tests
    @Test
    public void testValidConstructor() {
        matrice = new MatriceStringa3(3, 3, "valid");
        assertNotNull(matrice);
    }

    @Test(expected = RuntimeException.class)
    public void testZeroRows() {
        new MatriceStringa3(0, 3, "invalid");
    }

    @Test(expected = RuntimeException.class)
    public void testZeroColumns() {
        new MatriceStringa3(3, 0, "invalid");
    }

    // 2. Set Method Tests
    @Test
    public void testSetValid() {
        matrice = new MatriceStringa3(3, 3, "init");
        matrice.set(0, 0, "valid");
        assertEquals("valid", matrice.rigaToString(0, ","));
    }

    @Test(expected = MatriceStringa3.MatriceException.class)
    public void testSetNegativeRowIndex() {
        matrice = new MatriceStringa3(3, 3, "init");
        matrice.set(-1, 1, "invalid");
    }

    // 3. rigaToString Method Tests
    @Test
    public void testRigaToStringValid() {
        matrice = new MatriceStringa3(3, 3, "test");
        assertEquals("test,test,test", matrice.rigaToString(0, ","));
    }

    @Test(expected = MatriceStringa3.MatriceException.class)
    public void testRigaToStringInvalidIndex() {
        matrice = new MatriceStringa3(3, 3, "test");
        matrice.rigaToString(-1, ",");
    }

    // 4. Exception Handling Tests
    @Test
    public void testMatriceExceptionMessage() {
        try {
            matrice = new MatriceStringa3(3, 3, "test");
            matrice.set(-1, 1, "invalid");
            fail("MatriceException should have been thrown");
        } catch (MatriceStringa3.MatriceException e) {
            assertEquals("Indici non validi o separatore nullo", e.getMessage());
        }
    }

    // 5. Edge and Special Cases
    @Test
    public void testOneByOneMatrix() {
        matrice = new MatriceStringa3(1, 1, "single");
        assertEquals("single", matrice.rigaToString(0, ","));
    }

    // 6. Integration Tests
    @Test
    public void testSetAndGetSequence() {
        matrice = new MatriceStringa3(3, 3, "init");
        matrice.set(0, 0, "first");
        matrice.set(0, 1, "second");
        assertEquals("first,second,init", matrice.rigaToString(0, ","));
    }

    // 1. Constructor Tests (continued)
    @Test(expected = RuntimeException.class)
    public void testNegativeRows() {
        new MatriceStringa3(-1, 3, "invalid");
    }

    @Test(expected = RuntimeException.class)
    public void testNegativeColumns() {
        new MatriceStringa3(3, -1, "invalid");
    }

    // 2. Set Method Tests (continued)
    @Test(expected = MatriceStringa3.MatriceException.class)
    public void testSetNegativeColumnIndex() {
        matrice = new MatriceStringa3(3, 3, "init");
        matrice.set(1, -1, "invalid");
    }

    @Test(expected = MatriceStringa3.MatriceException.class)
    public void testSetRowIndexTooHigh() {
        matrice = new MatriceStringa3(3, 3, "init");
        matrice.set(3, 1, "invalid");
    }

    @Test(expected = MatriceStringa3.MatriceException.class)
    public void testSetColumnIndexTooHigh() {
        matrice = new MatriceStringa3(3, 3, "init");
        matrice.set(1, 3, "invalid");
    }

    // 3. rigaToString Method Tests (continued)
    @Test(expected = MatriceStringa3.MatriceException.class)
    public void testRigaToStringTooHighIndex() {
        matrice = new MatriceStringa3(3, 3, "test");
        matrice.rigaToString(3, ",");
    }

    @Test(expected = MatriceStringa3.MatriceException.class)
    public void testRigaToStringNullSeparator() {
        matrice = new MatriceStringa3(3, 3, "test");
        matrice.rigaToString(1, null);
    }

    // 5. Edge and Special Cases (continued)
    @Test
    public void testSetLongString() {
        matrice = new MatriceStringa3(1, 1, "init");
        String longString = "ThisIsAVeryLongStringToTest";
        matrice.set(0, 0, longString);
        assertEquals(longString, matrice.rigaToString(0, ","));
    }

    @Test
    public void testRigaToStringLongSeparator() {
        matrice = new MatriceStringa3(1, 3, "test");
        String longSeparator = "LONGSEPARATOR";
        assertEquals("test" + longSeparator + "test" + longSeparator + "test", matrice.rigaToString(0, longSeparator));
    }

    // 6. Integration Tests (continued)
    @Test
    public void testMultipleSetAndGetSequence() {
        matrice = new MatriceStringa3(3, 3, "init");
        matrice.set(1, 0, "one");
        matrice.set(1, 1, "two");
        matrice.set(1, 2, "three");
        assertEquals("one,two,three", matrice.rigaToString(1, ","));
    }

    // Test Entire Matrix Printout
    @Test
    public void testEntireMatrixPrintout() {
        matrice = new MatriceStringa3(2, 2, "init");
        matrice.set(0, 0, "top-left");
        matrice.set(0, 1, "top-right");
        matrice.set(1, 0, "bottom-left");
        matrice.set(1, 1, "bottom-right");
        String expectedFirstRow = "top-left,top-right";
        String expectedSecondRow = "bottom-left,bottom-right";
        assertEquals(expectedFirstRow, matrice.rigaToString(0, ","));
        assertEquals(expectedSecondRow, matrice.rigaToString(1, ","));
    }
}
