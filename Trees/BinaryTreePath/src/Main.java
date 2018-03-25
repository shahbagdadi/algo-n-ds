import java.util.ArrayList;
import java.util.List;

public class Main {

    List<String> r = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        inorder(root, new ArrayList<TreeNode>());
        return r;
    }

    public void inorder(TreeNode root, List<TreeNode> lst) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lst.size(); i++) {
                sb.append(lst.get(i));
                if (i == lst.size() - 1)
                    lst.remove(i);
                else
                    sb.append("->");
            }
            r.add(sb.toString());
        }
        System.out.println(root.val);
        lst.add(root);
        inorder(root.left,lst);
        inorder(root.right,lst);
    }

    public static void main(String[] args) {
        System.out.println("starting");
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
        List<String> r = m.binaryTreePaths(n1);
        for (int i = 0; i < r.size(); i++) {
            String s =  r.get(i);
            System.out.println(s);
        }

    }
}
