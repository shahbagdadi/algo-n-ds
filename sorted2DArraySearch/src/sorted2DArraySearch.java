public class sorted2DArraySearch {

    public static boolean findElement(int[][] m, int s) {
        int N = m.length;
        int M = m[0].length;
        int i = 0;
        int j = M - 1;
        while (i < N && j >= 0) {
            if (m[i][j] == s) {
                System.out.println("Found " + s + " at " + i + "," + j);
                return true;
            }
            if (s < m[i][j])
                j--;
            else
                i++;
        }
        System.out.println("Not Found");
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]
                {
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                };
        findElement(input,18);// O(M+N)
    }
}
