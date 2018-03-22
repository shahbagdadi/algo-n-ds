public class Main {
    public boolean validPalindrome(String s) {
        int N = s.length() - 1;
        boolean flg = true;
        char[] a = s.toCharArray();
        for (int i = 0, j = N; i <= j; i++, j--) {
            //System.out.println(a[i] + " " + a[j]);
            if (a[i] == a[j])
                continue;
            else if (isPalindrome(a, i + 1, j) || isPalindrome(a, i, j - 1))
                return true;
            else
                return false;
        }
        return true;
    }

    private boolean isPalindrome(char[] a, int i, int j) {
        for (; i <= j; i++, j--)
            if (a[i] != a[j]) return false;
        return true;
    }

    public static void main(String[] args) {
        Main m = new Main();
        boolean b = m.validPalindrome("ebcbbececabbacecbbcbe");
        System.out.println(b);
    }
}
