import java.util.Arrays;

public class Main {

    public void setZeroes(int[][] a) {
        int R = a.length, C = a[0].length, k=0;

        // Does Row 0 has a '0' ?
        while(k < C && a[0][k] != 0) k++;

        // Set top/left cell to zero if a[i][j] or a[j][i] is 0
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
               if (a[i][j] == 0)
                   a[0][j] = a[i][0] = 0;
            }
        }


        // set 0 if either a[0][j] or a[i][0] is 0
        for (int i = 1; i < R; i++) {
            for (int j = C-1; j >= 0; j--) {
                if (a[0][j] == 0 || a[i][0] == 0)
                    a[i][j] = 0;
            }
        }
        if (k < C) Arrays.fill(a[0],0);
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[][] ip =
                {{0, 1, 2, 0},
                 {3, 4, 5, 2},
                 {1, 3, 1, 5}};
        m.setZeroes(ip);
        for (int i = 0; i < ip.length; i++) {
            System.out.println(Arrays.toString(ip[i]));
        }

    }
}
