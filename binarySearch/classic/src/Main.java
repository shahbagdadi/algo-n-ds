public class Main {

    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    public int helper(int[] a, int l, int h, int t) {
        if (h >= l) {
            int m = l + (h - l) / 2;
            if (a[m] == t) return m;
            if (a[m] > t)
                return helper(a, l, m - 1, t);
            else
                return helper(a, m + 1, h, t);
        }
        return -1;
    }

    public static void main(String[] args) {

        Main m = new Main();
        int [] a = new int[]{-4,2,6,9,10};
        System.out.println(m.search(a,6));
    }
}
