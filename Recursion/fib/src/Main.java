public class Main {


    public int fib(int n)
    {
        if (n <= 1) return n;
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.fib(6));
    }
}
