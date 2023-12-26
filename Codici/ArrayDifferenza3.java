import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDifferenza3 {

    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 4, 5};
        int[] arrayB = {3, 4, 5, 6, 7};

        int[] result = diff(arrayA, arrayB);

        System.out.println("ArrayA: " + Arrays.toString(arrayA));
        System.out.println("ArrayB: " + Arrays.toString(arrayB));
        System.out.println("Difference: " + Arrays.toString(result));
    }

    public static int[] diff(int[] a, int[] b) {
        List<Integer> differenceList = new ArrayList<>();

        // Converting arrayB to a List for faster contains check
        List<Integer> listB = new ArrayList<>();
        for (int value : b) {
            listB.add(value);
        }

        // Check each element in arrayA
        for (int value : a) {
            // If the element is not present in arrayB, add it to the result list
            if (!listB.contains(value)) {
                differenceList.add(value);
            }
        }

        // Convert the List to an array
        int[] result = new int[differenceList.size()];
        for (int i = 0; i < differenceList.size(); i++) {
            result[i] = differenceList.get(i);
        }

        return result;
    }
}
