import java.util.Arrays;

public class Main {


    public boolean winner(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }

    // T - O(2^n)    S - O(n)
    private int helper(int[] a, int s, int e) {
        if (s == e) return a[s];
        int c1 = a[s] - helper(a, s + 1, e);
        int c2 = a[e] - helper(a, s, e - 1);
        return Math.max(c1, c2);
    }


    // T - O(n^2)    S - O(n^2)
    public boolean winnerMemo(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        boolean f = helperM(nums, 0, nums.length - 1, memo) >= 0;
        for (Integer[] ar : memo)
            System.out.println(Arrays.toString(ar));
        return f;
    }

    // T - O(n^2)    S - O(n^2)
    private int helperM(int[] a, int s, int e, Integer[][] memo) {
        if (s == e) return a[s];
        if (memo[s][e] != null) return memo[s][e];
        int c1 = a[s] - helperM(a, s + 1, e, memo);
        int c2 = a[e] - helperM(a, s, e - 1, memo);
        memo[s][e] = Math.max(c1, c2);
        return memo[s][e];
    }

    // T - O(n^2)    S - O(n^2)
    public boolean winner2DP(int[] a) {
        int[][] dp = new int[a.length][a.length];
        for (int s = a.length - 1; s >= 0; s--) {
            dp[s][s] = a[s];
            for (int e = s + 1; e < a.length; e++) {
                int c1 = a[s] - dp[s + 1][e];
                int c2 = a[e] - dp[s][e - 1];
                dp[s][e] = Math.max(c1, c2);
            }
        }
        for (int[] ar : dp)
            System.out.println(Arrays.toString(ar));
        return dp[0][a.length - 1] >= 0;
    }

    // T - O(n^2)    S - O(n)
    public boolean winner1DP(int[] a) {
        int[] dp = new int[a.length];
        for (int s = a.length -1; s >= 0; s--) {
            dp[s] = a[s];
            for (int e = s + 1; e < a.length; e++) {
                int c1 = a[s] - dp[e];
                int c2 = a[e] - dp[e - 1];
                dp[e] = Math.max(c1, c2);
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[a.length - 1] >= 0;
    }

    public static void main(String[] args) {
        int[] ip = {1, 5, 2, 4, 6};
//       int[] ip = {1, 12, 4};
        Main m = new Main();
        System.out.println(m.winner(ip));
        System.out.println(m.winnerMemo(ip));
        System.out.println(m.winner2DP(ip));
        System.out.println(m.winner1DP(ip));
    }
}
