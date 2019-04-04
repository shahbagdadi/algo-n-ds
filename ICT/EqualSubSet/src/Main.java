import java.util.Arrays;

public class Main {

    boolean equalSubset(int[] a)
    {
        // For it to be equal it has to be divisible by 2
        int sum =0;
        for (int n: a)
            sum += n;
        System.out.println("Sum = " + sum);
        if (sum % 2 != 0) return false;

        // n/2 sum should exist for the partition
        sum /= 2;
        return findSum(a,sum,0);
    }

    private boolean findSum(int[] a, int sum, int i) {
        if (i == a.length) return false;
        if (sum == 0) return true;
        return findSum(a,sum - a[i], i+1) || findSum(a,sum,i+1);
    }

    public static void main(String[] args) {

        Main m = new Main();
        int [] a = {5,5,5,6,7,2};
        System.out.println(m.equalSubset(a));
    }
}
