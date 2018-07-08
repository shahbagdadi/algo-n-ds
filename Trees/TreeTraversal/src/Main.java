import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public List<Integer> recursiveTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<Integer>();
        helper(r, root);
        return r;
    }

    void helper(List<Integer> result, TreeNode root) {
        if (root == null) return;
        //preorder
        //result.add(root.val);
        helper(result, root.left);
        //inorder
        result.add(root.val);
        helper(result, root.right);
        //postorder
        //result.add(root.val);
    }

    public List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                //preorder
                //list.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            //Inorder
            list.add(root.val);
            root = root.right;
        }
        return list;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        TreeNode l = new TreeNode(3);
        root.left = null;
        root.right = r;
        r.left = l;

        Main m = new Main();
//        List<Integer> po = m.recursiveTraversal(root);
        List<Integer> po = m.iterativeTraversal(root);
        System.out.println(po);
    }
}
