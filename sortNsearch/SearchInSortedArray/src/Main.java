public class Main {
    public int search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return (A.length > 0 && A[lo]== target ) ? lo : -1;
    }


    /**
     * *Search in sorted array 2 - https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
     * Same as above except that if A[l0] == A[mid] do a lo++
     * @param A
     * @param target
     * @return
     */
    public boolean search2(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return true;

            if (A[lo] < A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (A[lo] > A[mid]){
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            else
                lo++;
        }
        return (A.length > 0 && A[lo]== target ) ? true : false;
    }
    public static void main(String[] args) {
        Main m = new Main();
        int r = m.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1);
        System.out.printf("Result = " + r);
    }
}
