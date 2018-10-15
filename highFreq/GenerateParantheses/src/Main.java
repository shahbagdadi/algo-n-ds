import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String tmp, int open, int close, int max) {
        if (tmp.length() == 2 * max) {
            ans.add(tmp);
            return;
        }
        if (open < max)
            backtrack(ans, tmp + "(", open + 1, close, max);

        if (close < open)
            backtrack(ans, tmp + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        Main m = new Main();
        List<String> lst = m.generateParenthesis(3);
        for (String s : lst)
            System.out.println(s);
    }
}
