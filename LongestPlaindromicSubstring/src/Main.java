public class Main {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                //System.out.println(len);
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String str, int s, int e) {
        int len = 0;
        while (s >= 0 && e < str.length() && str.charAt(s--) == str.charAt(e++))
            len = e - s;
        return len - 1;
    }


    public static void main(String[] args) {
        Main m = new Main();
        String s = m.longestPalindrome("abacdgdcaba");
        System.out.println(s);
    }
}
