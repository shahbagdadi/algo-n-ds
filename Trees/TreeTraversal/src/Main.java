import java.util.*;

public class Main {

    public List<Integer> recursiveTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<Integer>();
        helper(r, root);
        return r;
    }

    /**
     * Uncomment result.add as per the needed Traversal
     * @param result - List of values as per traversal order
     * @param root - Root Node
     */
    void helper(List<Integer> result, TreeNode root) {
        if (root == null) return;
        //result.add(root.val);         //preorder
        helper(result, root.left);
        result.add(root.val);           //inorder
        helper(result, root.right);
        //result.add(root.val);         //postorder
    }

    /**
     * Single iterative solution template.
     * Uncomment the lines for the traversal order desired.
     * @param root
     * @return - - List of values as per traversal order
     */
    public List<Integer> iterTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(p.val);           // Preorder - Add parent to end of list before child
                p = p.left;                  // Preorder & InOrder

                //result.addFirst(p.val);    // PostOrder - Reverse of preorder - append to start of list
                //p = p.right;               // PostOrder - Reverse the traversal process of preorder
            } else {
                TreeNode node = stack.pop();
                //result.add(node.val);      // InOrder - Add after all left children
                p = node.right;              // Preorder & InOrder
                //p = node.left;             // PostOrder - Reverse the traversal process of preorder
            }
        }
        return result;
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
        List<Integer> po = m.iterTraversal(root);
        System.out.println(po);
    }
}
