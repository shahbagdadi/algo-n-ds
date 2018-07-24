import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int[][] steps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final List<int[]> moves = Arrays.asList(steps);


    private boolean isValid(int[][] rooms, int row, int col) {
        if (row < 0 || col < 0 || row >= rooms.length || col >= rooms[0].length || rooms[row][col] != EMPTY)
            return false;
        return true;
    }

    public void wallsAndGates(int[][] grid) {
        if (grid.length == 0) return;
        Queue<int[]> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0)
                    q.offer(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            //System.out.println("Gate : " + p[0] + "," + p[1]);
            for (int[] move : moves) {
                int row = p[0] + move[0];
                int col = p[1] + move[1];
                if (isValid(grid, row, col)) {
                    //System.out.println(" processing " + row + "," + col);
                    grid[row][col] = grid[p[0]][p[1]] + 1;
                    q.offer(new int[]{row,col});
                }

            }
        }

    }

    public static void main(String[] args) {
        Main m = new Main();
        int INF = Integer.MAX_VALUE;
	    int[][] grid = new int[][]{
	            {INF,-1,0,INF},
                {INF,INF,INF,-1},
                {INF,-1,INF,-1},
                {0,-1,INF,INF}};
	    m.wallsAndGates(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }


    }
}
