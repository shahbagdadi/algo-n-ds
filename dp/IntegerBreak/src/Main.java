public class Main {


    public int integerBreak(int n) {
        if (n <= 1) return 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = max(max, i * (n - i), i * integerBreak(n - i));
        }
        return max;
    }


    public int integerBreakDP(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                max = max(max, j * (i - j), j * dp[i - j]);
                dp[i] = max;
            }
        }
        return dp[n];
    }

    int max(int a, int b, int c) {
        if (a > b)
            return (a > c) ? a : c;
        else
            return (b > c) ? b : c;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.integerBreak(10));
        System.out.println(m.integerBreakDP(10));
    }
}
