import java.util.ArrayList;
import java.util.List;

class GraphNode {
    int val;
    // A neighbour List which contains references to
    // all the neighbours of a GraphNode
    List<GraphNode> neighbours;

    public GraphNode(int val) {
        this.val = val;
        neighbours = new ArrayList<GraphNode>();
    }
}
