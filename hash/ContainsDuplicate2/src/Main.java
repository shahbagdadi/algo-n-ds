import java.util.HashMap;

public class Main {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int d = i - map.get(nums[i]);
                if (d <= k)
                    return true;
                else
                    map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.containsNearbyDuplicate(new int[]{1, 2,3,  1, 2, 3}, 2));
    }
}
