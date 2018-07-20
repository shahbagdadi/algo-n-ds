import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stk = new Stack<>();

    public BSTIterator(TreeNode root) {
        addAllNodes(root);
    }

    private void addAllNodes(TreeNode node) {
        while (node != null) {
            stk.push(node);
            node = node.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stk.empty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode tmp = stk.pop();
        addAllNodes(tmp.right);
        return tmp.val;
    }

    public static void main(String[] args) {
        TreeNode n = Codec.deserialize("10 7 15 5 8 12 20 n 6 n n n n n n");
        //System.out.println(Codec.serialize(n));
        BSTIterator bst = new BSTIterator(n);
        while (bst.hasNext())
            System.out.print(bst.next() + " ");
    }
}
