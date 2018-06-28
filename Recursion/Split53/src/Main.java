public class Main {

    public boolean split53(int[] nums) {
        return helper(nums,0,0,0);
    }

    public boolean helper(int[] nums, int start, int group1, int group2)
    {
        if (start >= nums.length) return (group1 == group2);
        int v = nums[start];
        if (v % 5 == 0) return helper(nums,start+1,group1 + v, group2);
        else if (v % 3 == 0 ) return helper(nums,start+1,group1 , group2 + v);
        else return helper(nums,start+1,group1 +v , group2) || helper(nums,start+1,group1 , group2 +v);

    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        System.out.println(m.split53(new int[]{1,1,1}));
    }
}
