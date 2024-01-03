import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDifferenza4Test {

    // Tests how the method handles when there are no common elements between the two arrays.
    @Test
    public void testBasicNoCommonElements() {
        assertArrayEquals(new int[]{1, 2, 3}, ArrayDifferenza4.diff(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
    }

    // Tests how the method handles when all the elements are common between the two arrays.
    @Test
    public void testBasicAllCommonElements() {
        assertArrayEquals(new int[]{}, ArrayDifferenza4.diff(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }
    
    // Tests how the method handles when only certain elements are common between the two arrays.
    @Test
    public void testBasicSomeCommonElements() {
        assertArrayEquals(new int[]{1, 2}, ArrayDifferenza4.diff(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6}));
    }

    // Edge case; tests how the method handles when one array is empty and the other one is not. 
    @Test
    public void testEmptyFirstArray() {
        assertArrayEquals(new int[]{}, ArrayDifferenza4.diff(new int[]{}, new int[]{1, 2, 3}));
    }

    // Edge case; tests how the method handles when both arrays are empty.
    @Test
    public void testBothEmptyArrays() {
        assertArrayEquals(new int[]{}, ArrayDifferenza4.diff(new int[]{}, new int[]{}));
    }

    // Edge case; tests how the method handles when both arrays contain only one element.
    @Test
    public void testSingleElementArrays() {
        assertArrayEquals(new int[]{1}, ArrayDifferenza4.diff(new int[]{1}, new int[]{2}));
    }

    // Tests how the method handles when both arrays contain negative numbers. 
    @Test
    public void testNegativeNumbers() {
        assertArrayEquals(new int[]{-1}, ArrayDifferenza4.diff(new int[]{-1, -2, -3}, new int[]{-2, -3, -4}));
    }

    // Tests how the method handles when both arrays contain duplicates.
    @Test
    public void testArraysWithDuplicates() {
        assertArrayEquals(new int[]{1}, ArrayDifferenza4.diff(new int[]{1, 1, 2, 2}, new int[]{2, 3, 4}));
    }

    // Tests how the method handles scaling with input size. 
    @Test
    public void testLargerArrays() {
        assertArrayEquals(new int[]{10, 20}, ArrayDifferenza4.diff(new int[]{10, 20, 30, 40}, new int[]{30, 40, 50, 60}));
    }

    // Tests how the method handles when all elements of one array are contained within the other array.
    @Test
    public void testAllElementsOfAInB() {
        assertArrayEquals(new int[]{}, ArrayDifferenza4.diff(new int[]{1, 2, 3}, new int[]{0, 1, 2, 3, 4}));
    }

    // This test might be resource-intensive and take a long time to complete.
    // Tests how the method handles very large arrays.
    @Test(timeout = 1000) // timeout in milliseconds
    public void testPerformanceWithLargeArrays() {
        int[] largeA = new int[5000];
        int[] largeB = new int[10000];
        for (int i = 0; i < 5000; i++) {
            largeA[i] = i + 1;
            largeB[i] = i + 5001;
            if(i >= 5000) {
                largeB[i] = i + 1;
            }
        }
        assertArrayEquals(largeA, ArrayDifferenza4.diff(largeA, largeB));
    }
}