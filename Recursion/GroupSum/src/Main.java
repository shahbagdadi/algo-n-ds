public class Main {


    public boolean groupSum(int start, int[] nums, int target) {
        if (nums.length <= start) return (target == 0);
        return (groupSum(start+1,nums,target-nums[start]) || groupSum(start+1,nums,target));
    }

    public static void main(String[] args) {

        Main m = new Main();

        System.out.println(m.groupSum(1, new int[]{2, 4, 8}, 8));
    }
}
