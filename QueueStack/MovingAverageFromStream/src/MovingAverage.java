public class MovingAverage {
    double sum = 0;
    int cnt =0;
    int size;
    int[] a;
    int tail;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        a = new int[size];
    }

    public double next(int val) {
        if (cnt < size)
            cnt++;
        else
            sum -= a[tail];
        sum += val;
        a[tail] = val;
        tail = (tail+1) % size;
        return sum/cnt;
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
        System.out.println(m.next(2));
    }
}
