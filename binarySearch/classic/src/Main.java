public class Main {

    public int searchRecursive(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    public int helper(int[] a, int l, int h, int t) {
        if (h >= l) {
            int m = l + (h - l) / 2;
            if (a[m] == t) return m;
            else if (a[m] > t)
                return helper(a, l, m - 1, t);
            else
                return helper(a, m + 1, h, t);
        }
        return -1;
    }

    int binarySearch1(int[] a, int t) {
        if (a == null || a.length == 0)
            return -1;

        int l = 0, h = a.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (a[m] == t) return m;
            else if (a[m] < t) l = m + 1;
            else h = m - 1;
        }
        return -1;
    }

    int binarySearch2(int[] a, int t) {
        if (a == null || a.length == 0)
            return -1;

        int l = 0, h = a.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (a[m] == t) return m;
            else if (a[m] < t) l = m + 1;
            else h = m;
        }
        if(l != a.length && a[l] == t) return l;
        return -1;
    }

    int binarySearch3(int[] a, int t) {
        if (a == null || a.length == 0)
            return -1;

        int l = 0, h = a.length -1;
        while (l + 1 < h) {
            int m = l + (h - l) / 2;
            if (a[m] == t) return m;
            else if (a[m] < t) l = m + 1;
            else h = m;
        }
        if(a[l] == t) return l;
        if(a[h] == t) return h;
        return -1;
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[] a = new int[]{-4, 2, 6, 9, 10};
        int t = 6;
        System.out.println(m.searchRecursive(a, t));
        System.out.println(m.binarySearch1(a, t));
        System.out.println(m.binarySearch2(a, t));
        System.out.println(m.binarySearch3(a, t));
    }
}
