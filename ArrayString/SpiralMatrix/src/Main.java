import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final int[][] steps = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    private int RIGHT = 0,DOWN = 1, LEFT = 2 , UP = 3;

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new LinkedList<Integer>();
        int cnt = 0 , r =0, c=0, m = matrix.length, n = matrix[0].length, rmin=0 , rmax=m-1, cmin=0, cmax= n-1;
        int dir = RIGHT;
        List<Integer> lst = new LinkedList<>();
        while (cnt < m*n) {
           // System.out.print(matrix[r][c] + " " );
            lst.add(matrix[r][c]);
            cnt++;
            r += steps[dir][0];
            c += steps[dir][1];

            if (c > cmax){
                dir = DOWN;
                c = cmax;
                r += steps[dir][0];
                rmin += 1;
            }
            else if (r > rmax) {
                dir = LEFT;
                r = rmax;
                c += steps[dir][1];
                cmax += -1;
            }
            else  if ( c < cmin) {
                dir = UP;
                c = cmin;
                r += steps[dir][0];
                rmax += -1;
            }
            else  if ( r < rmin) {
                dir = RIGHT;
                r = rmin;
                c += steps[dir][1];
                cmin += 1;
            }
           // System.out.println(r + " " + c + "  dir=" + dir );
        }
        return lst;
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[][] ip = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> lst = m.spiralOrder(ip);
        System.out.println(Arrays.toString(lst.toArray()));
    }
}
