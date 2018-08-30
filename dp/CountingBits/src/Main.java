import java.util.Arrays;

public class Main {


    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for (int i = 1; i <= num ; i++) {
            System.out.println(i & (i-1));
            dp[i] = dp[i & (i-1)] +1;
        }
        return dp;
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[] ans = m.countBits(5);
        System.out.println(Arrays.toString(ans));
    }
}
