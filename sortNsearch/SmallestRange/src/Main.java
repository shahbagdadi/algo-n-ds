import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {


    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Elem> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> nums.get(e.findex).get(e.sindex)));
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new Elem(i, 0));
            maxVal = Math.max(maxVal, nums.get(i).get(0));
        }

        int [] res = new int[]{0, Integer.MAX_VALUE};
        while (!minHeap.isEmpty()) {
            Elem curr = minHeap.poll(); int findex = curr.findex; int sindex = curr.sindex;
            int minVal = nums.get(findex).get(sindex);
            if ((maxVal - minVal) < res[1] - res[0] ||
                    (maxVal - minVal == res[1] - res[0] && minVal < res[0])) res = new int[]{minVal, maxVal};
            if (sindex == nums.get(findex).size()-1) break;
            minHeap.offer(new Elem(findex, sindex+1));
            maxVal = Math.max(maxVal, nums.get(findex).get(sindex+1));
        }
        return res;
    }

    public static void main(String[] args) {

        Main m = new Main();

        System.out.println();
    }
}
