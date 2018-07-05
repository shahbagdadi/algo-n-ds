public class MinInRotatedArray {

    public static void main(String[] args) {
        int[] input = {4, 5, 6, 7, 9, 10,  11, 12};
        int result = findMin(input, 0, input.length - 1);
        System.out.println(result);
    }
    // O(log n)
    private static int findMin(int[] a, int l, int h) {
        // if last 2 element then return the min as its your answer
        if (h - l == 1) return Math.min(a[h], a[l]);
        int mid = (h + l) / 2;
        if (a[l] > a[mid])
            return findMin(a, l, mid);
        else
            return findMin(a, mid, h);
    }
}
