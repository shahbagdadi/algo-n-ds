public class Main {

    public void rotate(int[][] m) {
        int r = m.length - 1;
        int c = m[0].length - 1;
        // swap diagonally
        for (int i = 0; i <= r; i++) {
            for (int j = i; j <= c; j++) {
                System.out.println("replacing " + m[i][j] + " with " + m[j][i]);
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }
        System.out.println("-----");
        //swap vertically from center
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c/2; j++) {
                System.out.println("replacing " + m[i][j] + " with " + m[i][c-j]);
                int t = m[i][j];
                m[i][j] = m[i][c-j];
                m[i][c-j] = t;
            }
        }
        System.out.println("-------");

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(" " + m[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Main m = new Main();
        m.rotate(mat);


    }
}
