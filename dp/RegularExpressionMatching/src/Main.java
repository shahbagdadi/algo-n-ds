public class Main {

    // T - O(2^m+n) S - O(m+n)
    public boolean isMatch(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        if (lp == 0) return ls == 0;
        boolean m1 = (ls > 0 &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (lp >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) ||
                    (m1 && isMatch(s.substring(1), p)));
        } else {
            return m1 && isMatch(s.substring(1), p.substring(1));
        }
    }

    // T - O(m * n)   S - O(m * n)
    private boolean isMatchDP(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        boolean[][] dp = new boolean[ls + 1][lp + 1];
        dp[ls][lp] = true;

        for (int i = ls; i >= 0; i--) {
            for (int j = lp - 1; j >= 0; j--) {
                boolean m1 = ( ls > i &&
                        (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
                if (lp > j + 1  && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || m1 && dp[i + 1][j];
                } else {
                    dp[i][j] = m1 && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {

        Main m = new Main();
        System.out.println(m.isMatch("a", "b"));
        System.out.println(m.isMatch("aab", "aac"));
        System.out.println(m.isMatch("acb", "aa."));
        System.out.println(m.isMatch("aab", "aab*c"));
        System.out.println(m.isMatch("aab", "aa*"));
        System.out.println(m.isMatch("aab", ".*"));
        System.out.println(m.isMatch("aab", "aad*b"));
        System.out.println(m.isMatch("aab", "a.bd*"));

        System.out.println("----------------------");

        System.out.println(m.isMatchDP("a", "b"));
        System.out.println(m.isMatchDP("aab", "aac"));
        System.out.println(m.isMatchDP("acb", "aa."));
        System.out.println(m.isMatchDP("aab", "aab*c"));
        System.out.println(m.isMatchDP("aab", "aa*"));
        System.out.println(m.isMatchDP("aab", ".*"));
        System.out.println(m.isMatchDP("aab", "aad*b"));
        System.out.println(m.isMatchDP("aab", "a.bd*"));

    }
}
