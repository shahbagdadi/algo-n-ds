import java.util.Arrays;

public class Main {

    // T - O(n)   S - O(1)
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;

        // for any item i it is the product of left side and right side elements.
        // store product of left side elements up to i in ans
        for (int i = 1; i < nums.length; i++)
            ans[i] = nums[i-1] * ans[i-1];

        // product of right side elements
        int rp = 1;
        for (int j = nums.length -1 ; j >=0 ; j--) {
            ans[j] = rp * ans[j];
            rp = rp * nums[j];
        }
        return ans;
    }


    public static void main(String[] args) {
        Main m = new Main();
        int[] op = m.productExceptSelf(new int[]{2,3,4,5});
        System.out.println(Arrays.toString(op));
    }
}
