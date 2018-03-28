import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(list, new ArrayList<>(), nums, used);
        return list;
    }

    private void backtrack(List<List<Integer>> list, ArrayList<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) list.add(new ArrayList<>(tmp));
        else {
            for (int j = 0; j < nums.length; j++) {
                //if (tmp.contains(nums[j])) continue;
                if (used[j] || (j > 0 && nums[j - 1] == nums[j] && !used[j-1])) continue;
                tmp.add(nums[j]);
                used[j] = true;
                backtrack(list, tmp, nums, used);
                used[j] = false;
                tmp.remove(tmp.size() - 1);

            }
        }

    }


    public static void main(String[] args) {
        int[] mat = {3,3,0,3};
        Main m = new Main();
        List<List<Integer>> r = m.permuteUnique(mat);
        for (int i = 0; i < r.size(); i++) {
            List<Integer> integers = r.get(i);
            for (int j = 0; j < integers.size(); j++) {
                System.out.print(" " + integers.get(j));
            }
            System.out.println();
        }
    }
}
