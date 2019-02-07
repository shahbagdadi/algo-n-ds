import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    // T - O(n^2)    S - O(n)
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() { // sort by decreasing height
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1]; // if height equal return with lower k first
                return b[0] - a[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int[] p : people)
            res.add(p[1], p); // Insert this person at kth position O(n^2)

        return res.toArray(new int[0][0]); // return an array of type int[][]
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[][] ip = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ans = m.reconstructQueue(ip);
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));
    }
}
