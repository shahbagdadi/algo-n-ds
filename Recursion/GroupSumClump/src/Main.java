public class Main {

    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length)
            return target == 0;

        int i = start;
        int sum = 0;

        while (i < nums.length && nums[start] == nums[i]) {
            sum += nums[i];
            i++;
        }

        if (groupSumClump(i, nums, target - sum))
            return true;

        if (groupSumClump(i, nums, target))
            return true;

        return false;
    }

    public static void main(String[] args) {

        Main m = new Main();

        System.out.println(m.groupSumClump(0, new int[] {8, 2, 2, 1}, 11));
    }
}
