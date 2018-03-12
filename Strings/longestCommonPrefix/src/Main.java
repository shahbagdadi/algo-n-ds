public class Main {


    public String longestCommonPrefix(String[] a) {
        if (a == null || a.length==0 ) return "";
        String s1 = a[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            for (int j = 0; j < a.length ; j++) {
                if (i > a[j].length()-1 || a[j].charAt(i) != c)
                    return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        //String[] strs = new String[]{"bad", "badge", "ban","ball"};
        String[] strs = new String[]{"aa", "a"};
        Main m = new Main();
        String ps = m.longestCommonPrefix(strs);
        System.out.println(ps);
    }
}
