public class Main {

    public void flipTree(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        flipTree(root.left);
        flipTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode n = Codec.deserialize("6 3 4 7 3 8 1");
        Main m = new Main();
        m.flipTree(n);
        System.out.println(Codec.serialize(n));
    }
}
