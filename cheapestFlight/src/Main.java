import java.util.*;

public class Main {

    // T - O( E + n log n)     S - O(n)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //map for flights from each node
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
//        Map<Integer,Integer> paths = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0]))
                prices.put(f[0], new HashMap<>());
            //add dest & price to each src
            prices.get(f[0]).put(f[1], f[2]);
        }

        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                //compare on price
                return a[0] - b[0];
            }
        });
        // price, city, stops_allowed
        pq.add(new int[] {0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst)
            {
//                while (paths.get(city) != src)
//                {
//                    System.out.println(city);
//                    city = paths.get(city);
//                }
//                System.out.println(city);
                return price;
            }
            if (stops > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int dest : adj.keySet()) {
                    pq.add(new int[] {price + adj.get(dest), dest, stops - 1});
//                    paths.put(dest,city);
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        Main m = new Main();
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(m.findCheapestPrice(3,flights,0,2,1));
    }
}
