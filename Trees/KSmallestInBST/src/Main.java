

public class Main {

    int count = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        traverseMin(root, k);
        return result;
    }

    public void traverseMin(TreeNode root, int k) {
        if (root == null) return;
        traverseMin(root.left, k);
        count++;
        if (count == k) result = root.val;
        traverseMin(root.right, k);
    }

    public int kthLargest(TreeNode root, int k) {
        count =0;
        traverseMax(root, k);
        return result;
    }

    public void traverseMax(TreeNode root, int k) {
        if (root == null) return;
        traverseMax(root.right, k);
        count++;
        if (count == k) result = root.val;
        traverseMax(root.left, k);
    }

    public static void main(String[] args) {
        Main m = new Main();
        TreeNode n = Codec.deserialize("5 3 6 2 4 n n 1 n n n");
        System.out.println(m.kthSmallest(n, 4));
        System.out.println(m.kthLargest(n, 6));
    }
}
