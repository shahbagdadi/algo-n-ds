public class Main {


    public int kthSmallest(int[][] a, int k) {

        int lo = a[0][0];
        int hi = a[a.length - 1][a[0].length - 1] + 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            int j = a[0].length - 1;
            for (int i = 0; i < a.length; i++) {
                while (j >= 0 && a[i][j] > mid) j--;
                cnt += (j + 1);
            }
            if (cnt < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }


    public static void main(String[] args) {

        Main m = new Main();
        int[][] a = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(m.kthSmallest(a, 8));
    }
}
