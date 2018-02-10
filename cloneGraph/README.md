#Clone a graph and verify the clone

Given a reference to a connected, undirected graph, clone it and verify it


* Please hard code a graph input in your solution, clone it like the problem asks and return a reference to the clone.

* Then compare the clone to the original graph,
* Structure of each node of the graph has: a value and a list of neighbors.

eg:
```
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
```
* Edges are not directional, and not weighted. We don't care about what value each node has.
* This is an exercise in cloning, as well as traversing two graphs together (input and cloned),
for comparison.

Implement the below methods:
```
GraphNode cloneGraph(GraphNode source)

boolean isEqual(GraphNode source, GraphNode dest)
```

[Solution](./src/CloneGraph.java)