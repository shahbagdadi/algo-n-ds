public class Main {

    private static int singleNumber(int[] nums) {
        int sum =0;
        for (int i = 0; i < nums.length; i++)
            sum ^= nums[i];
        return sum;
    }
    public static void main(String[] args) {
	// write your code here
        int[] num = new int[] {1,2,1,2,3,4,3};
        System.out.println(singleNumber(num));
    }
}
