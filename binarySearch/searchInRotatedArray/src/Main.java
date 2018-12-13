public class Main {

    public int search(int[] a, int target) {
        if (a == null || a.length == 0) return -1;
        // find the pivot
        int l = 0;
        int h = a.length - 1;
        while ( h - l > 1) 
        {
            int m = (l + h) / 2;
            if (a[m] > a[h])
                l = m;
            else
                h = m;
        }

        int pivot = (a[l] < a[h]) ? l : h;
        //System.out.println("pivot at " + pivot);
        l = 0;
        h = a.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            int rm = (m + pivot) % a.length;
            if (a[rm] == target) return rm;
            else if (a[rm] > target)
                h = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.search(new int[]{4, 5, 6, 7, 8, 0, 1, 2,3}, 1));
    }
}
