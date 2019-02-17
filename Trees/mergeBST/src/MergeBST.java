import java.util.LinkedList;
import java.util.Queue;

public class MergeBST {


    private static TreeNode buildAVLTree(TreeNode[] r3, int l, int h) {
        if (l > h) return null;
        int mid = (l + h) / 2;
        TreeNode root = r3[mid];
        root.left = buildAVLTree(r3, l, mid - 1);
        root.right = buildAVLTree(r3, mid + 1, h);
        return root;
    }

    private static void mergeLists(LinkedList<TreeNode> r1, LinkedList<TreeNode> r2, TreeNode[] r3) {
        int i = 0;
        while (!r1.isEmpty() && !r2.isEmpty()) {
            if (r1.peek().val < r2.peek().val)
                r3[i] = r1.remove();
            else
                r3[i] = r2.remove();
            i++;
        }
        while (!r1.isEmpty())
            r3[i++] = r1.remove();

        while (!r2.isEmpty())
            r3[i++] = r2.remove();
    }

    private static void toList(TreeNode n1, LinkedList<TreeNode> r) {
        if (n1 == null) return;
        toList(n1.left, r);
        r.add(n1);
        toList(n1.right, r);
    }

    static void printLevelOrder(TreeNode root) {
        // Base Case
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int ncnt = 1;

        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            System.out.print(n.val + " ");
            ncnt--;
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
            if (ncnt == 0) {
                System.out.println();
                ncnt = q.size();
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = Codec.deserialize("2 1 3");
        LinkedList<TreeNode> r1 = new LinkedList<TreeNode>();
        toList(t1, r1);

        TreeNode t2 = Codec.deserialize("7 6 8");
        LinkedList<TreeNode> r2 = new LinkedList<TreeNode>();
        toList(t2, r2);

        TreeNode[] r3 = new TreeNode[r1.size() + r2.size()];
        mergeLists(r1, r2, r3);

        TreeNode root = buildAVLTree(r3, 0, r3.length - 1);
        printLevelOrder(root);
    }
}
