public class Main {


    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int dp[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (isValidDecode(s.substring(i, i + 1)))
                if (i + 1 < n)
                    dp[i] += dp[i + 1];
                else
                    dp[i] = 1;

            if (i + 2 <= n && isValidDecode(s.substring(i, i + 2)))
                if (i + 2 < n)
                    dp[i] += dp[i + 2];
                else
                    dp[i] += 1;
        }
        return dp[0];
    }


    boolean isValidDecode(String s) {
        if (s.length() > 2 || s.startsWith("0")) return false;
        return 1 <= Integer.parseInt(s) && Integer.parseInt(s) <= 26;
    }

    public static void main(String[] args) {

        Main m = new Main();
        int n = m.numDecodings("1212");
        System.out.println(n);
    }
}
