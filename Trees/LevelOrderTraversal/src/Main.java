import java.util.ArrayList;
import java.util.List;

public class Main {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<>();
        ArrayList<TreeNode> ndp = new ArrayList<>();
        ArrayList<TreeNode> ndc = new ArrayList<>();
        ndp.add(root);
        while (!ndp.isEmpty())
        {
            TreeNode n = ndp.remove(0);
            

        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 9, 20, -1, -1, 15, 7};
        TreeNode n = TreeNode.createTree(a);
        Main m = new Main();
        List<List<Integer>> l = m.levelOrder(n);
        for (List<Integer> lst : l)
        {
            for (Integer i : lst)
                System.out.print(i);
            System.out.println();
        }
    }
}
