public class Main {

    // T - O(2^n)    S - O(n)
    public int knapSack(int wt[], int val[], int w) {
        return helper(wt, val,  wt.length ,w);
    }

    private int helper(int[] wt, int[] val, int n, int mw) {
        if (n == 0 || mw == 0) return 0;
        if (wt[n-1] > mw) return helper(wt, val, n - 1,mw);
        return Math.max(val[n-1] + helper(wt, val,  n - 1,mw - wt[n-1]), helper(wt, val, n - 1, mw));
    }


    // T - O(n * w) S - O(n * w)
    public int knapSackDP(int wt[], int val[], int mw) {
        // init DP
        int[][] dp = new int[wt.length + 1][mw + 1];

        // base conditions
        // set all rows for n=0 and w=0 to 0

        // Loop
        for (int n = 1; n < dp.length; n++) {
            for (int w = 1; w < dp[0].length; w++) {
                if (wt[n - 1] > w)
                    dp[n][w] = dp[n - 1][w];
                else
                    dp[n][w] = Math.max(val[n - 1] + dp[n - 1][w - wt[n - 1]], dp[n - 1][w]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }


    public static void main(String[] args) {
        Main m = new Main();
//        int[] wt1 = {1, 1, 1};
//        int[] val1 = {10, 20, 30};
//        System.out.println(m.knapSack(wt1, val1, 2));
//        System.out.println(m.knapSackDP(wt1, val1, 2));


        int[] wt1 = {1, 2, 4, 5};
        int[] val1 = {2, 3, 5, 6};
        System.out.println(m.knapSack(wt1, val1, 7));
        System.out.println(m.knapSackDP(wt1, val1, 7));
    }
}
