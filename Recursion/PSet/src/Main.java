import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public List<List<Integer>> powerSet(int[] a)
    {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(a,new ArrayList<Integer>(),0,ans);
        return ans;
    }

    private void backtrack(int[] a, ArrayList<Integer> tmp, int start, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(tmp));
        for (int i = start; i < a.length; i++) {
            tmp.add(a[i]);
            backtrack(a,tmp,i+1,ans);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[] a = {1,2,3};
        List<List<Integer>> lst = m.powerSet(a);
        for (List<Integer> l : lst)
            System.out.println(Arrays.toString(l.toArray()));

    }
}
