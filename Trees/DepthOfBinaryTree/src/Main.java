public class Main {

    static int md = 0;
    TreeNode createTree(int[] a) {
        TreeNode[] trees = new TreeNode[a.length];
        for (int i = 0; i < (a.length) / 2; i++) {
            if (trees[i] == null ) trees[i] = new TreeNode(a[i]);
            trees[2 * i + 1] = new TreeNode(a[2 * i + 1]);
            trees[i].left = trees[2 * i + 1];
            trees[2 * i + 2] = new TreeNode(a[2 * i + 2]);
            trees[i].right = trees[2 * i + 2];
        }
        return trees[0];
    }

    void printTree(TreeNode n) {
        if (n == null) return;
        printTree(n.left);
        System.out.println(n.val);
        printTree(n.right);
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }


    public static void main(String[] args) {
        int[] a = new int[]{3, 9, 20, -1, -1, 15, 7};
        //int[] a = new int[]{3};
        Main m = new Main();
        TreeNode n = m.createTree(a);
        m.printTree(n);
        System.out.println("Depth " + m.maxDepth(n));

    }
}
