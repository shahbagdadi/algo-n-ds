public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void printInorder(TreeNode n) {
        if (n == null) return;
        printInorder(n.left);
        System.out.print(n.val + " , ");
        printInorder(n.right);
    }
}