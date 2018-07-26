import java.util.Stack;

public class Main {

    public int[] dailyTemperatures(int[] ts) {
        int[] ans = new int[ts.length];
        Stack<Integer> stk = new Stack<>();
        for (int i = ts.length - 1; i >= 0; i--) {
            while (!stk.empty() && ts[i] >= ts[stk.peek()])
                stk.pop();
            ans[i] = stk.empty() ? 0 : stk.peek() - i;
            stk.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        Main m = new Main();
        int[] ans = m.dailyTemperatures(temps);
        for (int i : ans)
            System.out.print(i + " ");
    }
}

