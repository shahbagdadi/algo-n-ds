import java.util.Arrays;

public class Main {
    int[][] steps = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int ln = getLiveNeighbors(board,i,j);
                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1 && ln >= 2 && ln <= 3) {
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && ln == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }
        for(int i=0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
    }

    private int getLiveNeighbors(int[][] a,int r,int c)
    {
        int cnt =0;
        for (int[] step : steps) {
           int nr = r + step[0];
           int nc = c + step[1];
           if (isValid(a,nr,nc) && (a[nr][nc] & 1) == 1)
               cnt++;
        }
        return cnt;
    }

    private boolean isValid(int[][] a, int nr, int nc) {
        if (nr < 0 || nr > a.length-1 || nc < 0 || nc > a[0].length-1)
            return false;
        return true;
    }


    public static void main(String[] args) {

        Main m = new Main();
        int[][] board = {{0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}};
        m.gameOfLife(board);
        for (int[] b : board) {
            System.out.println(Arrays.toString(b));
        }

    }
}
