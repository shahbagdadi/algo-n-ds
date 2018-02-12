import java.util.ArrayList;
import java.util.HashSet;

public class GraphCycle {

    HashSet<Node> visited;
    boolean found;

    public GraphCycle(){
        visited = new HashSet<Node>();
    }

    public boolean isCyclic(Node root){
        found = false;
        dft(root);
        return found;
    }

    public void dft(Node root ) {
        if (root == null) return ;
        visited.add(root);
        for (Node n : root.nxt)
        {
            if (visited.contains(n))
                found = true;
            else
                dft(n);
        }
    }

    public static void main(String[] args) {
        Node n2 = new Node(2);
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        n2.nxt.add(n0);
        n0.nxt.add(n1);
        n1.nxt.add(n2);
        n2.nxt.add(n3);
        n0.nxt.add(n2);
        GraphCycle gc = new GraphCycle();
        System.out.println(gc.isCyclic(n2));
    }
}
