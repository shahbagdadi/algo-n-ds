public class Main {

    Node h = null;
    Node p = null;
    public Node treeToDoublyList(Node root) {
        buildList( root);
        return h;
    }

    public void buildList(Node n)
    {
        if (n == null ) return ;
        buildList(n.left);
        n.left = p;
        if (p != null)
            p.right = n;
        else
            h = n; // set  left most as head
        //make it circular with head
        Node r = n.right;
        h.left = n;
        n.right = h;
        // set current node as previous in order
        p=n;
        buildList(r);
    }

    public static void main(String[] args) {

        Node n1 = new Node(1,null,null);
        Node n3 = new Node(3,null,null);
        Node n2 = new Node(2,n1,n3);
        Main m = new Main();
        Node n = m.treeToDoublyList(n2);
        for (int i = 0; i <3 ; i++) {
            System.out.print(n.val + " ");
            n = n.right;
        }
    }
}
