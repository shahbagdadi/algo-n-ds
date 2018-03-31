import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        backTrack(r, new ArrayList<>(), nums);
        return r;
    }

    public void backTrack(List<List<Integer>> lst, List<Integer> tmp, int[] a) {
        if (tmp.size() == a.length)
            lst.add(new ArrayList<>(tmp ));
        else {
            for (int i = 0; i < a.length; i++) {
                if (tmp.contains(a[i])) continue;
                //System.out.println("Adding " + a[i]);
                tmp.add(a[i]);
                backTrack(lst, tmp, a);
                //System.out.println("remove " + tmp.get(tmp.size() - 1));
                tmp.remove(tmp.size() - 1);
            }
        }
    }


    public static void main(String[] args) {

        Main m = new Main();
        List<List<Integer>> r = m.permute(new int[]{1, 2, 3});
        for (int i = 0; i < r.size(); i++) {
            List<Integer> integers = r.get(i);
            for (int j = 0; j < integers.size(); j++)
                System.out.print(integers.get(j));
            System.out.println();
        }

    }
}
