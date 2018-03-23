public class Main {

    public int trap(int[] h) {
        int l = 0, r = h.length - 1, lmax = 0, rmax = 0, ans = 0;

        while (l < r) {
            if (h[l] < h[r]) {
                if (h[l] > lmax)
                    lmax = h[l];
                else
                    ans += (lmax - h[l]);
                l++;
            } else {
                if (h[r] >= rmax)
                    rmax = h[r];
                else
                    ans += (rmax - h[r]);
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Main m = new Main();
        int ans = m.trap(a);
        System.out.println(ans);
    }
}
