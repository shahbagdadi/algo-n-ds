import java.util.Arrays;
import java.util.LinkedList;


public class Main {

    int[][] steps = {{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] a) {
        int R = a.length;
        int C = a[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        for (int c = 0; c < C; c++) {
            if (a[0][c] == 'O') q.offer(new int[] {0,c});
            if (a[R-1][c] == 'O') q.offer(new int[] {R-1,c});
        }
        for (int r = 0; r < R; r++) {
            if (a[r][0] == 'O') q.offer(new int[] {r,0});
            if (a[r][C-1] == 'O') q.offer(new int[] {r,C-1});
        }

        while(!q.isEmpty())
        {
            int[] cell = q.poll();
            System.out.println("cell " + cell[0] + " " + cell[1]);
            a[cell[0]][cell[1]] = '-';
            for (int[] step : steps) {
                int nr = cell[0] + step[0];
                int nc = cell[1] + step[1];
                if (isValid(a,nr,nc) && a[nr][nc] == 'O')
                    q.offer(new int[]{nr,nc});
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (a[i][j] == '-') a[i][j] = 'O';
                else if (a[i][j] == 'O') a[i][j] = 'X';
            }
        }
    }

    private boolean isValid(char[][] a, int nr, int nc) {
        if (nr < 0 || nr >= a.length || nc <0 || nc >= a[0].length) return false;
        return true;
    }

    public static void main(String[] args) {

        Main m = new Main();
        char[][] board = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        m.solve(board);
        for (char[] a : board)
            System.out.println(Arrays.toString(a));
    }
}
