import org.junit.Test;
import static org.junit.Assert.*;

public class MatriceStringaBTest {

    @Test
    public void testConstructorNormal() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        assertNotNull(m);
        // Further assertions to check the matrix is initialized as expected
    }

    @Test(expected = RuntimeException.class)
    public void testConstructorRowZero() {
        new MatriceStringaB(0, 3, "-");
    }

    @Test(expected = RuntimeException.class)
    public void testConstructorColumnZero() {
        new MatriceStringaB(3, 0, "-");
    }

    @Test(expected = RuntimeException.class)
    public void testConstructorNegativeRow() {
        new MatriceStringaB(-1, 3, "-");
    }

    @Test(expected = RuntimeException.class)
    public void testConstructorNegativeColumn() {
        new MatriceStringaB(3, -1, "-");
    }

    @Test
    public void testSetNormal() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        m.set(1, 1, "newVal");
        assertEquals("newVal", m.m[1][1]);
    }

    @Test(expected = MatriceExceptionB.class)
    public void testSetRowBelowRange() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        m.set(-1, 1, "value");
    }

    @Test(expected = MatriceExceptionB.class)
    public void testSetRowAboveRange() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        m.set(3, 1, "value");
    }

    @Test(expected = MatriceExceptionB.class)
    public void testSetColumnBelowRange() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        m.set(1, -1, "value");
    }

    @Test(expected = MatriceExceptionB.class)
    public void testSetColumnAboveRange() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        m.set(1, 3, "value");
    }

    @Test
    public void testRigaToStringNormal() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        String result = m.rigaToString(1, ", ");
        assertEquals("-, -, -", result);
    }

    @Test(expected = MatriceExceptionB.class)
    public void testRigaToStringRowBelowRange() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        m.rigaToString(-1, ", ");
    }

    @Test(expected = MatriceExceptionB.class)
    public void testRigaToStringRowAboveRange() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        m.rigaToString(3, ", ");
    }

    @Test(expected = MatriceExceptionB.class)
    public void testRigaToStringNullSeparator() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        m.rigaToString(1, null);
    }

    @Test
    public void testRigaToStringEmptySeparator() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        String result = m.rigaToString(1, "");
        assertEquals("---", result);
    }

    @Test
    public void testRigaToStringSpecialCharacterSeparator() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        String result = m.rigaToString(1, "\n");
        assertEquals("-\n-\n-", result);
    }

    @Test
    public void testRigaToStringFirstRow() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        m.set(0, 0, "first");
        String result = m.rigaToString(0, ", ");
        assertEquals("first, -, -", result);
    }

    @Test
    public void testRigaToStringLastRow() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        m.set(2, 2, "last");
        String result = m.rigaToString(2, ", ");
        assertEquals("-, -, last", result);
    }

    @Test(timeout = 1000) // Timeout in milliseconds to ensure performance is reasonable
    public void testLargeDimensions() {
        int largeSize = 10000; // Define a large size that is appropriate for your test environment
        MatriceStringaB m = new MatriceStringaB(largeSize, largeSize, "-");
        m.set(largeSize-1, largeSize-1, "end"); // Set one value to ensure no out-of-bounds errors
        assertEquals("end", m.m[largeSize-1][largeSize-1]);
    }

    // Edge Cases: Testing the edge of the valid input domain
    @Test
    public void testEdgeCaseRow() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        m.set(2, 0, "edge");
        assertEquals("edge", m.m[2][0]);
    }

    @Test
    public void testEdgeCaseColumn() {
        MatriceStringaB m = new MatriceStringaB(3, 3, "-");
        m.set(0, 2, "edge");
        assertEquals("edge", m.m[0][2]);
    }
}
