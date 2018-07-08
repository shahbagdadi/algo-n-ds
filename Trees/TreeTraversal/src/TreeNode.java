import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void printTree(TreeNode n) {
        if (n == null) return;
        printTree(n.left);
        System.out.println(n.val);
        printTree(n.right);
    }

}