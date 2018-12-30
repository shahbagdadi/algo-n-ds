import java.util.Arrays;

public class Main {

    public boolean canJump(int[] a) {
        int pos = a.length - 1;
        for (int i = pos; i >= 0; i--) {
            if (i + a[i] >= pos)
                pos = i;
        }
        return pos == 0;
    }

    public static void main(String[] args) {

        Main m = new Main();
        //int[] a = {2,3,1,1,4};
        int[] a = {3, 2, 1, 0, 4};
        System.out.println(m.canJump(a));
    }
}
