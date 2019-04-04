import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public List<List<Integer>> permute(int[]a)
    {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(a,new ArrayList<Integer>(),ans);
        return ans;
    }

    private void backtrack(int[] a, ArrayList<Integer> tmp, List<List<Integer>> ans) {
        if (tmp.size() == a.length)
            ans.add(new ArrayList<>(tmp));
        for (int i = 0; i < a.length; i++) {
            if (tmp.contains(a[i])) continue;
            tmp.add(a[i]);
            backtrack(a,tmp,ans);
            tmp.remove(tmp.size()-1);
        }
    }

    public void printPerm(int[] a, int i)
    {
        if (i == a.length)
            System.out.println(Arrays.toString(a));
        for (int j = i; j < a.length; j++) {
            swap(a,i,j);
            printPerm(a,i+1);
            swap(a,i,j);
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[] ip = {1,2,3};
        m.printPerm(ip,0);
        System.out.println("-------------------");
        List<List<Integer>> lst = m.permute(ip);
        for (List<Integer> l : lst)
            System.out.println(Arrays.toString(l.toArray()));
    }
}
