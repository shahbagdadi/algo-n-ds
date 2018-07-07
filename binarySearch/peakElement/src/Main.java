public class Main {

    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            int m1 = m + 1;
            if (nums[m] < nums[m1])
                l = m1;
            else
                h = m;
        }
        return l;
    }

    public static void main(String[] args) {
        // write your code here
        Main m = new Main();
        System.out.println("m = " + m.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println("m = " + m.findPeakElement(new int[]{1, 2, 3, 1}));
    }
}
