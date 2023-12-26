import java.util.Arrays;
import static java.util.Arrays.copyOf;

public class ArrayDifferenzaB {
    public static int[] diff(int[] a, int[] b) {
        // Controllo degli argomenti
        if (a == null || b == null) {
            throw new IllegalArgumentException("Gli argomenti non devono essere null");
        }

        // Inizializzo una nuova matrice per contenere i risultati
        int[] result = new int[a.length];
        int count = 0;

        // Ciclo su tutti gli elementi dell'array a
        for (int i = 0; i < a.length; i++) {
            // Controllo se l'elemento è presente nell'array b
            boolean found = false;
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    found = true;
                    break;
                }
            }

            // Se l'elemento non è presente, lo aggiungo ai risultati
            if (!found) {
                result[count++] = a[i];
            }
        }

        // Ritorno i risultati
        return Arrays.copyOf(result, count);
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 3, 5, 7, 9 }; // A
        int[] b = new int[] { 1, 5, 7 }; // B

        // Calcolare la differenza tra gli array A e B e memorizzare il risultato in
        // result
        int[] result = diff(a, b);

        // Stampare il risultato
        System.out.println(Arrays.toString(result));
    }
}