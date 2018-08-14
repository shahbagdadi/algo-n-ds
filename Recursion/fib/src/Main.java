public class Main {


    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 2) + fib(n - 1);
    }

    public int fibMemo(int n)
    {
        int[] dp = new int[n+1];
        dp[1] = 1;
        return helper(n,dp);
    }

    private int helper(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        int f = helper(n - 2,dp) + helper(n - 1,dp);
        dp[n] = f;
        return f;
    }

    public int fibDP(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i < dp.length ; i++)
            dp[i] = dp[i-2] + dp[i-1];
        return dp[n];
    }

    // 0, 1,1,2,3
    public static void main(String[] args) {
        Main m = new Main();
        int n=7;
        System.out.println(m.fib(n));
        System.out.println(m.fibMemo(n));
        System.out.println(m.fibDP(n));
    }
}
