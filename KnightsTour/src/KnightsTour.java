import java.util.LinkedList;
import java.util.Queue;

public class KnightsTour {

    static int[] rs = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] cs = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static int getMoves(int rows, int cols, int sx, int sy, int ex, int ey) {
        boolean[][] m = new boolean[rows][cols];
        Queue<Cell> q = new LinkedList<Cell>();
        m[sx - 1][sy - 1] = true;
        q.add(new Cell(sx - 1, sy - 1, 0));
        while (!q.isEmpty()) {
            Cell node = q.remove();
            int r = node.r;
            int c = node.c;
            for (int i = 0; i < rs.length; i++) {
                int nr = r + rs[i];
                int nc = c + cs[i];
                if (isValid(nr, nc, rows - 1, cols - 1) && !m[nr][nc]) {
                    //System.out.println("Visiting nr = " + nr + " nc= " + nc);
                    m[nr][nc] = true;
                    if (nr == ex - 1 && nc == ey - 1) return node.step + 1;
                    q.add(new Cell(nr, nc, node.step + 1));
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int r, int c, int rows, int cols) {
        if (r < 0 || r > rows || c < 0 || c > cols)
            return false;
        return true;
    }


    public static void main(String[] args) {
        int mv = getMoves(6, 6, 2, 4, 6, 1);
        System.out.println(mv);
    }
}
