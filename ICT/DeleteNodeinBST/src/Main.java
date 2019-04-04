import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public Node deleteNode(Node node, int data)
    {
        if (node == null ) return null;
        if (data < node.data)
            node.left = deleteNode(node.left,data);
        else if ( data > node.data)
            node.right = deleteNode(node.right,data);
        else {
            System.out.println("deleting " + node.data);
            if (node.left == null && node.right == null)
                return null;
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else
            {
                int right_min = getMin(node.right);
                node.data = right_min;
                node.right = deleteNode(node.right,right_min);
            }
        }
        return node;
    }


    private int getMin(Node node)
    {
        while (node.left != null)
            node = node.left;
        return node.data;
    }

//    public static String serialize(Node root) {
//        if (root == null) return "";
//        Queue<Node> q = new LinkedList<>();
//        StringBuilder res = new StringBuilder();
//        q.add(root);
//        while (!q.isEmpty()) {
//            Node node = q.poll();
//            if (node == null) {
//                res.append("n ");
//                continue;
//            }
//            res.append(node.data + " ");
//            q.add(node.left);
//            q.add(node.right);
//        }
//        return res.toString();
//    }

    public static void print(Node n)
    {
        if (n == null) return;
        print(n.left);
        System.out.println(n.data);
        print(n.right);
    }

    public static void main(String[] args) {

        Main m = new Main();
        Node r = new Node(20);
        Node n1 = new Node(15);
        Node n2 = new Node(17);
        Node n3 = new Node(13);
        r.left = n1;
        n1.right = n2;
        n1.left = n3;
        //System.out.println(m.serialize(r));
        m.print(r);
        m.deleteNode(r,15);
        //System.out.println(m.serialize(r));
        m.print(r);
    }
}
