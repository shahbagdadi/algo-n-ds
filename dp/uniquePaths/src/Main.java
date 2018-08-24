public class Main {
    int cnt = 0;

    public int Paths(int[][] a) {
        return Paths(a, 0, 0);
    }

    int Paths(int[][] a, int i, int j) {
        if ((i == a.length - 1) && (j == a[0].length - 1))
            return cnt++;
        else if ((i == a.length) || (j == a[0].length) || (a[i][j] == 1))
            return 0;
        else {
            Paths(a, i, j + 1);
            Paths(a, i + 1, j);
        }
        return cnt;
    }

    public int Paths2D(int[][] a) {
        if (a[0][0] == 1) return 0;
        int[][] dp = new int[a.length][a[0].length];
        dp[0][0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (a[i][j] == 1) dp[i][j] = 0;
                else if (i == 0 && j >0 )
                    dp[i][j] = dp[i][j - 1];
                else if (j == 0 && i > 0)
                    dp[i][j] = dp[i - 1][j];
                else if ( i > 0 && j > 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[a.length - 1][a[0].length - 1];
    }

    public int Paths1D(int[][] a) {
        if (a[0][0] == 1) return 0;
        int[]dp = new int[a[0].length];
        dp[0] = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) dp[j] = 0;
                else if (j > 0) dp[j] += dp[j-1];
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
