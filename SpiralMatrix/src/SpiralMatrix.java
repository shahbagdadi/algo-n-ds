
/**
 * Created by sbagdadi on 1/20/18.
 */
public class SpiralMatrix {


    public static void main(String[] args) {
        char mat[][] = {{'X', 'Y', 'A'},
                        {'M', 'B', 'C'},
                        {'P', 'Q', 'R'}};
//        char mat[][] = {{'A', 'B', 'C'},
//                        {'L', 'M', 'D'},
//                        {'K', 'N', 'E'},
//                        {'J', 'O', 'F'},
//                        {'I', 'H', 'G'}};
        int r = 0, c = 0, cnt = 0, rl = 0, cl = 0;
        int rh = mat.length - 1;
        int ch = mat[0].length - 1;
        int total = (rh + 1) * (ch + 1);


        while (true) {
            for (c = cl; c < ch && cnt < total; c++, cnt++)
                System.out.print(mat[r][c]);
            for (r = rl; r < rh && cnt < total; r++, cnt++)
                System.out.print(mat[r][c]);

            // write bottom right most pivot node
            if (cnt < total) {
                System.out.print(mat[r][c]);
                cnt++; ch--; rl++;
            }

            for (c = ch; c > cl && cnt < total; c--, cnt++)
                System.out.print(mat[r][c]);
            for (r = rh; r > rl && cnt < total; r--, cnt++)
                System.out.print(mat[r][c]);

            // write the top left most pivot node
            if (cnt < total) {
                System.out.print(mat[r][c]);
                cnt++; rh--; cl++;
            }
            else
                break;

        }
    }




}

