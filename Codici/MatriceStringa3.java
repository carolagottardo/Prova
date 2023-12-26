public class MatriceStringa3 {
    private String[][] m;

    // Costruttore
    public MatriceStringa3(int r, int c, String val) {
        if (r <= 0 || c <= 0) {
            throw new RuntimeException("Valori non ammissibili");
        }

        m = new String[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = val;
            }
        }
    }

    // Metodo set
    public void set(int r, int c, String val) throws MatriceException {
        if (r < 0 || r >= m.length || c < 0 || c >= m[0].length) {
            throw new MatriceException();
        }

        m[r][c] = val;
    }

    // Metodo rigaToString
    public String rigaToString(int idx, String separatore) throws MatriceException {
        if (idx < 0 || idx >= m.length || separatore == null) {
            throw new MatriceException();
        }

        StringBuilder result = new StringBuilder();
        for (int j = 0; j < m[idx].length; j++) {
            result.append(m[idx][j]);
            if (j < m[idx].length - 1) {
                result.append(separatore);
            }
        }
        return result.toString();
    }

    // Eccezione personalizzata
    public class MatriceException extends RuntimeException {
        public MatriceException() {
            super("Indici non validi o separatore nullo");
        }
    }

    public static void main(String[] args) {
        try {
            // Creazione di un'istanza di MatriceString
            MatriceStringa3 matrice = new MatriceStringa3(5, 3, "pippo");

            // Impostazione dei valori della matrice
            matrice.set(0, 0, "pippo");
            matrice.set(0, 1, "pluto");
            matrice.set(0, 2, "qui");

            matrice.set(1, 0, "qui");
            matrice.set(1, 1, "qua");
            matrice.set(1, 2, "pippo");

            matrice.set(2, 0, "qui");
            matrice.set(2, 1, "quo");
            matrice.set(2, 2, "pippo");

            matrice.set(3, 0, "pluto");
            matrice.set(3, 1, "pippo");
            matrice.set(3, 2, "pluto");

            matrice.set(4, 0, "pippo");
            matrice.set(4, 1, "pippo");
            matrice.set(4, 2, "pluto");

            // Invocazione del metodo rigaToString
            System.out.println("Risultato del metodo rigaToString:");
            for (int i = 0; i < 5; i++) {
                System.out.println(matrice.rigaToString(i, "."));
            }
        } catch (MatriceStringa3.MatriceException e) {
            // Gestione delle eccezioni
            System.err.println("Eccezione: " + e.getMessage());
        }
    }
}
