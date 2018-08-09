import java.util.Arrays;
import java.util.List;

public class Main {

    public List<Integer> getRow(int rowIndex) {
        Integer[] a = new Integer[rowIndex + 1];
        Arrays.fill(a,0);
        a[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                a[j] = a[j] + a[j-1];
            }
        }
        return Arrays.asList(a);
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.getRow(4));
    }
}
