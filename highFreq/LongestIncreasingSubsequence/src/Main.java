import java.util.Arrays;

public class Main {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int n : nums) {
            int i = Arrays.binarySearch(dp,0,len,n);
            //System.out.println(i);
            if (i < 0) i = -(i + 1);
            //System.out.println(i + " " + n);
            dp[i] = n;
            if (i == len) len++;
        }
        //System.out.println(Arrays.toString(dp));
        return len;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] ip = {2,7,4,8,12,5};
        System.out.println(m.lengthOfLIS(ip));
    }
}
