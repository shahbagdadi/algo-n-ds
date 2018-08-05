import java.util.Arrays;

public class Main {

    private static int[][] steps = new int[][]{{-1,1} , {1,-1}};
    private static final int UP = 0, DOWN = 1;

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int dir = UP;
        int[] ans = new int[m * n];
        int r=0, c=0;
        for (int i = 0; i < m * n; i++) {
            ans[i] = matrix[r][c];
            r += steps[dir][0];
            c += steps[dir][1];

            if (r > m-1) {
                dir = UP;
                r = m-1;
                c += 2;
            }
            if ( c > n-1 ) {
                dir = DOWN;
                c = n-1;
                r += 2;
            }
            if (r < 0) {
                dir = DOWN;
                r = 0;
            }
            if (c < 0) {
                dir = UP;
                c = 0;
            }

        }
        return ans;
    }

    public static void main(String[] args) {

        Main m = new Main();
        //int[][] ip = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] ip = new int[][]{{1,2},{4,5},{7,8}};
        int[] ans = m.findDiagonalOrder(ip);
        System.out.println(Arrays.toString(ans));
    }
}
