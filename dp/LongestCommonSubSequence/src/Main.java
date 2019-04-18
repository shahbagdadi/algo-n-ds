public class Main {

    // T - O(2^(m+n))  S - O(m+n)
    public int lcs(String sa, String sb, int a, int b) {
        if (a == 0 || b == 0) return 0;
        if (sa.charAt(a-1) == sb.charAt(b-1))
            return 1 + lcs(sa, sb, a - 1, b - 1);
        return Math.max(lcs(sa, sb, a - 1, b), lcs(sa, sb, a, b - 1));
    }

    // T - O(m*n)   S - O(m*n)
    public int lcsDP(String sa, String sb, int a, int b)
    {
        int[][] dp = new int[a+1][b+1];
        for (int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (sa.charAt(i-1) == sb.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }

        // Return the string
        StringBuilder sbd = new StringBuilder();
        int i = a;
        int j = b;
        while (i >0 && j >0)
        {
            if (dp[i][j] == dp[i-1][j]) i--;
            else if (dp[i][j] == dp[i][j-1]) j--;
            else
            {
                sbd.append(sa.charAt(i-1));
                i--;
                j--;
            }
        }
        System.out.println(sbd.reverse());
        return dp[a][b];
    }

    public static void main(String[] args) {
        Main m = new Main();
        String s1 = "THREAT";
        String s2 = "HEART";
        int cnt = m.lcs(s1, s2, s1.length(), s2.length());
        System.out.println(cnt);
        cnt = m.lcsDP(s1, s2, s1.length(), s2.length());
        System.out.println(cnt);
    }
}
