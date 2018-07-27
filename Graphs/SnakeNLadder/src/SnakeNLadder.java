import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeNLadder {

    private final int[] board;

    public SnakeNLadder(int[] board)
    {
        this.board = board;
    }

    private int getMinDice(int dest) {
        LinkedList<BoardSpot> q = new LinkedList<BoardSpot>();
        int [] visited = new int[board.length];
        BoardSpot start = new BoardSpot(0);
        start.path.add(String.valueOf(1));
        visited[0] = 1;
        q.add(start);
        while (!q.isEmpty()){
            BoardSpot spot = q.remove();
            for ( int p = spot.pos +1 ; p <= spot.pos+ 6 && p <= board.length ; p ++)
            {
                if (p == dest)
                {
                    System.out.print("Path : ");
                    for (String s : spot.path)
                        System.out.print(s + " " );
                    System.out.println(p);
                    return spot.dist +1;
                }
                if (visited[p] == 0)
                {
                    visited[p] = 1;
                    BoardSpot sp = new BoardSpot(p);
                    sp.dist = spot.dist +1;
                    sp.path.addAll(spot.path);
                    sp.path.add(String.valueOf(p));
                    if (board[p] > 0) {
                        sp.pos = board[p];
                        sp.path.add("=> " + String.valueOf(board[p]));
                    }
                    q.add(sp);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 30;
        int board[] = new int[N];

        // Ladders
        board[3] = 22;
        board[5] = 8;
        board[11] = 26;
        board[20] = 29;

        // Snakes
        board[27] = 1;
        board[21] = 9;
        board[19] = 7;
        board[17] = 4;

        SnakeNLadder snl = new SnakeNLadder(board);
        int cnt = snl.getMinDice(30);
        System.out.println("Minimum Steps : " + cnt);
    }

}
