import java.util.*;

public class Boggle {

    private static int[][] steps = new int[][]{{1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}};
    HashSet<String> result = new HashSet<>();
    boolean[][] visited;
    char[][] m;
    Trie dict;


    public List<String> findWords(char[][] board, String[] words) {
        this.m = board;
        this.dict = new Trie();
        for (String s : words)
            dict.insert(s);
        return new ArrayList<String>(findWords());
    }

    public HashSet<String> findWords() {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                String s = String.valueOf(m[i][j]);
                if (dict.startsWith(s)) {
                    visited = new boolean[m.length][m[0].length];
                    dfs(i, j, s, visited);
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, String str, boolean[][] visited) {
        if (!isValid(i, j)) return;
        visited[i][j] = true;
        if (dict.search(str))
            result.add(str);
        for (int[] step : steps) {
            int row = i + step[0];
            int col = j + step[1];
            if (isValid(row, col) && !visited[row][col]) {
                char c = m[row][col];
                if (dict.startsWith(str + c))
                    dfs(row, col, str + c, visited);
            }
        }
    }

    private boolean isValid(int i, int j) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String[] dictionary = new String[]{"GEEKS", "FOR", "QUIZ", "GO", "SEE"};
        char[][] boggle = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}};
        Boggle bgl = new Boggle();
        List<String> words = bgl.findWords(boggle,dictionary);
        System.out.println(Arrays.toString(words.toArray()));

        dictionary = new String[] {"oath","pea","eat","rain"};
        boggle = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        Boggle bgl2 = new Boggle();
        words = bgl2.findWords(boggle,dictionary);
        System.out.println(Arrays.toString(words.toArray()));
    }
}
