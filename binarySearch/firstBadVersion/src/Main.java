public class Main {


    public int firstBadVersion(int n) {
        return findBadHelper(1,n,Integer.MAX_VALUE);
    }

    public int itrFirstBadVersion(int n) {
        int s =0, e = n;
        while (s < e)
        {
            int mid = s + (e-s)/2;
            if (isBadVersion(mid))
                e = mid;
            else
                s = mid+1;
        }
        return s;
    }

    private int findBadHelper(int l, int h, int min) {
        if (l == h) return h;
        int mid = l + (h-l)/2;
        min = (isBadVersion(mid)) ? Math.min(min, findBadHelper(l,mid,min)) : Math.min(min, findBadHelper(mid+1,h,min));
        return min;
    }

    private boolean isBadVersion(int n) {
        if ( n>= 3) return true;
        return false;
    }


    public static void main(String[] args) {

        Main m = new Main();
        //int n = m.firstBadVersion(3);
        int n = m.itrFirstBadVersion(3);
        System.out.println(n);
    }
}
