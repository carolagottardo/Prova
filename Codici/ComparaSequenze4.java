import java.util.ArrayList;
import java.util.Scanner;

public class ComparaSequenze4 {
    public static void main(String[] args) {
        ArrayList<Double> sequenzaA = acquisisciSequenzaReali();
        ArrayList<Frazione4> sequenzaB = acquisisciSequenzaFrazioni();

        if (sequenzaA.isEmpty() || sequenzaB.isEmpty()) {
            System.out.println("Errore: una delle sequenze è vuota.");
            return;
        }

        double mediaNumeriReali = sequenzaA.stream().mapToDouble(Double::doubleValue).average().orElse(0) / 2;

        System.out.println("Frazioni maggiori della metà del valore medio dei numeri reali:");
        for (Frazione4 frazione : sequenzaB) {
            if (frazione.isMaggiore(new Frazione4((int) (mediaNumeriReali * 2), 1))) {
                System.out.println(frazione);
            }
        }
    }

    private static ArrayList<Double> acquisisciSequenzaReali() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> sequenza = new ArrayList<>();
        System.out.println("Inserisci i numeri reali (0 per terminare):");
        while (true) {
            double numero = scanner.nextDouble();
            if (numero == 0) {
                break;
            }
            sequenza.add(numero);
        }
        return sequenza;
    }

    private static ArrayList<Frazione4> acquisisciSequenzaFrazioni() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Frazione4> sequenza = new ArrayList<>();
        System.out.println("Inserisci le frazioni (formato 'numeratore/denominatore', inserisci un numeratore negativo per terminare):");
        while (true) {
            String input = scanner.nextLine();
            String[] parti = input.split("/");
            int numeratore = Integer.parseInt(parti[0]);
            if (numeratore < 0) {
                break;
            }
            int denominatore = Integer.parseInt(parti[1]);
            sequenza.add(new Frazione4(numeratore, denominatore));
        }
        return sequenza;
    }
}
