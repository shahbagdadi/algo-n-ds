public class Main {

    public Node insertIntoBST(Node root, int n)
    {
        if (root == null) return new Node(n);
        if (n < root.data )
            root.left = insertIntoBST(root.left,n);
        else
            root.right = insertIntoBST(root.right,n);
        return root;
    }

    public static void main(String[] args) {

        Main m = new Main();

        System.out.println();
    }
}
