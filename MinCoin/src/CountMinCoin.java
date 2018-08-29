import java.util.Arrays;

public class CountMinCoin {

    public static int countMinCount(int[] coins, int target)
    {
        int[] dp = new int[target+1];
        dp[0] = 0;
        for (int t = 1; t < dp.length; t++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (t - coins[i] >= 0)
                    min = Math.min(min, dp[t - coins[i]]);
            }
            dp[t] = (min != Integer.MAX_VALUE) ? min+1 : min;
        }
        System.out.println(Arrays.toString(dp));
        return dp[target];
    }

    public static int countMinCountR(int[] coins, int target)
    {
        if (target <= 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++)
            min = Math.min(min, countMinCountR(coins,target - coins[i]));
        if (min!=Integer.MAX_VALUE)
            min = min+1;
        return min;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{9,6,5,1};
        int cntr = countMinCountR(coins, 11);
        System.out.println(cntr);

        int cnt = countMinCount(coins,11);
        System.out.println(cnt);
    }
}
