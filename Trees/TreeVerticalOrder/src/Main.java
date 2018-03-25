import java.util.ArrayList;
import java.util.List;

public class Main {

    List<List<Integer>> r = new ArrayList<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return null;
        inorder(root);
        return r;
    }

    public void inorder(TreeNode root){
        if (root == null) return null;
        List<Integer> lst = new ArrayList<>();
        verticalOrder(root.left);
        verticalOrder(root.right);
        lst.add(root.val);
        if (root.left != null && root.left.right != null)
            lst.add(root.left.right.val);
        if (root.right != null && root.right.left != null)
            lst.add(root.right.left.val);
        r.add(lst);
    }


    public static void main(String[] args) {

        Main m = new Main();

        System.out.println();
    }
}
