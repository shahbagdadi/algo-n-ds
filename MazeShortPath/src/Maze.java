import java.util.ArrayList;

/**
 * Created by sbagdadi on 1/20/18.
 */
public class Maze {

    private final static int Row[] = {1,0,-1,0};
    private final static int Col[] = {0,1,0,-1};
    boolean visited[][];
    int [][] mat;
    class Node{
        int r,c, dist;
        Node(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public Maze(int[][] mat)
    {
        this.mat = mat;
        this.visited = new boolean[mat.length][mat[0].length];
    }


     boolean isValid( int row, int col) {
        if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length || mat[row][col]== 0)
            return false;
        return true;
    }


    public int bfsCountMinPath(int[][] mat, int si, int sj, int di, int dj) {
        if (si == di && sj == dj) return 0;
        ArrayList<Node> q = new ArrayList<Node>();
        visited[si][sj] = true;
        Node root = new Node(si,sj,0);
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove(0);
            for (int i = 0; i < Row.length; i++) {
                int newRow =  node.r + Row[i];
                int newCol = node.c + Col[i];
                if (isValid(newRow,newCol) && ! visited[newRow][newCol])
                {
                    visited[newRow][newCol]= true;
                    //System.out.println("visiting " + newRow + " , " + newCol);
                    if (newRow == di && newCol == dj) return node.dist+1;
                    q.add(new Node(newRow,newCol,node.dist + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int mat[][] =  {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};

        Maze m = new Maze(mat);
        int count = m.bfsCountMinPath(mat, 0, 0, 3, 4);
        System.out.println(count);
    }

}
