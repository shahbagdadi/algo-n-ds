public class Main {

    public int minSubArrayLen(int s, int[] a) {
        int i = 0, j = 0, min = Integer.MAX_VALUE, l = a.length, sum = 0;
        if (a == null || a.length == 0)
            return 0;

        while (j < l) {
            //System.out.println("+ " + a[j]);
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
               // System.out.println("min " + min);
                //System.out.println("- " + a[i]);
                sum -= a[i++];
            }
        }
        if (min == Integer.MAX_VALUE)
            return 0;
        return min;
    }


    public static void main(String[] args) {
        //int[] a = new int[]{2, 3, 1, 2, 4, 3};
        int[] a = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        Main m = new Main();
        int n = m.minSubArrayLen(213, a);
        System.out.println(n);
    }
}
