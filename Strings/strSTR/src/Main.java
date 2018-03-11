public class Main {

    public int strStr(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() > s1.length())
            return -1;
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            if (s1.substring(i,i+ s2.length()).equals(s2))
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        Main m = new Main();
        int n = m.strStr(haystack,needle);
        System.out.println(n);
    }
}
