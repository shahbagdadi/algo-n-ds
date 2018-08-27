public class Main {

    public int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (s1.charAt(m-1) == s2.charAt(n-1))
            return 1 + lcs(s1, s2, m - 1, n - 1);
        return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
    }

    public int lcsDP(String s1, String s2, int m, int n)
    {
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }

        // Return the string
        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;
        while (i >0 && j >0)
        {
            if (dp[i][j] == dp[i-1][j]) i--;
            else if (dp[i][j] == dp[i][j-1]) j--;
            else
            {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
        }
        System.out.println(sb.reverse());
        return dp[m][n];
    }

    public static void main(String[] args) {
        Main m = new Main();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int cnt = m.lcs(s1, s2, s1.length(), s2.length());
        System.out.println(cnt);
        cnt = m.lcsDP(s1, s2, s1.length(), s2.length());
        System.out.println(cnt);
    }
}
