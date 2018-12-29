public class Main {

    // T - O(m+n)   S - O(1)
    public boolean searchMatrix(int[][] a, int t) {
        if (a == null || a.length == 0 || a[0].length == 0) return false;
        int r = 0, c = a[0].length-1;
        while ( r < a.length && c >= 0)
        {
            if (a[r][c] == t) return true;
            else if (a[r][c] > t)
                c--;
            else
                r++;
        }
        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[][] ip = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(m.searchMatrix(ip,21));
    }
}
