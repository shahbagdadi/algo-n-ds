import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {
        GraphNode root = new GraphNode(5);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        root.neighbours.add(n1);
        root.neighbours.add(n4);
        n4.neighbours.add(n3);
        n4.neighbours.add(n2);

        GraphNode clone = cloneGraph(root);
        System.out.println(isEqual(root, clone));

    }

    private static GraphNode cloneGraph(GraphNode root) {
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        HashMap<GraphNode, GraphNode> visited = new HashMap<GraphNode, GraphNode>();
        GraphNode croot = new GraphNode(root.val);
        visited.put(root, croot);
        q.offer(root);
        while (!q.isEmpty()) {
            GraphNode node = q.poll();
            for (GraphNode neighbor : node.neighbours) {
                GraphNode n = visited.get(neighbor);
                if (n == null) {
                    n = new GraphNode(neighbor.val);
                    GraphNode cnode = visited.get(node);
                    cnode.neighbours.add(n);
                    visited.put(neighbor, n);
                    q.offer(neighbor);
                }
            }
        }
        return croot;
    }


    static boolean isEqual(GraphNode source, GraphNode dest) {

        Queue<GraphNode> qs = new LinkedList<GraphNode>();
        Queue<GraphNode> qd = new LinkedList<GraphNode>();
        HashSet<GraphNode> svisited = new HashSet<GraphNode>();
        HashSet<GraphNode> dvisited = new HashSet<GraphNode>();
        svisited.add(source);
        dvisited.add(dest);
        //System.out.println("Comparing " + source.val + " - " + dest.val);
        if (source.val != dest.val) return false;
        qs.offer(source);
        qd.offer(dest);
        while (!(qs.isEmpty() && qd.isEmpty())) {
            GraphNode snode = qs.poll();
            GraphNode dnode = qd.poll();
            Collections.sort(snode.neighbours, (GraphNode o1, GraphNode o2) -> o1.val - o2.val);
            Collections.sort(dnode.neighbours, (GraphNode o1, GraphNode o2) -> o1.val - o2.val);
            //System.out.println("Size " + snode.neighbours.size() + " " + dnode.neighbours.size());
            if (snode.neighbours.size() != dnode.neighbours.size()) return false;
            for (int i = 0; i < snode.neighbours.size(); i++) {
                GraphNode sneighbor = snode.neighbours.get(i);
                GraphNode dneighbor = dnode.neighbours.get(i);
                //System.out.println("Comparing now " + sneighbor.val +  " - " + dneighbor.val);
                if (sneighbor.val != dneighbor.val)
                    return false;
                if (!svisited.contains(sneighbor)) {
                    svisited.add(sneighbor);
                    dvisited.add(dneighbor);
                    qs.offer(sneighbor);
                    qd.offer(dneighbor);
                }
            }
        }
        if (qs.isEmpty() && qd.isEmpty())
            return true;
        else
            return false;
    }


    static void print(GraphNode source) {

        Queue<GraphNode> q = new LinkedList<GraphNode>();
        HashSet<GraphNode> visited = new HashSet<GraphNode>();
        visited.add(source);
        System.out.println(source.val);
        q.offer(source);
        while (!q.isEmpty()) {
            GraphNode node = q.poll();
            for (GraphNode neighbor : node.neighbours) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    System.out.println(neighbor.val);
                    q.offer(neighbor);
                }
            }
        }
    }


}
