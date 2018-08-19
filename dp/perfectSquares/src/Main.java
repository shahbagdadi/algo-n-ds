import java.util.Arrays;

/**
 * Time - O(n*n^1/2) = O(n^3/2)
 * SPace - O(n)
 */
public class Main {

    public int numSquares(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int n = 1; n < dp.length; n++) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i * i <= n; i++){
                min = Math.min(min, dp[n - i * i] + 1);
                dp[n] = min;
                //System.out.println("dp[" + n + "] = " + min);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[num];
    }


    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.numSquares(13));
    }
}
