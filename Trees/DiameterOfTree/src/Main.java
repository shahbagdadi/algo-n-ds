public class Main {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        treeDepth(root);
        return max;
    }

    public int treeDepth(TreeNode n) {
        if (n == null) return 0;
        int l = treeDepth(n.left);
        int r = treeDepth(n.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        Main m = new Main();
        TreeNode t = Codec.deserialize("1 2 3 4 5 n n");
        System.out.println(m.diameterOfBinaryTree(t));
    }
}
