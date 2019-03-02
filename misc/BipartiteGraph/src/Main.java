import java.util.LinkedList;
import java.util.List;

public class Main {

    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] colors = new int[N];
        for (int i = 0; i < N; i++) {
            if (colors[i] == 0 && !bfs(graph,i,colors, 1)) return false;
        }
        return true;
    }

    private boolean bfs(int[][] graph, int i, int[] colors, int color) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(i);
        colors[i] = color;
        while (!q.isEmpty())
        {
            int node = q.poll();
            for ( int child :graph[node]) {
                if (colors[child] == 0)
                {
                    colors[child] = -colors[node];
                    q.offer(child);
                }
                else if (colors[child] == colors[node]) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Main m = new Main();
        //int[][] ip = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        int[][] ip = {{1,3}, {0,2}, {1,3}, {0,2}};
        System.out.println(m.isBipartite(ip));
    }
}
