public class Main {

    public boolean isValidSudoku(char[][] b) {
        int l = b.length - 1;
        for (int r = 0; r < l; r++) {
            boolean[] v = new boolean[b.length];
            for (int c = 0; c < b[0].length-1; c++) {
                if (b[r][c] == '.')
                    continue;
                if (v[Character.getNumericValue(b[r][c])-1])
                    return false;
                else
                    v[Character.getNumericValue(b[r][c])-1] = true;
            }
        }

        for (int c = 0; c < b[0].length-1; c++) {
            boolean[] v = new boolean[b.length];
            for (int r = 0; r < l; r++) {
                if (b[r][c] == '.')
                    continue;
                if (v[Character.getNumericValue(b[r][c])-1])
                    return false;
                else
                    v[Character.getNumericValue(b[r][c])-1] = true;
            }
        }


        for (int i=0, z=1; z<=3 ; z++, i++) {
            boolean[] v = new boolean[10];
            for (int j=0, r = i*z; r < 3 * z; r++, j++) {
                for (int c = j* z; c < 3 * z; c++) {
                    if (b[r][c] == '.')
                        continue;
                    if (v[Character.getNumericValue(b[r][c])-1])
                        return false;
                    else
                        v[Character.getNumericValue(b[r][c])-1] = true;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {
                        '.', '8', '7', '6', '5', '4', '3', '2', '1'
                },
                {
                        '2', '.', '.', '.', '.', '.', '.', '.', '.'
                },
                {
                        '3', '.', '.', '.', '.', '.', '.', '.', '.'
                },
                {
                        '4', '.', '.', '.', '.', '.', '.', '.', '.'
                },
                {
                        '5', '.', '.', '.', '.', '.', '.', '.', '.'
                },
                {
                        '6', '.', '.', '.', '.', '.', '.', '.', '.'
                },
                {
                        '7', '.', '.', '.', '.', '.', '.', '.', '.'
                },
                {
                        '8', '.', '.', '.', '.', '.', '.', '.', '.'
                },
                {
                        '9', '.', '.', '.', '.', '.', '.', '.', '.'
                }
        };

        char[][] board2 = new char[][]{
                {'.','.','5','.','.','.','.','.','6'},
                {'.','.','.','.','1','4','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','9','2','.','.'},
                {'5','.','.','.','.','2','.','.','.'},
                {'.','.','.','.','.','.','.','3','.'},
                {'.','.','.','5','4','.','.','.','.'},
                {'3','.','.','.','.','.','4','2','.'},
                {'.','.','.','2','7','.','6','.','.'}};
        Main m = new Main();
        System.out.println(m.isValidSudoku(board2));
    }
}
