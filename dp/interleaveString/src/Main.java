public class Main {

    public boolean isInterleave(String s1, String s2, String s3) {
        return helper(s1, 0, s2, 0, s3, 0);
    }

    boolean helper(String s1, int i, String s2, int j, String s3, int k) {
        if (k == s3.length() && i == s1.length() && j == s2.length()) return true;
        if (k == s3.length() && (i < s1.length() || j < s2.length())) return false;
        boolean ans = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = ans || helper(s1, i + 1, s2, j, s3, k + 1);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = ans || helper(s1, i, s2, j + 1, s3, k + 1);
        }

        return ans;
    }

    public boolean isInterleavedp(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean dp[][] = new boolean[s2.length() + 1][s1.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int j = 1; j < dp.length; j++) {
            dp[j][0] = dp[j - 1][0] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (dp[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1))) ||
                        (dp[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)));
                //System.out.println(dp[i][j]);
            }
        }

        return dp[s2.length()][s1.length()];
    }

    public static void main(String[] args) {

        Main m = new Main();
//        boolean a = m.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        boolean a = m.isInterleavedp("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(a);
    }
}
