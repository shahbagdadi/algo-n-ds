import java.util.Stack;

public class Main {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+")) stk.push(stk.pop() + stk.pop());
            else if (t.equals("-")) {
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b - a);
            } else if (t.equals("*")) stk.push(stk.pop() * stk.pop());
            else if (t.equals("/")) {
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b / a);
            } else
                stk.push(Integer.parseInt(t));
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        Main m = new Main();
        String[] ip = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(m.evalRPN(ip));
    }
}
