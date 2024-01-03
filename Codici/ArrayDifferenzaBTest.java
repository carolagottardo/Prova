import org.junit.Test;
import static org.junit.Assert.*;
// import java.util.Arrays;

public class ArrayDifferenzaBTest {

    // Not an edge case; this is a typical scenario.
    @Test
    public void testNormalCase() {
        assertArrayEquals(new int[]{3, 9}, ArrayDifferenzaB.diff(new int[]{1, 3, 5, 7, 9}, new int[]{1, 5, 7}));
    }

    // Edge case; tests how the method handles an empty array (a) as input.
    @Test
    public void testEmptyA() {
        assertArrayEquals(new int[]{}, ArrayDifferenzaB.diff(new int[]{}, new int[]{1, 5, 7}));
    }

    // Edge case; tests how the method handles an empty array (b) as input.
    @Test
    public void testEmptyB() {
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, ArrayDifferenzaB.diff(new int[]{1, 3, 5, 7, 9}, new int[]{}));
    }

    // Edge case; tests how the method handles both arrays being empty. 
    @Test
    public void testBothEmpty() {
        assertArrayEquals(new int[]{}, ArrayDifferenzaB.diff(new int[]{}, new int[]{}));
    }
    
    // Edge case; tests behavior when both arrays are the same.
    @Test
    public void testIdenticalArrays() {
        assertArrayEquals(new int[]{}, ArrayDifferenzaB.diff(new int[]{1, 3, 5}, new int[]{1, 3, 5}));
    }

    // Not typically an edge case, it tests complete non-overlap, which is boundary-like.
    @Test
    public void testDistinctArrays() {
        assertArrayEquals(new int[]{1, 3, 5}, ArrayDifferenzaB.diff(new int[]{1, 3, 5}, new int[]{2, 4, 6}));
    }

    // Edge case; tests how the method handles null as input, which is a special condition.
    @Test(expected = IllegalArgumentException.class)
    public void testNullA() {
        ArrayDifferenzaB.diff(null, new int[]{1, 5, 7});
    }

    // Edge case; similar to the above, but for the other array.
    @Test(expected = IllegalArgumentException.class)
    public void testNullB() {
        ArrayDifferenzaB.diff(new int[]{1, 3, 5, 7, 9}, null);
    }

    // Edge case; tests how the method handles both arrays being null. 
    @Test(expected = IllegalArgumentException.class)
    public void testBothNull() {
        ArrayDifferenzaB.diff(null, null);
    }

    // !!! test cases with large arrays, duplicates, etc.

    // Edge case; tests how the method deals with duplicate elements.
    @Test
    public void testDuplicatesInArrays() {
        assertArrayEquals(new int[]{9}, ArrayDifferenzaB.diff(new int[]{1, 3, 3, 7, 9}, new int[]{1, 3, 7, 7}));
    }

    // Not typically an edge case, introduces negative numbers and zero, which might behave differently. 
    @Test
    public void testNegativeNumbersAndZero() {
        assertArrayEquals(new int[]{-3, 2}, ArrayDifferenzaB.diff(new int[]{-3, 0, 2, 4}, new int[]{-1, 0, 3, 4}));
    }

    // Not an edge case, tests how the method handles order sensitivity, if it matters.
    @Test
    public void testOrderSensitivity() {
        assertArrayEquals(new int[]{}, ArrayDifferenzaB.diff(new int[]{1, 3, 5}, new int[]{5, 3, 1}));
    }

    // Edge case; specifically tests how the method handles repetition in the 'a' array.
    @Test
    public void testRepeatedElementsInA() {
        assertArrayEquals(new int[]{1, 3}, ArrayDifferenzaB.diff(new int[]{2, 2, 2}, new int[]{1, 2, 3}));
    }

    // Edge case; specifically tests how the method handles repetition in the 'b' array.
    @Test
    public void testRepeatedElementsInB() {
        assertArrayEquals(new int[]{1, 3}, ArrayDifferenzaB.diff(new int[]{1, 2, 3}, new int[]{2, 2, 2}));
    }
}
