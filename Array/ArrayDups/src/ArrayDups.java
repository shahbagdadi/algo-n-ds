import java.util.ArrayList;

public class ArrayDups {

    public static void main(String[] args) {
	int[] input = {4,3,2,7,8,2,3,1};
    ArrayList<Integer> r =   findDups(input);
    for (Integer i : r)
        System.out.print(i + " ");
    }

    private static ArrayList<Integer> findDups(int[] a) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            int index = Math.abs(a[i]);
            if (a[index-1] < 0)
                r.add(index);
            else
                a[index -1] *= -1;
        }
        return r;
    }
}
