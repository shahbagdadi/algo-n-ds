public class Main {

    public int mySqrt(int x) {
        if (x == 1) return 1;
        int l = 0;
        int h = x / 2;
        int ans = 0;
        if (x == 1) return 1;
        while (l <= h) {
            long m = l + (h - l) / 2;
            if (m * m < x) {
                ans = (int) m;
                l = (int) m + 1;
            } else if (m * m > x)
                h = (int) m - 1;
            else return (int) m;
        }
        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.mySqrt(81));
    }
}
