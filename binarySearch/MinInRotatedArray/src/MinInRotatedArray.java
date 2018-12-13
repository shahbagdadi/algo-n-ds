public class MinInRotatedArray {

    public int findMin(int[] a) {
        int l = 0;
        int h = a.length - 1;
        while (h - l > 1)
        {
            int m = (h + l) / 2;
            //System.out.println("l = " + l + " m = " + m + " h = " + h);
            if (a[m] > a[h])
                l = m;
            else
                h = m;
        }
        //System.out.println("l = " + l + " h = " + h);
        return (a[l] > a[h]) ? a[h] : a[l];
    }

    public static void main(String[] args) {
        MinInRotatedArray m = new MinInRotatedArray();
        int[] input = {11, 12, 13, 4, 5};
        System.out.println(m.findMin(input));
    }
}
