import java.util.HashSet;

public class TwoSum {


    public static int[] TwoSum(int[] a, int sum) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (set.contains(sum - a[i])) {
                return new int[]{a[i], sum - a[i]};
            } else
                set.add(a[i]);
        }
        throw new IllegalArgumentException("No two sum");
    }


    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 4, 4, 6, 3};
        int[] result = TwoSum(array, 6);
        System.out.println(result[0] + " " + result[1]);
    }
}
