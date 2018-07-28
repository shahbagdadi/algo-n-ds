import java.util.Arrays;

/**
 * visited[i] = -1. Not even exist.
 * visited[i] = 0. Exist. Non-visited.
 * visited[i] = 1. Visiting.
 * visited[i] = 2. Visited.
 */
public class Main {
    private final int N = 26; //a-z

    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N]; //graph
        int[] visited = new int[N];
        buildGraph(words, adj, visited);

        StringBuilder sb = new StringBuilder();   // replacement for stack
        for(int i = 0; i < N; i++) {
            if(visited[i] == 0) {                 // start with any unvisited
                if(!dfs(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();          // pop a stack or reverse a StringBuilder
    }

    public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;                            // 1 = visiting
        for(int j = 0; j < N; j++) {
            if(adj[i][j]) {                        // connected
                if(visited[j] == 1) return false;  // 1 => 1, cycle. A topo graph should not have a cycle.
                if(visited[j] == 0) {              // 0 = unvisited
                    if(!dfs(adj, visited, sb, j)) return false; // DFS, return false if cycle found
                }
            }
        }
        visited[i] = 2;                           // 2 = visited
        sb.append((char) (i + 'a'));              // add when no more unvisited child of this char
        return true;
    }

    public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);                 // -1 = not even existed
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) visited[c - 'a'] = 0;
            if(i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for(int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if(c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true; // connection from c1 to c2
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        String ans = m.alienOrder(new String[]{"baa", "abcd", "abca", "cab", "cad"});
        System.out.println(ans);
    }
}
