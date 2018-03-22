import java.util.HashMap;

public class Main {

    public int maxSubArrayLen(int[] a, int k) {
        int sum =0, max=Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum -k)) max = Math.max(max, i - map.get(sum-k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{1, -1, 5, -2, 3};
        int[] a = new int[]{-2, -1, 2, 1};
//        int[] a = new int[]{-2, -1, 2, 1};
//        int[] a = new int[]{1};
//        int[] a = new int[]{-1,1};
        Main m = new Main();
        int n = m.maxSubArrayLen(a, 1);
        System.out.println(n);
    }
}
