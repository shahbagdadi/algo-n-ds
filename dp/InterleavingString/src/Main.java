public class Main {

    public boolean isInterleaveR(String s1, String s2, String s3) {
        return helper(s1, 0, s2, 0, "", s3);
    }

    private boolean helper(String s1, int i, String s2, int j, String res, String s3) {
        if (res.equals(s3) && i == s1.length() && j == s2.length()) return true;
        boolean ans = false;
        if (i < s1.length())
            ans = ans || helper(s1, i + 1, s2, j, res + s1.charAt(i), s3);
        if (j < s2.length())
            ans = ans || helper(s1, i, s2, j + 1, res + s2.charAt(j), s3);
        return ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }


    public static void main(String[] args) {
        Main m = new Main();
        boolean r = m.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(r);
    }
}
