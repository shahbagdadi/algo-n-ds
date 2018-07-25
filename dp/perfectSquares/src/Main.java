/**
 * Time - O(n*n^1/2) = O(n^3/2)
 * SPace - O(n)
 */
public class Main {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; i - j * j >= 0; j++){
                min = Math.min(min, dp[i - j * j] + 1);
                dp[i] = min;
                System.out.println("dp[" + i + "] = " + min);
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.numSquares(12));
    }
}
