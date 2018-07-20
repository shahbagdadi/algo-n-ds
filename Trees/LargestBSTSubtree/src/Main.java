public class Main {

    // return array for each node:
    //     [0] --> min
    //     [1] --> max
    //     [2] --> largest BST in its subtree(inclusive)

    public int largestBSTSubtree(TreeNode root) {
        int[] result = findLargestBST(root);
        return result[2];
    }

    private int[] findLargestBST(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = findLargestBST(root.left);
        int[] right = findLargestBST(root.right);
        if (root.val > left[1] && root.val < right[0])
            return new int[]{Math.min(root.val, left[0]), Math.max(root.val, right[1]), left[2] + right[2] + 1};
        else
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
    }


    public static void main(String[] args) {
        Main m = new Main();
        TreeNode n = Codec.deserialize("10 5 15 1 8 n 7");
        int h = m.largestBSTSubtree(n);
        System.out.println(h);
    }
}
