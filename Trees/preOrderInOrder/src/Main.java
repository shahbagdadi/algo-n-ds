import java.util.Stack;

public class Main {


    public int[] inOrder(int[] a) {
        Stack<Integer> stk = new Stack<>();
        int i =1, j=0;
        int[] ans = new int[a.length];
        stk.push(a[0]);
        while (!stk.empty() || i < a.length)
        {
            if (stk.empty())
                stk.push(a[i++]);
            else
            {
                if (i < a.length && a[i] < stk.peek())
                    stk.push(a[i++]);
                else
                {
                    ans[j] = stk.pop();
                    //System.out.println(a[j]);
                    j++;
                }
            }
        }
        return ans;
    }




    public static void main(String[] args) {

        Main m = new Main();
        int[] ip = new int[]{8, 3, 1, 6, 4, 7, 10, 14, 13};
        int[] op = m.inOrder(ip);
        for (int i : op)
            System.out.print(i + " , ");
    }
}
