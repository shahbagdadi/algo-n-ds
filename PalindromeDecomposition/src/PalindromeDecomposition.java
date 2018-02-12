public class PalindromeDecomposition {

    public static void partition(String s) {
        int n = s.length();
        boolean palindrome[][] = new boolean[n][n]; //boolean table

        //Trivial case: single letter palindromes
        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
        }
        System.out.println(getPipedString(s, 0, s.length()));


        //Finding palindromes of two characters.
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindrome[i][i + 1] = true;
                System.out.print(getPipedString(s, 0, i));
                System.out.print(s.substring(i, i + 2));
                System.out.println(getPipedString(s, i + 2, s.length()));
            }
        }

        //Finding palindromes of length 3 to n
        for (int curr_len = 3; curr_len <= n; curr_len++) {
            for (int i = 0; i < n - curr_len + 1; i++) {
                int j = i + curr_len - 1;
                if (s.charAt(i) == s.charAt(j) //1. The first and last characters should match
                        && palindrome[i + 1][j - 1]) //2. Rest of the substring should be a palindrome
                {
                    palindrome[i][j] = true;
                    System.out.print(getPipedString(s,0,i));
                    System.out.print(s.substring(i, j + 1));
                    System.out.println(getPipedString(s, j + 1, s.length()));
                }
            }
        }

    }

    private static String getPipedString(String s, int i, int j) {
        StringBuffer sb = new StringBuffer();
        if (i > 0) sb.append('|');
        for (int k = i; k < j; k++) {
            sb.append(s.charAt(k));
            if (k < s.length()) sb.append('|');
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        partition("abracadabra");
        partition("banana");
        partition("tee");
    }
}
