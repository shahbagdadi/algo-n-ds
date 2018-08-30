public class Main {


    public boolean canPartition(int[] a) {
        int sum = getSum(a);
        if (sum % 2 > 0) return false;
        return (groupSum(a, 0, sum / 2));
    }

    boolean groupSum(int[] a, int i, int t) {
        if (t == 0) return true;
        if (i == a.length) return false;
        return groupSum(a, i + 1, t - a[i]) || groupSum(a, i + 1, t);
    }

    private static int getSum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];
        return sum;
    }

    public boolean canPartitionDP(int[] a) {
        int sum = getSum(a);
        if (sum % 2 > 0) return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int n : a) {
            for (int j = sum; j > 0; j--) {
                if (j-n >= 0)
                    dp[j] = dp[j] || dp[j - n];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {

//        int [] a = {4, 1, -5, 6, -11, 3};
//        int[] a  = {2, 4, 16};
        int[] a = {1, 5, 11, 5};
//        int[] a = {1, 2, 3, 5};
        Main m = new Main();
        //boolean r = m.canPartition(a);
        boolean r = m.canPartitionDP(a);
        System.out.println(r);
    }


}
