import java.util.ArrayList;
import java.util.List;

public class Main {


    public List<String> removeInvalidParentheses(String s) {
        List<String> l = new ArrayList<>();
        char[] dl = new char[]{'(', ')'};
        backTrack(l, s, 0, 0, dl);
        return l;
    }

    private void backTrack(List<String> l, String s, int last_i, int last_j, char[] dl) {
        int cnt = 0;
        for (int i = last_i; i < s.length(); i++) {

            if (s.charAt(i) == dl[0]) cnt++;
            if (s.charAt(i) == dl[1]) cnt--;
            if (cnt >= 0) continue;

            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == dl[1] && (j == last_j || s.charAt(j - 1) != dl[1]))
                    backTrack(l, s.substring(0, j) + s.substring(j + 1, s.length()), i, j, dl);
            }
            return;
        }
        // reverse for ')'
        StringBuilder sb = new StringBuilder(s).reverse();
        String rs = sb.toString();
        if (dl[0] == '(')
            backTrack(l, rs, 0, 0, new char[]{')', '('});
        else
            l.add(rs);
    }


    public static void main(String[] args) {
        Main m = new Main();
        List<String> lst = m.removeInvalidParentheses("()())()");
        for (int i = 0; i < lst.size(); i++)
            System.out.println(lst.get(i));
    }
}
