public class Main {


    public String minWindow(String S, String T) {
        int min = Integer.MAX_VALUE, i = 0, j = 0, ls = S.length(), lt = T.length() - 1, si = 0;
        String r = null;
        while (i < ls) {
            if (S.charAt(i) == T.charAt(j)) {
                if (j == 0) si = i;
                if (j == lt) {
                    if (i - si < min) {
                        min = i - si;
                        r = S.substring(si, i + 1);
                    }
                    i = si+1;
                    j = 0;
                    continue;
                }
                j++;
            }
            i++;
        }
        return (min == Integer.MAX_VALUE) ? "" : r;
    }

    public String minWindowDP(String S, String T) {
        int m = T.length(), n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        int start = 0, len = n + 1;
        for (int j = 1; j <= n; j++) {
            if (dp[m][j] != 0) {
                if (j - dp[m][j] + 1 < len) {
                    start = dp[m][j] - 1;
                    len = j - dp[m][j] + 1;
//                    System.out.printf("St="+ start + " Len=" + len);
                }
            }
        }
        return len == n + 1 ? "" : S.substring(start, start + len);
    }


    public static void main(String[] args) {
        Main m = new Main();
//        String s = m.minWindowDP("cnhczmccqouqadqtmjjzl", "cm");
        String s = m.minWindowDP("abcdebdde", "bde");
        System.out.printf(" Result " + s);
    }
}
