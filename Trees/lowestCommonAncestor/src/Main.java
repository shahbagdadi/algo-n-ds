public class Main {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        return left == null ? right : right == null ? left : root;
    }

    public static void main(String[] args) {
	// write your code here
    TreeNode n = Codec.deserialize("3 5 1 6 2 0 8 n n 7 4");
    Main m = new Main();
    System.out.println(m.lowestCommonAncestor(n,new TreeNode(5), new TreeNode(1)).val);
    System.out.println(m.lowestCommonAncestor(n,new TreeNode(5), new TreeNode(4)).val);
    }
}
