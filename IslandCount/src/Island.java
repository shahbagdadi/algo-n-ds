/**
 * Created by sbagdadi on 1/13/18.
 */
public class Island {


    private static final int[] row = {1, 1, 1, 0, -1, -1, -1, 0};
    private static final int[] col = {-1, 0, 1, 1, 1, 0, -1, -1};
    int [][] adj;

    public Island(int[][] adj){
        this.adj = adj;
    }

    private boolean isValidNode(int r, int c) {
        if (r < 0 || c < 0 || r > adj.length - 1 || c > adj[0].length - 1)
            return false;
        else
            return true;
    }

    public int getIslandCount(){
        int count = 0;
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[0].length; j++) {
                if (adj[i][j] == 1) {
                    DFS(i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void DFS(int r, int c) {
        if (isValidNode(r, c) == false ) return;
        int root = adj[r][c];
        System.out.print("[" + r + "," + c + "] ");
        adj[r][c] = 0;
        for (int rb : row) {
            for (int cb : col) {
                int rnum = r + rb;
                int cnum = c + cb;
                if (isValidNode(rnum, cnum) && adj[rnum][cnum] == 1) {
                    System.out.print("[" + rnum + "," + cnum + "] ");
                    adj[r][c] = 0;
                    DFS(rnum, cnum);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] adj = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        Island island = new Island(adj);
        System.out.println("Island count " + island.getIslandCount());
    }
}
