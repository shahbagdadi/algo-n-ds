import java.util.Arrays;

/**
 * Time - O(N!) - where n is number of characters
 * Space - O(N) - where n is number of characters
 */
public class Main {

    public void backtrack(char[] a, int i) {
        if (i == a.length) {
            System.out.println(Arrays.toString(a));
        } else {
            for (int j = i; j < a.length; j++) {
                swap(a, i, j);
                backtrack(a, i + 1);
                swap(a, i, j);
            }
        }
    }

    void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Main m = new Main();
        char[] ca = {'a', 'b', 'c'};
        m.backtrack(ca, 0);
    }
}
