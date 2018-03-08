public class DupsFromSortedArray {


    private static int removeDuplicates(int[] a) {
        int i = 0, j = 1;
        while (i < a.length && j < a.length) {
            if (a[i] != a[j])
                a[++i] = a[j++];
            else
                j++;
        }
        return i+1;
    }


    public static void main(String[] args) {
        int nums[] = new int[]{1};
        int r = removeDuplicates(nums);
        System.out.println( r);
    }
}
