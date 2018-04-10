import java.util.Arrays;

public class Main {


    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, sum = 0;
        System.out.println(Arrays.toString(nums));
        int[] t = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) sum -= nums[i - k];
            if (i >= k - 1) t[i - k + 1] = sum;
        }
        System.out.println(Arrays.toString(t));

        int[] left = new int[t.length];
        int max = 0;
        for (int i = 0; i < left.length; i++) {
            if (t[i] > t[max]) {
                left[i] = i;
                max = i;
            } else
                left[i] = max;
        }
        System.out.println(Arrays.toString(left));

        int[] right = new int[t.length];
        max = t.length-1;
        for (int i = right.length - 1; i >= 0; i--) {
            if (t[i] >= t[max]) {
                right[i] = i;
                max = i;
            } else
                right[i] = max;
        }
        System.out.println(Arrays.toString(right));
        int ans[] = {-1, -1, -1};
        for (int i = k; i < t.length - k; i++) {
            int l = left[i - k];
            int r = right[i + k];
            if (ans[0] == -1 || t[l] + t[i] + t[r] > t[ans[0]] + t[ans[1]] + t[ans[2]]) {
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        Main m = new Main();
        int[] ip = {1, 2, 1, 2, 6, 7, 1, 1, 2, 9, 8};
        int[] r = m.maxSumOfThreeSubarrays(ip, 3);
        System.out.println(Arrays.toString(r));
    }
}
