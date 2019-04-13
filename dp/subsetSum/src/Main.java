public class Main {

    public boolean isSubsetSum(int[] a,  int sum, int n)
    {
        if (sum == 0) return true;
        if (n < 0 && sum != 0) return false;
        if (a[n] > sum) return isSubsetSum(a,sum,n-1);
        return isSubsetSum(a,sum,n-1) || isSubsetSum(a,sum - a[n],n-1);
    }

    public boolean isSubsetSumMemo(int[] a, int sum, int n)
    {
        Boolean[][] memo = new Boolean[n+1][sum+1];
        return helper(a,sum, memo,a.length-1);
    }

    private boolean helper(int[] a, int sum,  Boolean[][] memo, int i) {
        if (sum == 0) return true;
        if (i < 0 && sum != 0) return false;
        if (memo[i][sum] == null)
        {
            if (a[i] > sum){
                memo[i][sum] = helper(a,sum,memo,i-1);
                return memo[i][sum];
            }

            memo[i][sum] = helper(a,sum,memo,i-1) || helper(a,sum-a[i],memo,i-1);
        }
        return memo[i][sum];
    }

    public boolean isSubsetSumDP2(int[] a,  int sum) {
        int n = a.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        //sum =0 -> true // Base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= a[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j - a[i-1]]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public boolean isSubsetSumDP(int[] a,  int sum) {
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = sum; j >0; j--) {
                if (j >= a[i]) {
                    dp[j] = (dp[j] || dp[j - a[i]]);
                }
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[] a = {3, 34, 4, 12, 6, 1};
        int t = 10;
        System.out.println(m.isSubsetSum(a,t,a.length-1));
        System.out.println(m.isSubsetSumMemo(a,t,a.length-1));
        System.out.println(m.isSubsetSumDP2(a,t));
        System.out.println(m.isSubsetSumDP(a,t));
    }
}
