import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    /**
     * Time - O(E + N) - E is edge and N is nodes
     */
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) return n;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        // BFS
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    visited[node] = true;
                    for (int child : adjList.get(node)) {
                        if (!visited[child])
                            queue.offer(child);
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Main m = new Main();
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        System.out.println(m.countComponents(5, edges));
        int[][] edges2 = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        System.out.println(m.countComponents(5, edges2));
        int[][] edges3 = new int[][]{{0, 1}, {2, 3}, {1, 2}};
        System.out.println(m.countComponents(4, edges3));
    }
}
