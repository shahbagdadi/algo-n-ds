import javax.swing.tree.TreeNode;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
    boolean dfs_visited[] ;

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        dfs_visited = new boolean[V];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void printGraphUsingBFS(int n) {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[n] = true;
        queue.add(n);

        while (!queue.isEmpty()) {
            n = queue.poll();
            // process n
            System.out.print(n + " ");

            Iterator<Integer> i = adj[n].listIterator();    //
            while (i.hasNext()) {                           // For each (Child c : n)
                int c = i.next();                           //
                if (!visited[c]) {
                    visited[c] = true;
                    queue.add(c);
                }
            }
        }
    }

    public void printGraphUsingDFS(int n) {
        dfs_visited[n] = true;
        // process n
        System.out.print(n + " ");

        Iterator<Integer> i = adj[n].listIterator();    //
        while (i.hasNext()) {                           // For each (Child c : n)
            int c = i.next();                           //
            if (!dfs_visited[c])
                printGraphUsingDFS(c);
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2,3);
        g.addEdge(2,5);
        g.addEdge(3,4);
        g.addEdge(4,2);
        g.addEdge(4,3);
        g.addEdge(5,4);

        g.printGraphUsingBFS(1);
        System.out.println();
        g.printGraphUsingDFS(1);
    }
}
