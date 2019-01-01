import java.util.Arrays;

public class Main {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int k = separatePositives(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(k);
        for (int i = 0; i <= k; i++) {
            int t = Math.abs(nums[i]) - 1;
            if (t <= k)
                nums[t] = (nums[t] < 0) ? nums[t] : -1 * nums[t];
        }
        System.out.println(Arrays.toString(nums));
        int i = 0;
        for (; i <= k; i++)
            if (nums[i] > 0) break;

        return i + 1;
    }

    private int separatePositives(int[] a) {
        int n=a.length;
        int q=-1;
        for(int i=0;i<n;i++){
            if(a[i]>0){
                q++;
                swap(a,q,i);
            }
        }
        return q;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static void main(String[] args) {

        Main m = new Main();
        //int[] a = {3, 4, -1, 1};
        int[] a = {0,0};
        System.out.println(m.firstMissingPositive(a));
    }
}
