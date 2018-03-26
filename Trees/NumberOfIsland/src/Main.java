public class Main {

    int[] rows = {1,0,-1,0};
    int[] cols = {0,1,0,-1};
    char[][] mat = null;

    public int numIslands(char[][] a) {
        int cnt =0;
        mat =a;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(a[i][j] == '1')
                {
                    cnt++;
                    dfs(i,j);
                }
            }
        }
        return cnt;
    }

    public void dfs(int r,int c)
    {
        mat[r][c] = '0';
        for (int k = 0; k < rows.length ; k++) {
            int nr = r + rows[k];
            int nc = c + cols[k];
            if (isValid(nr,nc) && mat[nr][nc] == '1')
                dfs(nr,nc);
        }
    }

    public boolean isValid(int r, int c)
    {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length)
            return false;
        else
            return true;

    }


    public static void main(String[] args) {
	char[][] mat = {{'1','1','0','0','0'},
                    {'1','1','0','0','0'},
                    {'0','0','1','0','0'},
                    {'0','0','0','1','1'}};
	Main m = new Main();
	int c = m.numIslands(mat);
        System.out.println(c);
    }
}
