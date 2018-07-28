import java.util.LinkedList;
import java.util.Queue;

public class KnightsTour {

    private static final int[][] steps = new int[][] {{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1}};

    public static int getMoves(int rows, int cols, int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[rows][cols];
        int cnt =0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx - 1, sy - 1});
        q.offer(null);
        while (!q.isEmpty()) {
            int[] node = q.poll();
            if (node == null)
            {
                if (q.peek() != null) q.offer(null);
                cnt++;
                continue;
            }
            visited[node[0]][node[1]] = true;
            int r = node[0];
            int c = node[1];
            if (r == ex - 1 && c == ey - 1) return cnt;
            for (int[] step: steps) {
                int nr = r + step[0];
                int nc = c + step[1];
                if (isValid(nr, nc, rows - 1, cols - 1) && !visited[nr][nc]) {
//                    System.out.println("Visit [" + (nr+1) + "," + (nc+1) + "]");
                    q.offer(new int[]{nr,nc});
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
