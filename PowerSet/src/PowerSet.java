import java.util.*;

/**
 * Time - O(n^2)
 * Space - O(n) - Ignore the list as it is result returned
 */
public class PowerSet {

    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tmpList, int [] a, int start){
        System.out.println("Add to list : " + tmpList);
        list.add(new ArrayList<>(tmpList));
        for(int i = start; i < a.length; i++){
            System.out.println("add : " + a[i]);
            tmpList.add(a[i]);
            backtrack(list, tmpList, a, i + 1);
            System.out.println("remove : " + a[(tmpList.size() - 1)]);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        PowerSet ps = new PowerSet();
        List<List<Integer>> pset = ps.powerSet(new int[]{1,2,3});
        // print the powerset
        for (List<Integer> set : pset)
            System.out.println(set);

    }
}
