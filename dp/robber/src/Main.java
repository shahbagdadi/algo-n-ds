public class Main {


    int rob(int[] h, int i)
    {
        if (i > h.length-1) return 0;
        int  max = Math.max((h[i] + rob(h,i+2)), rob(h,i+1));
       return max;
    }

    int robDP(int[]h)
    {
        int dp1 = 0;
        int dp2 = h[0];
        for (int i=1; i < h.length; i++)
        {
            int dp3 = Math.max(dp2,dp1+h[i]);
            dp1 = dp2;
            dp2 = dp3;
        }
        return dp2;
    }

    public static void main(String[] args) {

        int hval[] = {5, 3, 4, 11, 2};
        //int hval[] = {6, 7, 1, 3, 8, 2, 4};
        Main m = new Main();
        //int a = m.rob(hval,0);
        int a = m.robDP(hval);
        System.out.println(a);
    }
}
