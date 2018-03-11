public class Main {

    int bfMaxSubArray(int[] a) {
        int s = 0, max = a[0];
        for (int i = 0; i < a.length; i++) {
            s =0;
            for (int j = i; j < a.length; j++) {
                s += a[j];
                if (s > max)
                    max = s;
            }
        }
        return max;
    }


    int maxSubArray(int[] a) {
        int cmax = 0, max = 0;
        for (int i = 0; i < a.length; i++) {
            cmax += a[i];
            if (cmax < 0)
                cmax = 0;
            else if (cmax > max)
                max = cmax;
        }
        return max;
    }

    int optMaxSubArray(int[] a) {
        int cmax = a[0], max = a[0];
        for (int i = 1; i < a.length; i++) {
            cmax += a[i];
            cmax = Math.max(cmax,a[i]);
            max = Math.max(cmax,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2, -3, 4, -1, -2, 1, 5, -1};
        //int[] a = new int[]{-2, -3, -4, -1, -2, -1, -5, -1};
        Main m = new Main();
        //int r = m.bfMaxSubArray(a);
        //int r = m.maxSubArray(a);
        int r = m.optMaxSubArray(a);
        System.out.println(r);

    }
}
