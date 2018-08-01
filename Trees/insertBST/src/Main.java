public class Main {

    public Node insert(Node root, int val)
    {
        if (root == null)
            return new Node(val);

        if (val < root.val)
            root.left = insert(root.left, val);

        else if ( val > root.val)
            root.right = insert(root.right, val);

        return root;

    }


    void print(Node root)
    {
        if (root == null) return;
        print(root.left);
        System.out.print(root.val);
        print(root.right);
    }

    public static void main(String[] args) {

        Main m = new Main();
        Node r = new Node(1);
        m.insert(r,3);
        m.insert(r,2);
        m.insert(r,4);
        m.print(r);
    }
}
