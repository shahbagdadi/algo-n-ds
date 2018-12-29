import java.util.*;

public class Main {
    public List<Integer> topKFrequent(int[] a, int k) {
        List<Integer> r = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n: a) {
            int cnt = map.getOrDefault(n,0);
            map.put(n,cnt + 1);
        }
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1]-a[1];
            }
        });
        for (int n : map.keySet())
            pq.add(new int[] {n,map.get(n)});

        for (int i = 0; i < k; i++) {
            int[] e = pq.poll();
            r.add(e[0]);
        }
        return r;
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[] ip = {1,2,1,1,3,3,};
        List<Integer> ans = m.topKFrequent(ip,2);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
