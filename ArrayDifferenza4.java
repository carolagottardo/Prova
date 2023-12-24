import java.util.ArrayList;
import java.util.List;

public class ArrayDifferenza4 {
    public static int[] diff(int[] a, int[] b) {
        List<Integer> diffList = new ArrayList<>();

        for (int valueA : a) {
            boolean found = false;
            for (int valueB : b) {
                if (valueA == valueB) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                diffList.add(valueA);
            }
        }

        // Convertendo l'ArrayList in un array di int
        int[] result = new int[diffList.size()];
        for (int i = 0; i < diffList.size(); i++) {
            result[i] = diffList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 4, 5};
        int[] arrayB = {3, 4, 5, 6, 7};

        int[] result = diff(arrayA, arrayB);

        System.out.println("Elementi di arrayA che non sono in arrayB:");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
