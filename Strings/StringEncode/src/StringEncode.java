public class StringEncode {

    public static void main(String[] args) {
        String s = "aaabbbcc";
        String se = encode(s);
        System.out.println(se);
    }

    private static String encode(String s) {
        StringBuffer sb = new StringBuffer();
        int N = s.length();
        for (int i = 0; i < N; i++) {
            char p = s.charAt(i);
            int cnt = 1;
            for (int j = i+1; j < N && s.charAt(j) == p; j++, i++)
                cnt++;
            sb.append(p);
            if (cnt > 1)
                sb.append(cnt);
        }
        return sb.toString();
    }
}
