public class Main {

    public int search(int[] nums, int target) {
        // find the pivot
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (nums[m] > nums[h])
                l = m + 1;
            else
                h = m;
        }
//        System.out.println("rotation at " + l);
        int rot = l;
        l = 0;
        h = nums.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            int rm = (m + rot) % nums.length;
            if (nums[rm] == target) return rm;
            else if (nums[rm] > target)
                h = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.search(new int[]{4, 5, 6, 7, 8, 0, 1, 2,3}, 1));
    }
}
