public class Main {

    public int findMin(int[] a) {
        int l = 0;
        int h = a.length - 1;
        if (h == 0) return a[h];
        while (h - l > 1) {
            int m = (l + h) / 2;
            if (a[m] > a[h])
                l = m;
            else if (a[m] < a[h])
                h = m;
            else
                h--;
        }
        return (a[l] < a[h]) ? a[l] : a[h];
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Ans " + m.findMin(new int[]{2,2,2,0,1}));
    }

}
