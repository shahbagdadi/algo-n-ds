public class Main {


    public int sum(int[][] a, int r, int c)
    {
        if (r > a.length -1 || c > a[0].length -1) return 0;
        return  Integer.max(a[r][c] + sum(a,r+1,c),
                a[r][c] +sum(a,r,c+1));
    }

    public static void main(String[] args) {

        Main m = new Main();
        //int[][] a = {{2,1,3,1,3},{1,2,4,2,1},{2,3,1,2,1},{2,4,2,4,2},{1,2,1,2,5}};
        int[][] a = {{1,2,1},{2,3,2},{4,2,1}};
        System.out.println(m.sum(a,0,0));
    }
}
