public class Main {

    Node h = null;
    Node p = null;

    public Node treeToDoublyList(Node root) {
        buildList(root);
        return h;
    }

    public void buildList(Node n) {
        if (n == null) return;
        buildList(n.left);
        n.left = p;
        if (p != null)
            p.right = n;
        else
            h = n; // set  left most as head, only called for left most node
        //make it circular with head
        Node r = n.right; // store this for recursion as it is reset below
        h.left = n; // keep moving the left ptr of head to the largest node so far
        n.right = h; // keep moving the right ptr of the largest node so far to the head
        // set current node as previous in order
        p = n;
        buildList(r);
    }

    public static void main(String[] args) {

        Node n1 = Codec.deserialize("4 2 5 1 3 n n");
        Main m = new Main();
        Node n = m.treeToDoublyList(n1);
        Node l = n;
        do {
            System.out.print(n.val + " ");
            n = n.right;
        } while (n != l);

    }
}
