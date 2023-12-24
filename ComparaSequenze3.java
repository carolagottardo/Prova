import java.util.ArrayList;
import java.util.Scanner;

public class ComparaSequenze3 {
    public static void main(String[] args) {
        // Acquisizione della sequenza A
        ArrayList<Double> sequenzaA = acquisisciSequenzaReali();
        if (sequenzaA.isEmpty()) {
            System.out.println("Sequenza A vuota. Interruzione dell'esecuzione.");
            return;
        }

        // Acquisizione della sequenza B
        ArrayList<Frazione3> sequenzaB = acquisisciSequenzaFrazioni();
        if (sequenzaB.isEmpty()) {
            System.out.println("Sequenza B vuota. Interruzione dell'esecuzione.");
            return;
        }

        // Stampa delle frazioni in B che sono maggiori di almeno la metà dei numeri reali in A
        stampaFrazioniMaggiori(sequenzaA, sequenzaB);
    }

    private static ArrayList<Double> acquisisciSequenzaReali() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> sequenzaA = new ArrayList<>();
        System.out.println("Inserisci la sequenza A di numeri reali (termina con 0):");
        double numero;
        do {
            numero = scanner.nextDouble();
            if (numero != 0) {
                sequenzaA.add(numero);
            }
        } while (numero != 0);
        return sequenzaA;
    }

    private static ArrayList<Frazione3> acquisisciSequenzaFrazioni() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Frazione3> sequenzaB = new ArrayList<>();
        System.out.println("Inserisci la sequenza B di frazioni (termina con una frazione minore di 0):");
        Frazione3 frazione;
    
        while (true) {
            frazione = acquisisciFrazione(scanner);
    
            if (frazione.isMaggiore(new Frazione3(0, 1))) {
                sequenzaB.add(frazione);
            } else {
                // Esci dal ciclo solo se la frazione è minore di zero
                break;
            }
        }
    
        return sequenzaB;
    }    

    private static Frazione3 acquisisciFrazione(Scanner scanner) {
        System.out.print("Inserisci il numeratore della frazione: ");
        int numeratore = scanner.nextInt();
        System.out.print("Inserisci il denominatore della frazione: ");
        int denominatore = scanner.nextInt();
        return new Frazione3(numeratore, denominatore);
    }

    private static void stampaFrazioniMaggiori(ArrayList<Double> sequenzaA, ArrayList<Frazione3> sequenzaB) {
        System.out.println("Frazioni in B maggiori di almeno la metà dei numeri reali in A:");
        for (Frazione3 frazione : sequenzaB) {
            double metaMinore = calcolaMetaMinore(sequenzaA);
            if (frazione.isMaggiore(new Frazione3((int) metaMinore, 1))) {
                System.out.println(frazione.getNumeratore() + "/" + frazione.getDenominatore());
            }
        }
    }

    private static double calcolaMetaMinore(ArrayList<Double> sequenzaA) {
        double somma = 0;
        for (double numero : sequenzaA) {
            somma += numero;
        }
        return somma / 2;
    }
}
