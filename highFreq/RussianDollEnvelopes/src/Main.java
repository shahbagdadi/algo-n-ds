import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public int maxEnvelopes(int[][] envelopes) {
        int[] dp = new int[envelopes.length];
        //sort on width asc and height desc
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if (a1[0] == a2[0])
                    return a2[1] - a1[1];
                else
                    return a1[0]-a2[0];
            }
        });

        int len =0;
        for (int[] env: envelopes) {
            int i = Arrays.binarySearch(dp,0,len,env[1]);
            if (i < 0) i = -(i +1);
            dp[i] = env[1];
            if (i == len) len++;
        }
        System.out.println(Arrays.toString(dp));
        return len;
    }

    public static void main(String[] args) {
        int[][] envs = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Main m = new Main();
        System.out.println(m.maxEnvelopes(envs));
    }
}
