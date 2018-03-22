public class Main {



    public int maxProfit(int[] p) {
        int min = Integer.MAX_VALUE;
        int maxp = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] < min)
                min = p[i];
            else if (p[i] - min > maxp)
                maxp = p[i] - min;
        }
        return maxp;
    }



    public static void main(String[] args) {
        int[] p = new int[]{7, 2, 5, 3, 6, 1, 4};
        Main m = new Main();
        int r = m.maxProfit(p);
        System.out.println(r);
    }
}
