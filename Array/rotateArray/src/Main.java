import java.util.Arrays;

public class Main {


    public void rotate(int[] a, int k) {
        if ( a == null || a.length == 0 || k ==0) return;
        int l = a.length-1;
        k = k % (l+1);
        reverse(a, 0, l-k);
        reverse(a,l-k+1,l);
        reverse(a,0,l);
    }

    private void reverse(int[] a, int i, int j) {
        while (i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] ip = new int[]{1, 2, 3, 4, 5, 6, 7};
        Main m = new Main();
        m.rotate(ip, 3);
        System.out.println(Arrays.toString(ip));

    }
}
