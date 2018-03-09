public class Main {

    public void moveZeroes(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 0)
                rotate(a, i);
        }
    }

    public void rotate(int[] a, int s) {
        int e = a.length - 1;
        if (e <= s) return;
        for (int i = s; i < e; i++)
            a[i] = a[i + 1];
        a[e] = 0;
    }

    public void moveZeroOptimized(int[] a)
    {
        int p =0;
        for (int n : a)
            if (n != 0) a[p++] = n;

        for (int i = p; i < a.length; i++)
            a[i] = 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 1, 0, 7, 12,0};
        Main m = new Main();
        //m.moveZeroes(a);
        m.moveZeroOptimized(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(" " + a[i]);
        }

    }
}
