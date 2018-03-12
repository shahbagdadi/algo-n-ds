public class Main {

    String countAndSay(int n) {
        String s = "1";
        if (n == 1) return s;
        for (int i = 1; i < n; i++)
            s = say(s);
        return s;
    }

    String say(String s) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        while ( i < s.length()) {
            int cnt = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j))
                    break;
                cnt++;
            }
            sb.append(cnt);
            sb.append(s.charAt(i));
            i += cnt;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Main m = new Main();
        String s = m.countAndSay(5);
        System.out.println(s);
    }
}
