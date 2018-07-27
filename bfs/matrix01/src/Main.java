import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int[][] steps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] m) {
        Queue<int[]> q = new LinkedList<>();
        int row = m.length;
        int col = m[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (m[i][j] == 0)
                    q.offer(new int[]{i, j});
                else
                    m[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int[] step : steps) {
                int r = p[0] + step[0];
                int c = p[1] + step[1];
                if (r < 0 || r >= m.length || c < 0 || c >= m[0].length || m[r][c] <= m[p[0]][p[1]])
                    continue;
                m[r][c] = m[p[0]][p[1]] + 1;
                q.offer(new int[]{r, c});
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[][] ip = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        Main m = new Main();
        int[][] ans = m.updateMatrix(ip);
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));
    }
}
