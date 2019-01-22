import java.util.Arrays;

public class Main {

    int ans = Integer.MIN_VALUE;

    public int maxProduct(int[] nums) {
        helper(nums, 1, 0);
        return ans;
    }

    private void helper(int[] a, int prd, int start) {
        if (start == a.length) return;
        int r = Integer.max(a[start], a[start] * prd);
        if (r > ans) ans = r;
        helper(a, a[start] * prd, start + 1);
        helper(a, a[start], start + 1);
    }

    private int max(int a, int b, int c) {
        if (a > b)
            return (a > c) ? a : c;
        else
            return (b > c) ? b : c;

    }

    public int maxProductDP(int[] a) {
        int imin =a[0] , imax = a[0] , r = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < 0)
            {
                int t = imin;
                imin = imax ;
                imax = t;
            }

            imin = Integer.min(a[i], a[i] * imin);
            imax = Integer.max(a[i], a[i] * imax);
            r = Integer.max(r,imax);
        }
        return r;
    }



    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.maxProductDP(new int[]{2, -5, -2, -4, 3}));
    }
}
