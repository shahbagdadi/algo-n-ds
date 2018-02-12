import java.util.Arrays;

public class PartitionEqualSubset {

    public static void main(String[] args) {
        int[] ip1 = {1, 5, 11, 5};
        System.out.println(hasEqualSubset(ip1));
        int[] ip2 = {1, 2, 3, 5};
        System.out.println(hasEqualSubset(ip2));
    }

    private static boolean hasEqualSubset(int[] ip) {
        int sum = 0;
        for (int num : ip)
            sum += num;

        // if the sum is sum of 2 numbers it can never be odd
        if ((sum & 1) == 1) {
            return false;
        }

        // {x/2} + {x/2} = x
        // so just check if there is a subset which equals x/2
        sum /= 2;
        boolean[] ss = new boolean[sum + 1];
        Arrays.fill(ss, false);
        ss[0] = true;

        for (int num : ip) {
            for (int i = sum; i > 0; i--) {
                if (i >= num)
                    ss[i] = ss[i] || ss[i - num];
            }
        }
        return ss[sum];
    }
}
