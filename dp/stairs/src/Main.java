public class Main {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairsDP(int n) {

        if (n <= 2) return n;

        // int[] dp = new int[n+1]
        // dp[1] = 1;
        // dp[2] = 2;
        int step1 = 1;
        int step2 = 2;
        int ans = 0;
        for (int i=3;i <= n;i++) // or (< dp.length)
        {
            ans = step1 + step2; // dp[i] = dp[i-2] + dp[i-1]
            step1 = step2;
            step2 = ans;
        }
        return ans;  // dp[i];
    }

    public static void main(String[] args) {
        Main m = new Main();
        int n = 4;
        int a1 = m.climbStairs(n);
        System.out.println(a1);
        int a2 = m.climbStairsDP(n);
        System.out.println(a2);

    }
}
