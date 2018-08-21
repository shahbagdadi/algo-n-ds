public class Main {

    public int minDistanceR(String s1, String s2) {
        return helper(s1, s2, s1.length(), s2.length());
    }

    private int helper(String s1, String s2, int m, int n) {
        if (m == 0) return n;
        else if (n == 0) return m;
        else if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return helper(s1, s2, m - 1, n - 1);
        else
            return 1 + min(helper(s1, s2, m, n - 1),        // insert
                    helper(s1, s2, m - 1, n),              // delete
                    helper(s1, s2, m - 1, n - 1));      // replace
    }


    public int minDistance(String s1, String s2) {
        int m = s1.length() + 1;
        int n = s2.length() + 1;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }
        return dp[m - 1][n - 1];
    }

    private static int min(int a, int b, int c) {
        if (a < b)
            return (a < c) ? a : c;
        else
            return (b < c) ? b : c;
    }

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        Main m = new Main();
        int cnt = m.minDistanceR(s1, s2);
        System.out.println(cnt);
        int cnt2 = m.minDistance(s1, s2);
        System.out.println(cnt2);
    }
}
