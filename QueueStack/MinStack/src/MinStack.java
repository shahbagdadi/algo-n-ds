import java.util.Stack;

public class MinStack {

    private Stack<Integer> stk;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        stk = new Stack<>();
    }

    public void push(int x) {
        if (x <= min) {
            stk.push(min);
            min = x;
        }
        stk.push(x);
    }

    public void pop() {
        if (stk.pop() == min)
            min = stk.pop(); // double pop for min
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); //  --> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());    //  --> Returns 0.
        minStack.getMin();
    }
}
