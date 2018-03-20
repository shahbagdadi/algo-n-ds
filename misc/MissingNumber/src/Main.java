public class Main {

    public int missingNumber(int[] nums) {
        int sum = 0, total = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            total += i;
        }
        return total - sum;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] a = new int[]{0, 3, 4,2,1};
        int n = m.missingNumber(a);
        System.out.println(n);
    }
}
