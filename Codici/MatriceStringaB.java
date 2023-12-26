public class MatriceStringaB {
    private String[][] m;

    public MatriceStringaB(int r, int c, String val) {
        if (r < 1 || c < 1) {
            throw new RuntimeException();
        }
    
        m = new String[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = val;
            }
        }
    }    

    public void set(int r, int c, String val) throws MatriceExceptionB {
        if (r < 0 || r >= m.length) {
            throw new MatriceExceptionB();
        }

        if (c < 0 || c >= m[0].length) {
            throw new MatriceExceptionB();
        }

        m[r][c] = val;
    }

    public String rigaToString(int idx, String separatore) throws MatriceExceptionB {
        if (idx < 0 || idx >= m.length) {
            throw new MatriceExceptionB();
        }

        if (separatore == null) {
            throw new MatriceExceptionB();
        }

        StringBuilder sb = new StringBuilder();
        for (String s : m[idx]) {
            sb.append(s);
            sb.append(separatore);
        }

        return sb.substring(0, sb.length() - separatore.length());
    }

    public static void main(String[] args) {
        MatriceStringaB m = new MatriceStringaB(5, 3, "-");

        m.set(0, 0, "pippo");
        m.set(0, 1, "pluto");
        m.set(0, 2, "qui");
        m.set(1, 0, "qui");
        m.set(1, 1, "qua");
        m.set(1, 2, "pippo");
        m.set(2, 0, "qui");
        m.set(2, 1, "quo");
        m.set(2, 2, "pippo");
        m.set(3, 0, "pluto");
        m.set(3, 1, "pippo");
        m.set(3, 2, "pluto");
        m.set(4, 0, "pippo");
        m.set(4, 1, "pippo");
        m.set(4, 2, "pluto");

        System.out.println(m.rigaToString(0, ", ")); // Output: pippo, pluto, qui
        System.out.println(m.rigaToString(1, "-")); // Output: qui-qua-pippo
        System.out.println(m.rigaToString(2, " ")); // Output: qui quo pippo
        System.out.println(m.rigaToString(3, ".")); // Output: pluto.pippo.pluto
        System.out.println(m.rigaToString(4, "!")); // Output: pippo!pippo!pluto
    }
}
