public class Main {

    public int climbStairs(int n) {
        if (n ==1) return 1;
        if (n ==2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairsDP(int n) {
        if (n ==1) return 1;
        if (n ==2) return 2;
        int dp1 = 1;
        int dp2 = 2;
        for (int i=3;i<n+1;i++)
        {
            int dp3 = dp2 + dp1;
            dp1 = dp2;
            dp2 = dp3;
        }
        return dp2;
    }

    public static void main(String[] args) {
        Main m = new Main();
//        int n = m.climbStairs(4);
        int n = m.climbStairsDP(4);
        System.out.println(n);
    }
}
