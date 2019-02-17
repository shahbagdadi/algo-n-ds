public class Main {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // nums1 and nums2 are not empty
        int m = nums1.length;
        int n = nums2.length;
        boolean isEven = ((m + n) % 2 == 0);
        // find the short array otherwise j = (m+n)/2 -i could be negative.
        if (m < n)
            return findMedian(nums1, nums2, isEven);
        else
            return findMedian(nums2, nums1, isEven);
    }

    public double findMedian( int[] A,int[] B, boolean isEven) {
        // shortArray is A, A's length is m
        // longArray is B , B's length is n
        int m = A.length;
        int n = B.length;
        int il = 0;
        int ir = m;
        double lmax;
        double rmax;
        while (il <= ir) {
            int i = (il + ir) / 2;
            int j = (m + n) / 2 - i; // ensures len(left) = len(right)
            // if i<m and m < n, then we can calculate j>0
            // if i>0 and m < n, then we can calculate j<n
            if (i < m && B[j - 1] > A[i]) il = i + 1;
            else if (i > 0 && A[i - 1] > B[j]) ir = i - 1;
            else {
                //here, if isEven : median = (max(A[i-1],B[j-1]) + min(A[i],B[i])) / 2
                //      else      : median = min(A[i],B[j])
                //however, i,j maybe equal 0,0 or m,n
                //so, we need to classify them
                if (i == m) rmax = B[j];
                else if (j == n) rmax = A[i];
                else rmax = Math.min(A[i], B[j]);

                if (!isEven) return rmax;

                if (i == 0) lmax = B[j - 1];
                else if (j == 0) lmax = A[i - 1];
                else lmax = Math.max(A[i - 1], B[j - 1]);

                return (rmax + lmax) / 2;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[] A = {4,5,6,7,8,9,10,11,12};
        int[] B = {3,6,9,10,12,13,15,16,17};
        System.out.println(m.findMedianSortedArrays(A,B));
    }
}
