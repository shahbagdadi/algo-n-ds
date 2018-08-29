public class Main {
    int cnt = 0;

    public int Paths(int[][] a) {
        return Paths(a, 0, 0);
    }

    int Paths(int[][] a, int r, int c) {
        if ((r == a.length - 1) && (c == a[0].length - 1)) // reached dest
            return cnt++;
        else if ((r == a.length) || (c == a[0].length) || (a[r][c] == 1)) // reached end or blocked
            return 0;
        else {
            Paths(a, r, c + 1);
            Paths(a, r + 1, c);
        }
        return cnt;
    }

    public int Paths2D(int[][] a) {
        if (a[0][0] == 1) return 0;
        int[][] dp = new int[a.length][a[0].length];
        dp[0][0] = 1;
        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[0].length; c++) {
                if (a[r][c] == 1) dp[r][c] = 0;
                else if (r == 0 && c >0 )
                    dp[r][c] = dp[r][c - 1];
                else if (c == 0 && r > 0)
                    dp[r][c] = dp[r - 1][c];
                else if ( r > 0 && c > 0)
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[a.length - 1][a[0].length - 1];
    }

    public int Paths1D(int[][] a) {
        if (a[0][0] == 1) return 0;
        int[]dp = new int[a[0].length];
        dp[0] = 1;
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                if (a[r][c] == 1) dp[c] = 0;
                else if (c > 0) dp[c] += dp[c-1];
            }
        }
        return dp[a[0].length - 1];
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[][] a = {{0, 0, 0, 0}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        System.out.println(m.Paths(a));
        System.out.println(m.Paths2D(a));
        System.out.println(m.Paths1D(a));
    }
}
