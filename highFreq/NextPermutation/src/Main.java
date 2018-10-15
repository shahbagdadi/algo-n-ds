import java.util.Arrays;

public class Main {

    public void nextPermutation(int[] a) {

        // find i such that a[i] > a[i+1]
        int i = a.length - 2;
        for (; i >= 0; i--)
            if (a[i] < a[i + 1]) break;
        //System.out.println(i);
        // find a[j] such that a[j] is the next greater than a[i]
        if (i >= 0) {
            int j = a.length - 1;
            for (; j >= 0; j--)
                if (a[j] > a[i]) break;
            // swap a[i] and a[j]
            //System.out.println("swap " + a[i] + " " + a[j]);
            swap(a, i, j);
        }
        reverse(a, i + 1);
    }

    private void reverse(int[] a, int start) {
        int end = a.length - 1;
        while (start <= end) {
            swap(a, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] ip = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        Main m = new Main();
        m.nextPermutation(ip);
        System.out.println(Arrays.toString(ip));
    }
}
