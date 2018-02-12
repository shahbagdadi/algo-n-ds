public class Range2DSumImmutable {
    int[][] sm;

    public Range2DSumImmutable(int[][] m) {
        this.sm = new int[m.length + 1][m[0].length + 1];
        for (int i = 1; i < sm.length; i++)
            for (int j = 1; j < sm[0].length; j++) {
                sm[i][j] = m[i - 1][j - 1] + sm[i - 1][j] + sm[i][j - 1] - sm[i - 1][j - 1];
            }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        Range2DSumImmutable sum = new Range2DSumImmutable(matrix);
        //sum.printMatrix();
        System.out.println(sum.sumRegion(2, 1, 4, 3));
        System.out.println(sum.sumRegion(1, 1, 2, 2));
        System.out.println(sum.sumRegion(1, 2, 2, 4));
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        return sm[r2 + 1][c2 + 1] - sm[r1][c2 + 1] - sm[r2 + 1][c1] + sm[r1][c1];
    }

    public void printMatrix() {
        for (int i = 0; i < sm.length; i++) {
            for (int j = 0; j < sm[0].length; j++)
                System.out.print(sm[i][j] + " ,");
            System.out.println();
        }
    }
}
