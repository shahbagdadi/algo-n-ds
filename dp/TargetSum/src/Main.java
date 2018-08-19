import java.util.Arrays;

public class Main {

    int cnt = 0;

    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) /2);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }


    // Brute Force T - O(2^n) S - O(n)
    public int targetSum(int[] nums, int s) {
        cnt = 0;
        return helper(nums, nums.length - 1, 0, s);
    }

    int helper(int[] a, int n, int s, int t) {
        if (n < 0) {
            if (s == t)
                return cnt++;
        } else {
            helper(a, n - 1, s + a[n], t);
            helper(a, n - 1, s - a[n], t);
        }
        return cnt;
    }

    // Memoizaton
    public int targetSumM(int[] nums, int t) {
        cnt = 0;
        int[][] dp = new int[nums.length + 1][2001];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return helperM(nums, nums.length - 1, 0, t, dp);
    }

    int helperM(int[] a, int n, int s, int t, int[][] dp) {
        if (n < 0) {
            if (s == t)
                return 1;
            else
                return 0;
        } else {
            if (dp[n][s + 1000] != Integer.MIN_VALUE)
                return dp[n][s+1000];
            int plus = helperM(a, n - 1, s + a[n], t,dp);
            int minus = helperM(a, n - 1, s - a[n], t, dp);;
            dp[n][s+1000] =  plus + minus;
            return dp[n][s+1000];
        }
    }


    public static void main(String[] args) {
        Main m = new Main();
        int[] a = new int[]{1, 2, 3, 4, 5};
        int ans = m.findTargetSumWays(a, 3);
        System.out.println(ans);
        ans = m.targetSum(a, 3);
        System.out.println(ans);
        ans = m.targetSumM(a, 3);
        System.out.println(ans);
    }
}
