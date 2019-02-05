import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    PriorityQueue<Integer> minq;
    PriorityQueue<Integer> maxq;
    public Main() {
        minq = new PriorityQueue<>();
        maxq = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxq.add(num);
        minq.add(maxq.poll());
        if (maxq.size() < minq.size())
            maxq.add(minq.poll());
    }

    public double findMedian() {
        if (maxq.size() == minq.size())
            return (maxq.peek() + minq.peek()) / 2.0;
        else
            return maxq.peek();
    }

    public static void main(String[] args) {

        Main m = new Main();
        m.addNum(1);
        System.out.println(m.findMedian());
        m.addNum(10);
        System.out.println(m.findMedian());
        m.addNum(5);
        System.out.println(m.findMedian());
    }
}
