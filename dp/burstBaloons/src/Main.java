public class Main {

    public int maxCoins(int[] nums) {
        int[] a = new int[nums.length +2]; // add boundary on either side with value 1
        int i =1;
        for (int n: nums)
            if (n > 0) a[i++] = n; // a value of 0 does not add anything to result so remove it

        a[0] = a[i++] = 1; // boundary
        int[][] memo = new int[i][i];
        return burst(memo,a,0,i-1);
    }

    private int burst(int[][] memo, int[]num, int s, int e) {
        if (s + 1 == e) return 0; // only the boundaries are left
        if (memo[s][e] > 0) return memo[s][e];
        int ans =0;
        for (int i = s+1; i < e; i++) {
            ans = Math.max(ans,
                    num[s] * num[i] * num[e] + // the last = 1 * num[i] * 1
                    burst(memo,num,s,i) + burst(memo,num,i,e) ); // 
        }
        memo[s][e] = ans;
        return ans;
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[] ip = {3,1,5,8};
        System.out.println(m.maxCoins(ip));
    }
}
