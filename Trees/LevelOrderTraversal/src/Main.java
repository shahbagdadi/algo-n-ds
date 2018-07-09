import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     *
     * Time - O(n) - where n is number of nodes
     * Space - O(n) - when n is max number of nodes on same level
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            result.add(subList);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 9, 20, -1, -1, 15, 7};
        TreeNode n = TreeNode.createTree(a);
        Main m = new Main();
        List<List<Integer>> l = m.levelOrder(n);
        for (List<Integer> lst : l)
            System.out.println(lst);
    }
}
