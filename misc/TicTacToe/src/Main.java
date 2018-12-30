public class Main {

    char[][] a;
    /** Initialize your data structure here. */
    public Main(int n) {
        a = new char[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        a[row][col] = (player == 1) ? 'X' : '0';
        return won(row,col,player);
    }

    private int won(int row, int col, int player) {
        char ch = (player == 1) ? 'X' : '0';
        boolean r= true,c= true, d1= true, d2= true;
        for (int i = 0, j=a.length-1; i < a.length ; i++,j--) {
            if (a[i][col] != ch) c = false;
            if (a[row][i] != ch) r = false;
            if (a[i][i] != ch) d1 = false;
            if (a[j][i] != ch) d2 = false;
        }
        return  (r || c || d1 || d2) ? player : 0;
    }

    public static void main(String[] args) {

        Main m = new Main(3);
        System.out.println(m.move(0,0,1));
        System.out.println(m.move(0, 2, 2));
        System.out.println(m.move(2, 2, 1));
        System.out.println(m.move(1, 1, 2));
        System.out.println(m.move(2, 0, 1));
        System.out.println(m.move(1, 0, 2));
        System.out.println(m.move(2, 1, 1));

    }
}
