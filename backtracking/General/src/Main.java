import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * PowerSet -   T : O(n^2)     S : O(n)
     */
    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(a); //Needed for duplicates
        backtrack(list, new ArrayList<>(), a, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tmpLst, int[] a, int start) {
        list.add(new ArrayList<>(tmpLst));
        for (int i = start; i < a.length; i++) {
            //if(i > start && a[i] == a[i-1]) continue; // Needed to skip duplicates
            tmpLst.add(a[i]);
            backtrack(list, tmpLst, a, i + 1);
            tmpLst.remove(tmpLst.size() - 1);
        }
    }


    /**
     * Permutation :   T - O(n!)   S - O(n)
     */
    public List<List<Integer>> permute(int[] a) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(a); // not necessary
        backtrack(list, new ArrayList<>(), a);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] a){
        if(tempList.size() == a.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < a.length; i++){
                if(tempList.contains(a[i])) continue; // element already exists, skip
                tempList.add(a[i]);
                backtrack(list, tempList, a);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        Main m = new Main();
        int[] ip = {3,1,2};
        System.out.println(Arrays.toString(ip));
        System.out.println("========== PowerSet ===========");
        List<List<Integer>> subsets = m.subsets(ip);
        for (List<Integer> set : subsets)
            System.out.println(set);

        System.out.println();
        System.out.println("========== Permutation ===========");
        List<List<Integer>> permute = m.permute(ip);
        for (List<Integer> set : permute)
            System.out.println(set);
    }
}
