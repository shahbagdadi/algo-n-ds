import java.util.Arrays;
import java.util.HashMap;

public class ZeroSum {

    public static void main(String[] args) {
        int[] input = {5, 1, 2, -3, 7, -4, -8, -1};
        int[] result = zeroSum(input);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] zeroSum(int[] a) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) return new int[]{a[i]};
            sum += a[i];
            if (sum == 0)
                return Arrays.copyOfRange(a, 0, i);
            else {
                Integer pos = map.get(sum);
                if (pos == null)
                    map.put(sum, i);
                else
                    return Arrays.copyOfRange(a, pos + 1, i + 1);
            }
        }
        return new int[0];
    }
}
