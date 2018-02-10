import java.util.LinkedList;

public class MergeBST {


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        LinkedList<TreeNode> r1 = new LinkedList<TreeNode>();
        toList(n1, r1);

        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(6);
        n4.left = n5;
        n4.right = n6;
        LinkedList<TreeNode> r2 = new LinkedList<TreeNode>();
        toList(n4, r2);

        TreeNode[] r3 = new TreeNode[r1.size() + r2.size()];
        mergeArray(r1, r2, r3);

        TreeNode root = buildAVLTree(r3, 0, r3.length - 1);
        print(root);
    }

    private static TreeNode buildAVLTree(TreeNode[] r3, int l, int h) {
        if (l > h) return null;
        int mid = (l + h) / 2;
        TreeNode root = r3[mid];
        root.left = buildAVLTree(r3, l, mid - 1);
        root.right = buildAVLTree(r3, mid + 1, h);
        return root;
    }

    private static void mergeArray(LinkedList<TreeNode> r1, LinkedList<TreeNode> r2, TreeNode[] r3) {
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

    private static void print(TreeNode n) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(n);
        while (!q.isEmpty()){
            TreeNode node = q.remove();
            System.out.print(node.val + " ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }
}
