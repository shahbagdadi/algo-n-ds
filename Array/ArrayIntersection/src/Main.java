import java.util.ArrayList;
import java.util.HashMap;

public class Main {


    public int[] intersect(int[] a, int[] b) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            Integer cnt = m.get(a[i]);
            if (cnt == null)
                m.put(a[i], 1);
            else
                m.put(a[i], cnt + 1);
        }
        ArrayList<Integer> r = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            Integer cnt = m.get(b[i]);
            if (cnt != null && cnt > 0)
            {
                r.add(b[i]);
                m.put(b[i],cnt-1);
            }
        }
        int[] res = new int[r.size()];
        int i=0;
        for (int n :r ) {
            res[i++] = n;
        }
        return res;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] a = new int[]{1};
        int[] b = new int[]{1, 1};
        int[] res = m.intersect(a,b);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " " );
        }
    }
}
