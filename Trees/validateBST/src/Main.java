import java.util.List;
import java.util.Stack;

public class Main {



    public  boolean isValidBST(TreeNode root)
    {
        TreeNode pre = null;
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
            if (pre != null  && pre.val >= root.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{10,5,15,-1,-1,6,20};
        TreeNode n = TreeNode.createTree(a);
        TreeNode.stackInOrder(n);
        Main m = new Main();
        System.out.println(m.isValidBST(n));
    }
}
