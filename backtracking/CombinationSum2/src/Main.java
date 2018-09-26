import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, tmp, res);
        return res;
    }

    private void backtrack(int[] nums, int target, int cur, List<Integer> tmp, List<List<Integer>> res) {
        if (target < 0) return;
        else if (target == 0)
            res.add(new ArrayList<>(tmp));
        else {
            for (int i = cur; i < nums.length; i++) {
                if (i > cur && nums[i] == nums[i - 1]) continue;
                tmp.add(nums[i]);
                backtrack(nums, target - nums[i], i + 1, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // write your code here
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        Main m = new Main();
        List<List<Integer>> res = m.combinationSum2(a, 8);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
