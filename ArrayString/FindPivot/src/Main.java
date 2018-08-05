public class Main {


    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int s = 0, sl=0;
        for (int x : nums) s += x;

        for (int i = 0; i < nums.length; i++) {
            if (sl == s - sl - nums[i]) return i;
            sl += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

        Main m = new Main();
        System.out.println(m.pivotIndex(new int[]{1, 7, 3,6, 5, 6}));
        //System.out.println(m.pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
    }
}
