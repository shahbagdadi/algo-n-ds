import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Main {

    // T - O(l) l- number of logs
    // S - O(n) n - number of functions
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];
        int prev = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            int time = Integer.parseInt(parts[2]);
            if (!stk.empty())
                ans[stk.peek()] += time - prev;

            prev = time;
            if (parts[1].equals("start"))
                stk.push(Integer.parseInt(parts[0]));
            else {
                ans[stk.pop()]++;
                prev++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Main m = new Main();
        List<String> logs = Arrays.asList(new String[]
                {"0:start:0", "1:start:2", "1:end:5", "0:end:6" });
        int[] res = m.exclusiveTime(2, logs);
        System.out.println(Arrays.toString(res));
    }
}
