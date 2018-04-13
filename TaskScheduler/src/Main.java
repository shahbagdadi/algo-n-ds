import java.util.Arrays;

public class Main {


    public int leastInterval(char[] tasks, int n) {
        int[] t = new int[26];
        for (char c : tasks)
            t[c - 'A']++;
        Arrays.sort(t);
        int mt = t[25] - 1;
        int it = mt * n;
        for (int i = 24; i > 0; i--)
            it -= Math.min(t[i], mt);

        return (it > 0) ? tasks.length + it : tasks.length;
    }

    public static void main(String[] args) {
        char[] c = {'A', 'A', 'A', 'B', 'B', 'B'};
        Main m = new Main();
        int r = m.leastInterval(c, 2);
        System.out.println(r);
    }
}
