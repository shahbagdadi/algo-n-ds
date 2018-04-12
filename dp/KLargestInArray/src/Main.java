import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {


    public int findKthLargestSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size()>k)
                pq.poll();
        }
        return pq.poll();
    }


    public static void main(String[] args) {
        int[] ip = {3,2,1,5,6,4};
        Main m = new Main();
        int r = m.findKthLargest(ip,2);
        System.out.println(r);
    }
}
