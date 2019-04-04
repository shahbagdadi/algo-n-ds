public class Main {

    public Node KLargest(Node n ,int k, Count cnt)
    {
        if (n == null) return null;
        if (KLargest(n.right,k,cnt) == null )
        {
            cnt.c += 1;
            if (cnt.c == k)
                 return node;
        }
        return KLargest(node.left,k,c);
    }

    public static void main(String[] args) {

        Main m = new Main();

        System.out.println();
    }
}
