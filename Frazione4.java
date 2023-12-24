
public class Frazione4 {
    private int numeratore;
    private int denominatore;

    public Frazione4(int numeratore, int denominatore) {
        this.numeratore = numeratore;
        this.denominatore = denominatore;
    }

    public boolean isMinore(Frazione4 altro) {
        return this.numeratore * altro.denominatore < altro.numeratore * this.denominatore;
    }

    public boolean isMaggiore(Frazione4 altro) {
        return this.numeratore * altro.denominatore > altro.numeratore * this.denominatore;
    }

    public int getNumeratore() {
        return numeratore;
    }

    public int getDenominatore() {
        return denominatore;
    }

    @Override
    public String toString() {
        return numeratore + "/" + denominatore;
    }
}

