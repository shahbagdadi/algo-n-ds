public class NQueens {
    class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private Position[] solveNQueens(int n) {
        Position[] pos = new Position[n];
        pos = (helper(n, 0, pos)) ? pos : null;
        return pos;
    }

    private boolean helper(int n, int row, Position[] pos) {
        if (n == row)
            return true;
        for (int col = 0; col < n; col++) {
            boolean safe = true;
            // find a safe spot w.r.t previous row queens
            for (int i = 0; i < row; i++) {
                Position po = pos[i];
                if (po.col == col || row - col == po.row - po.col || row + col == po.row + po.col) {
                    safe = false;
                    break;
                }
            }
            if (safe) {
                Position ps = new Position(row, col);
                pos[row] = ps;
                if (helper(n, row + 1, pos))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        NQueens queens = new NQueens();
        Position[] pos = queens.solveNQueens(5);
        if (pos != null) {
            for (int i = 0; i < pos.length; i++) {
                Position po = pos[i];
                System.out.println("Queen " + i + "[ " + po.row + " , " + po.col + " ]");
            }
        } else
            System.out.println("No Solution");
    }
}
