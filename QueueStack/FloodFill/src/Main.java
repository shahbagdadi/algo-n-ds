import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int[][] steps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<int[]> q = new LinkedList<>();
        int color = image[sr][sc];
        q.offer(new int[]{sr, sc});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            visited[p[0]][p[1]] = true;
            image[p[0]][p[1]] = newColor;
            for (int[] step : steps) {
                int r = p[0] + step[0];
                int c = p[1] + step[1];
                if (isValid(image, r, c, color) && !visited[r][c])
                    q.offer(new int[]{r, c});
            }
        }
        return image;
    }

    private boolean isValid(int[][] image, int r, int c, int color) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != color)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        Main m = new Main();
        int[][] ans = m.floodFill(image, 1, 1, 2);
        for (int[] r : ans) {
            for (int i:r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
