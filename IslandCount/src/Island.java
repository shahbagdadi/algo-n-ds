/**
 * Time - O(m*n)
 * Space - O(n) - the size of longest island
 */
public class Island {

    private static final int[][] steps = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private boolean isValidNode(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return false;
        return true;
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    //System.out.println("root - " + i + "," + j);
                    DFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }


    private void DFS(char[][] grid, int r, int c) {
        grid[r][c] = 0;
        for (int[] step : steps) {
            int row = r + step[0];
            int col = c + step[1];
            if (isValidNode(grid, row, col) && grid[row][col] == '1') {
                //System.out.print("[" + row + "," + col + "] ");
                grid[row][col] = 0;
                DFS(grid, row, col);
            }
        }
    }

    public static void main(String[] args) {
        char l = '1';
        char w = '0';
        char[][] adj = {
                {l, l, w, w, w},
                {w, l, w, w, l},
                {l, w, w, l, l},
                {w, w, w, w, w},
                {l, w, l, w, l}
        };
        Island island = new Island();
        int cnt = island.numIslands(adj);
        System.out.println("Island count " + cnt);
    }
}
