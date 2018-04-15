import java.util.Arrays;

public class Main {


    public int maxProfit(int[]a,int l , int h, int y)
    {
        int max = 0;
        if (l > h) return 0;
        max = Math.max(a[l]*y + maxProfit(a,l+1,h,y+1),a[h]*y + maxProfit(a,l,h-1,y+1));
        return max;
    }


    public int myMaxProfitDP(int[]a) {
        int[][] dp = new int[a.length+1][a.length];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        maxProfitDPhelper(a,dp,0,a.length-1);
        for(int[] ary : dp)
            System.out.println(Arrays.toString(ary));
        return dp[0][a.length-1];
    }

    //Store the result for a start index (l) and end index (h) in dp
    public int maxProfitDPhelper(int[]a, int[][] dp, int l , int h) {
        if (l > h)
            return 0;
        if (dp[l][h] != -1) {
            System.out.println("From dp [" + l + "," + h + "] = " + dp[l][h] );
            return dp[l][h];
        }
        int y = a.length - (h-l);
        dp[l][h] = Math.max(
                maxProfitDPhelper(a,dp,l+1, h) + y * a[l],
                maxProfitDPhelper(a,dp,l, h-1) + y * a[h]);
        return dp[l][h];
    }


    public static void main(String[] args) {

        int[] w = {2,3,5,1,4};
        Main m = new Main();
        int a = m.maxProfit(w,0,w.length-1,1);
        System.out.println(a);
        int b = m.myMaxProfitDP(w);
        System.out.println(b);

    }
}
