import java.util.Arrays;

public class CountMinCoin {

    // T - O(T * n)   S - O(T)
    public static int countMinCount(int[] coins, int tg)
    {
        int[] dp = new int[tg+1];
        dp[0] = 0;
        for (int t = 1; t < dp.length; t++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (t - coin >= 0)
                    min = Math.min(min, dp[t - coin]);
            }
            dp[t] = (min != Integer.MAX_VALUE) ? min+1 : min;
        }
        System.out.println(Arrays.toString(dp));
        return dp[tg];
    }

    // T - O(T^n)   S - O(n)
    public static int countR(int[] coins, int t)
    {
        if (t < 0) return -1;
        if (t == 0) return  0;
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = countR(coins, t - coin);
            if (res >=0 && res < min)
                min = 1 + res;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{9,6,5,1};
        int cnt1 = countR(coins, 11);
        System.out.println(cnt1);
        int cnt2 = countMinCount(coins,11);
        System.out.println(cnt2);
    }
}
