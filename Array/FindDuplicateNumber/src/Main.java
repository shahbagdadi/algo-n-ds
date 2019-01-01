public class Main {

    public int findDuplicate(int[] nums) {
        int slow = nums[0],fast=nums[0];
        do
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        System.out.println("Met at " + slow + " -> " + nums[slow]);

        slow =nums[0];
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] ip = {1,3,4,2,2};
        System.out.println(m.findDuplicate(ip));
    }
}
