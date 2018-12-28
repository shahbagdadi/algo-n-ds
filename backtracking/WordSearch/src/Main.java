public class Main {
    int[][] steps = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int R = board.length;
        int C = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && exist(board, i, j, word, 0, new boolean[R][C])) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] a, int i, int j, String wd, int w, boolean[][] visited) {
        //System.out.println("i="+i + " j=" + j + " w=" + w);
        if (w == wd.length()) return true;
        if (!isValid(i, j, a) || visited[i][j]) return false;
        if (a[i][j] != wd.charAt(w)) return false;
        boolean flag = false;
        visited[i][j] = true;
        for (int[] step : steps) {
            int r = i + step[0];
            int c = j + step[1];
            flag = flag || exist(a, r, c, wd, w + 1, visited);
        }
        visited[i][j] = false;
        return flag;
    }

    private boolean isValid(int r, int c, char[][] a) {
        if (r < 0 || r >= a.length || c < 0 || c >= a[0].length)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {

        Main m = new Main();
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        //char[][] board = {{'A', 'A'}};
        System.out.println(m.exist(board, "SEED"));
    }
}
