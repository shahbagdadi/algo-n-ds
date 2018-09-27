import java.util.Arrays;

public class Main {

    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
//        dpSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int l, int h) {
        if (l >= h) return;
        //int m = (l + h) / 2;
        int pivot = a[h]; // pivot can be left , mid or right element
        int i = l, j = h;
        while (i <= j) {
            while (a[i] < pivot)
                i++;
            while (a[j] > pivot)
                j--;

            //swap
            if (i <= j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }

        }
        if (l < j)
            quickSort(a, l, j);
        if (h > i)
            quickSort(a, i, h);
    }

    /**
     * Dual pivot sort
     * take either end as pivot and arrange such that
     * ***p1***p2****
     * where all element less than p1 are to left of p1
     * all elements >= p1 and less than p2 are between p1 and p2
     * all elements > p2 are to the right of p2
     */
    private void dpSort(int[] a, int lo, int hi) {
        if (hi <= lo) return;

        // make sure a[lo] <= a[hi]
        if (a[hi] < a[lo]) swap(a, lo, hi);

        int lt = lo + 1, gt = hi - 1;
        int i = lo + 1;
        while (i <= gt) {
            if (a[i] < a[lo]) swap(a, lt++, i++);
            else if (a[hi] < a[i]) swap(a, i, gt--);
            else i++;
        }
        swap(a, lo, --lt);
        swap(a, hi, ++gt);

        // recursively sort three subarrays
        dpSort(a, lo, lt - 1);
        if (a[lt] < a[gt]) dpSort(a, lt + 1, gt - 1);
        dpSort(a, gt + 1, hi);

    }


    private void swap(int[] a, int l, int h) {
        int tmp = a[l];
        a[l] = a[h];
        a[h] = tmp;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] a = {12, 11, 13, 5, 6, 7};
        m.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
