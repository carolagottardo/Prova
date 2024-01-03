import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDifferenza3Test {

    // Edge case; tests how the method handles when both input arrays are empty. 
    @Test
    public void testBothArraysEmpty() {
        assertArrayEquals(new int[]{}, ArrayDifferenza3.diff(new int[]{}, new int[]{}));
    }

    // Edge case; tests how the method handles when the first input array is empty.
    @Test
    public void testArrayAEmpty() {
        assertArrayEquals(new int[]{}, ArrayDifferenza3.diff(new int[]{}, new int[]{1, 2, 3}));
    }

    // Edge case; tests how the method handles when the second input array is empty.
    @Test
    public void testArrayBEmpty() {
        assertArrayEquals(new int[]{1, 2, 3}, ArrayDifferenza3.diff(new int[]{1, 2, 3}, new int[]{}));
    }

    // Tests how the method handles the scenario where there's no elements in common between the two arrays, which is a boundary condition.
    @Test
    public void testNoCommonElements() {
        assertArrayEquals(new int[]{1, 2, 3}, ArrayDifferenza3.diff(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
    }

    // Tests how the method handles the scenario where all elements are common between the two arrays, which is a boundary condition.
    @Test
    public void testAllCommonElements() {
        assertArrayEquals(new int[]{}, ArrayDifferenza3.diff(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

    // Tests how the method handles the scenario where only certain elements are common between the two arrays, which is a boundary condition.
    @Test
    public void testSomeCommonElements() {
        assertArrayEquals(new int[]{1, 2}, ArrayDifferenza3.diff(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6}));
    }

    // Edge case; tests how the method handles duplicate elements in the first array. 
    @Test
    public void testDuplicatesInArrayA() {
        assertArrayEquals(new int[]{1}, ArrayDifferenza3.diff(new int[]{1, 2, 2, 3}, new int[]{3, 4, 5}));
    }

    // Edge case; tests how the method handles duplicate elements in the second array. 
    @Test
    public void testDuplicatesInArrayB() {
        assertArrayEquals(new int[]{1, 2}, ArrayDifferenza3.diff(new int[]{1, 2, 3}, new int[]{3, 3, 4, 5}));
    }

    // Edge case; tests how the method handles negative numbers. 
    @Test
    public void testNegativeNumbers() {
        assertArrayEquals(new int[]{-2}, ArrayDifferenza3.diff(new int[]{-1, -2, 3}, new int[]{3, 4, -1}));
    }

    // Tests how the method handles arrays with large numbers. 
    @Test
    public void testLargeNumbers() {
        assertArrayEquals(new int[]{1000}, ArrayDifferenza3.diff(new int[]{1000, 2000, 3000}, new int[]{2000, 3000, 4000}));
    }

    // Tests how the method handles zeroes (which iare often a special case in many algorithms and calculations).
    @Test
    public void testZerosInArrays() {
        assertArrayEquals(new int[]{1, 2}, ArrayDifferenza3.diff(new int[]{0, 1, 2}, new int[]{0, 3, 4}));
    }

    // Tests how the method handles when the first array (Array A) is larger than the second array (Array B).
    @Test
    public void testArrayALargerThanArrayB() {
        assertArrayEquals(new int[]{1, 2, 3}, ArrayDifferenza3.diff(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5}));
    }

    // Tests how the method handles when the second array (Array B) is larger than the first array (Array A).
    @Test
    public void testArrayBLargerThanArrayA() {
        assertArrayEquals(new int[]{}, ArrayDifferenza3.diff(new int[]{1, 2}, new int[]{1, 2, 3, 4, 5}));
    }

    // Tests how the method handles non-sequential, spaced-out numbers inputs inside the arrays. 
    @Test
    public void testArraysWithNonSequentialNumbers() {
        assertArrayEquals(new int[]{10, 30}, ArrayDifferenza3.diff(new int[]{10, 20, 30}, new int[]{20, 40, 60}));
    }

    // Note: The following test case is commented out because it's invalid in Java as Java arrays can't hold different types.
    @Test
    public void testSpecialCharactersAndLetters() {
        assertArrayEquals(new int[]{}, ArrayDifferenza3.diff(new int[]{1, 'a', '!'}, new int[]{2, 3}));
    }
}