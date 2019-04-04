public class Main {

    public boolean isIdentical(Node n1, Node n2)
    {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.data != n2.data) return false;
        boolean b1 = isIdentical(n1.left , n2.left);
        boolean b2 = isIdentical(n1.right , n2.right);
        return b1 && b2;
    }

    public static void main(String[] args) {

        Main m = new Main();

        System.out.println();
    }
}
