import java.util.HashSet;

public class Main {

    public boolean containsDuplicate(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <a.length ; i++) {
            if (set.contains(a[i]))
                return true;
            else
                set.add(a[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,7,9};
	Main m = new Main();
        System.out.println(m.containsDuplicate(nums));
    }
}
