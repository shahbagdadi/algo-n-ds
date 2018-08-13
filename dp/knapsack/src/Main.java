public class Main {

    // T - O(n^2)    S - O(n)
    public int knapSack(int wt[], int val[], int w) {
        return helper(wt, val,  wt.length - 1,w);
    }

    private int helper(int[] wt, int[] val, int n, int mw) {
        if (n < 0 || mw == 0) return 0;
        if (wt[n] > mw) return helper(wt, val, n - 1,mw);
        return Math.max(val[n] + helper(wt, val,  n - 1,mw - wt[n]), helper(wt, val, n - 1, mw));
    }


    // T - O(n) S - O(n * w)
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


        int[] wt1 = {1, 3, 4, 5};
        int[] val1 = {1, 4, 5, 7};
        System.out.println(m.knapSack(wt1, val1, 7));
        System.out.println(m.knapSackDP(wt1, val1, 7));
    }
}
