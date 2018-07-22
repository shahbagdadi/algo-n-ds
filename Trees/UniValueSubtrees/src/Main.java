public class Main {

    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private boolean helper(TreeNode node, int[] count) {
        if (node == null) return true;
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();
        TreeNode t1 = Codec.deserialize("5 1 5 5 5 n 5");
        System.out.println(m.countUnivalSubtrees(t1));

        TreeNode t2 = Codec.deserialize("5 4 5 4 4 n 5");
        System.out.println(m.countUnivalSubtrees(t2));
    }
}
