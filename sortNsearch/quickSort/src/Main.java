import java.util.Arrays;

public class Main {

    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int l, int h) {
        if (l >= h) return;
        int m = (l + h) / 2;
        int pivot = a[m];
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

    public static void main(String[] args) {
        Main m = new Main();
        int[] a = {12, 11, 13, 5, 6, 7};
        m.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
