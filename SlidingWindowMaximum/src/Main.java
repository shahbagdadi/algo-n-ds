import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Main {

    // O(N) O(K)
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length, ri = 0;
        if (a == null || k == 0) return new int[0];
        int[] r = new int[n + 1 - k];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            if (!dq.isEmpty() && dq.peek() < i -k +1) dq.poll();
            while (!dq.isEmpty() && a[i] > a[dq.peekLast()]) dq.pollLast();
            dq.offer(i);
            if (i >= k-1) r[ri++] = a[dq.peek()];
        }
        return r;
    }

    // O(NlogK) O(K)
    public int[] maxSlidingWindowTreeSet(int[] a, int k) {
        int n = a.length, ri = 0, max = 0;
        if (a == null || k == 0) return new int[0];
        int[] r = new int[n + 1 - k];
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n ; i++) {
            if (i >= k) {
                int cnt = map.get(a[i - k]);
                if (cnt == 1) map.remove(a[i - k]);
                else map.put(a[i - k], cnt - 1);
            }
            Integer cnt = map.get(a[i]);
            if (cnt== null) map.put(a[i],1);
            else  map.put(a[i], cnt + 1);
            max = map.firstKey();
            if (i >= k-1)r[ri++] = max;
        }
        return r;
    }

    // O(n.k) & O(1)
    public int[] maxSlidingWindowBF(int[] a, int k) {
        if (a == null || k == 0) return new int[0];
        int n = a.length, ri = 0;
        int[] r = new int[n + 1 - k];
        for (int i = 0; i < n + 1 - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++)
                if (a[i + j] > max) max = a[i + j];
            r[ri++] = max;
        }
        return r;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] a = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
//        int[] r = m.maxSlidingWindowBF(a, 3);
//        int[] r = m.maxSlidingWindowTreeSet(a, 3);
        int[] r = m.maxSlidingWindow(a, 3);
        for (int i = 0; i < r.length; i++) {
            int i1 = r[i];
            System.out.print(i1 + " ");
        }
    }
}
