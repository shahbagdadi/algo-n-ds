public class Main {

    public int bestPathMax(int[][] matrix)
    {
        return helper(matrix,0,0);
    }

    public int helper(int[][] a, int r, int c)
    {
        if (r == a.length || c == a[0].length) return 0;
        return Integer.max(a[r][c] + helper(a,r+1,c) , a[r][c] + helper(a,r,c+1));
    }
    public static void main(String[] args) {
        Main m = new Main();
        int[][] mat1 = new int[][]{{2,5},{1,3},{4,2}};
        int[][] mat2 = new int[][]{{6,2,4},{3,5,2},{1,3,1}};
        System.out.println(m.bestPathMax(mat1));
        System.out.println(m.bestPathMax(mat2));
    }
}
