public class Frazione3 {
    private int numeratore;
    private int denominatore;

    public Frazione3(int numeratore, int denominatore) {
        this.numeratore = numeratore;
        this.denominatore = denominatore;
    }

    public boolean isMaggiore(Frazione3 altra) {
        // Calcola il prodotto incrociato per avere gli stessi denominatori
        int prodottoIncrociato1 = this.numeratore * altra.denominatore;
        int prodottoIncrociato2 = altra.numeratore * this.denominatore;

        // Confronta i numeratori
        return prodottoIncrociato1 > prodottoIncrociato2;
    }

    public boolean isMinore(Frazione3 altra) {
        int prodottoIncrociato1 = this.numeratore * altra.denominatore;
        int prodottoIncrociato2 = altra.numeratore * this.denominatore;

        // Confronta i numeratori
        return prodottoIncrociato1 < prodottoIncrociato2;
    }

    public int getNumeratore() {
        return numeratore;
    }

    public int getDenominatore() {
        return denominatore;
    }
}
