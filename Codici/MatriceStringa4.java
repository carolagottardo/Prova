public class MatriceStringa4 {
    private String[][] m;

    // Costruttore
    public MatriceStringa4(int r, int c, String val) {
        if (r <= 0 || c <= 0) {
            throw new RuntimeException("Dimensioni non ammissibili.");
        }
        m = new String[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = val;
            }
        }
    }

    // Metodo set
    public void set(int r, int c, String val) {
        if (r < 0 || r >= m.length || c < 0 || c >= m[0].length) {
            throw new MatriceException4("Indici fuori dai limiti.");
        }
        m[r][c] = val;
    }

    // Metodo rigaToString
    public String rigaToString(int idx, String separatore) {
        if (idx < 0 || idx >= m.length || separatore == null) {
            throw new MatriceException4("Parametri non validi.");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m[idx].length; i++) {
            sb.append(m[idx][i]);
            if (i < m[idx].length - 1) {
                sb.append(separatore);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Dimensioni della matrice
        int righe = 5;
        int colonne = 3;

        // Creazione dell'oggetto MatriceString
        MatriceStringa4 matrice = new MatriceStringa4(righe, colonne, "");

        // Popolamento della matrice con i valori forniti
        String[][] valori = {
            {"pippo", "pluto", "qui"},
            {"qui", "qua", "pippo"},
            {"qui", "quo", "pippo"},
            {"pluto", "pippo", "pluto"},
            {"pippo", "pippo", "pluto"}
        };

        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                matrice.set(i, j, valori[i][j]);
            }
        }

        // Stampa delle righe della matrice utilizzando rigaToString
        for (int i = 0; i < righe; i++) {
            try {
                System.out.println("Riga " + i + ": " + matrice.rigaToString(i, "."));
            } catch (MatriceException4 e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
    }
}
