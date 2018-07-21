import java.util.ArrayList;

public class Node {
    int val;
    ArrayList<Node> nxt;

    public Node(int n) {
        this.val = n;
        nxt = new ArrayList<Node>();
    }
}