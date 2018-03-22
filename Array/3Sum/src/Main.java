import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> lst = new ArrayList<>();
        int N = a.length;
        for (int i = 0; i + 2 < N; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;
            int sum = a[i];
            int p = i + 1, q = N - 1;
            while (p < q) {
                System.out.println(sum + " " + a[p] + " " + a[q]);
                int total = a[p] + a[q] + sum;
                if (total == 0) {
                    lst.add(Arrays.asList(sum,a[p],a[q]));
                    p++;
                    q--;
                    while (p < N && a[p] == a[p - 1]) p++;
                    while (q > i && a[q] == a[q + 1]) q--;
                }
                else if (total < 0) p++;
                else q--;
            }

        }
        return lst;
    }

    public static void main(String[] args) {
        int[] s = {-1, 0, 1, 2, -1, -4};
//        int [] s = {0,0,0,0};
//        int [] s = {1,-1,-1,0};
//        int [] s = {-2,0,1,1,2};
//        int[] s = {-2, 0, 0, 2, 2};
        Main m = new Main();
        List<List<Integer>> lst = m.threeSum(s);
        for (int i = 0; i < lst.size(); i++) {
            List<Integer> integers = lst.get(i);
            for (int j = 0; j < integers.size(); j++) {
                Integer integer = integers.get(j);
                System.out.print(integer + " , ");
            }
            System.out.println();
        }
    }
}
