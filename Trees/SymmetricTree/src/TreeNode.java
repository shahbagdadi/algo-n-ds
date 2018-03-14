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

    public static TreeNode createTree(int[] a) {
        TreeNode[] trees = new TreeNode[a.length];
        for (int i = 0; i < (a.length) / 2; i++) {
            if (trees[i] == null) trees[i] = new TreeNode(a[i]);
            trees[2 * i + 1] = (a[2 * i + 1] == -1 ) ? null : new TreeNode(a[2 * i + 1]);
            trees[i].left = trees[2 * i + 1];
            trees[2 * i + 2] = (a[2 * i + 2] == -1 ) ? null : new TreeNode(a[2 * i + 2]);
            trees[i].right = trees[2 * i + 2];
        }
        return trees[0];
    }

    public static void stackInOrder(TreeNode root)
    {
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null || !st.empty())
        {
            while (root != null)
            {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }
}
