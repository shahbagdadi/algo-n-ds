public class Main {

    public int maxProfit(int[] p) {

        int total = 0;
        for (int i = 0; i < p.length-1; i++) {
            if (p[i+1] > p[i])
                total += p[i+1] -p[i];
        }

        return total;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] prices = new int[]{2, 1, 3, 5, 7};
        System.out.println(m.maxProfit(prices));
    }
}
