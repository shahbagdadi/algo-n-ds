import java.util.Stack;

public class Main {
    public boolean isValid(String s) {
        char[] a = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            char c = a[i];
            if (c == '[' || c == '{' || c == '(')
                stk.push(c);
            else if (stk.isEmpty())
                return false;
            else {
                char sc = stk.pop();
                if (sc != '[' && c == ']') return false;
                if (sc != '{' && c == '}') return false;
                if (sc != '(' && c == ')') return false;
            }
        }
        if (stk.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String s = "[]({)}";
        Main m = new Main();
        boolean b = m.isValid(s);
        System.out.println(b);
    }
}
