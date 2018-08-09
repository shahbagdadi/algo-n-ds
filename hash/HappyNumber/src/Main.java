import java.util.HashSet;

public class Main {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            int sum = 0;
            while (n > 0) {
                int i = n % 10;
                sum += i * i;
                n /= 10;
            }
            System.out.println(sum);
            if (sum == 1 ) return true;
            else if (set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.isHappy(19));
    }
}
