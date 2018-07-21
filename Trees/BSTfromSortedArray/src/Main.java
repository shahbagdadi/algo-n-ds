public class Main {

    public TreeNode sortedListToBST(int[] a) {
        if (a.length == 0) return null;
        return toBST(a, 0, a.length - 1);
    }

    public TreeNode toBST(int[] a, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(a[mid]);
        n.left = toBST(a, start, mid - 1);
        n.right = toBST(a, mid + 1, end);
        return n;
    }

    public static void main(String[] args) {
        Main m = new Main();
        TreeNode n = m.sortedListToBST(new int[]{-10,-3,0,5,9});
        System.out.println(Codec.serialize(n));
    }
}
