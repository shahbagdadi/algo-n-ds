import sun.applet.Main;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    /**
     *      BFS Template
     * Queue q = new LinkedList();
     * q.add(root)
     * setVisited(root)
     *
     * while (!q.isEmpty()) {
     *     Node n = q.poll();
     *     for(Node child: n){
     *         if (!visited(child)){
     *             q.add(child)
     *             setVisited(child)
     *         }
     *     }
     * }
     *
     */
    public static String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public static void print(TreeNode root)
    {
        if (root == null) return ;
        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }

    public static void main(String[] args) {
        // write your code here
        Codec c = new Codec();
        TreeNode n = c.deserialize("1 2 3 n n 4 5 n n n n ");
        System.out.println(c.serialize(n));
    }
}
