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
        if (root == null) return ;
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
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        n3.left = n4;
        n3.right = n6;
        n6.left = n7;
        Main m = new Main();
        List<List<Integer>> r = m.verticalOrder(n1);
        for (int i = 0; i < r.size(); i++) {
            List<Integer> integers =  r.get(i);
            for (int j = 0; j < integers.size(); j++) {
                System.out.print(integers.get(j) + ",");
            }
            System.out.println();
        }
    }
}
