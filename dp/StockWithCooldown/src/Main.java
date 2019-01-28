public class Main {


    public int maxProfit(int[] prices) {
        int profit_max_i = 0, profit_so_far = 0;
        for (int i = 1; i < prices.length; i++) {
            int prev_profit = profit_max_i;
            // max of profit if I dont sell now vs profit if sold at i-1 and cool down right now
            profit_max_i = Math.max(prev_profit + prices[i] - prices[i - 1], profit_so_far);
            profit_so_far = Math.max(prev_profit, profit_so_far);
        }
        return Math.max(profit_max_i, profit_so_far);
    }



    public static void main(String[] args) {
        Main m = new Main();
        int ans = m.maxProfit(new int[]{1, 2, 3, 1, 9, 2});
        System.out.println(ans);
    }

}
