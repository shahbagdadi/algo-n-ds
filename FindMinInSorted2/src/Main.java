public class Main {

    public int findMin(int[] a) {
        int l =0;
        int h = a.length-1;
        while (l < h)
        {
            int m = (l+h)/2;
            //System.out.println(l + " " + m + " " + h);
            if (a[m] > a[h])
                l = m+1;
            else if (a[m] < a[h])
                h = m;
            else
                h--;

        }
        return l;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Ans " + m.findMin(new int[]{6,6,6,6,6}));
    }

}
