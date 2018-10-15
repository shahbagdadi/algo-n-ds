public class Main {

    public String licenseKeyFormatting(String S, int K) {
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                if (cnt == K) {
                    sb.append('-');
                    cnt = 0;
                }
                sb.append(Character.toUpperCase(S.charAt(i)));
                cnt++;

            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "--2---5g-3-J--";
        Main m = new Main();
        System.out.println(m.licenseKeyFormatting(s, 2));
    }
}
