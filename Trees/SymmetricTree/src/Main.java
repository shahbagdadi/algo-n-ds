import java.util.ArrayList;
import java.util.List;

public class Main {


    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    public static void main(String[] args) {
        //int[] a = new int[]{1, 2, 2, 3, 4, 4, 3};
        int[] a = new int[]{1, 2, 3,3, -1,  2, -1};
        TreeNode n = TreeNode.createTree(a);
        //TreeNode.printTree(n);
        Main m = new Main();
        System.out.println(m.isSymmetric(n));
    }
}
