import java.util.ArrayList;
import java.util.HashSet;

public class Boggle {

    static int[] r = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] c = {-1, 0, 1, 1, 1, 0, -1, -1};
    static HashSet<String> result = new HashSet<String>();
    boolean[][] visited;
    char[][] m;
    Trie dict;

    public Boggle(char[][] matrix , Trie dict)
    {
        this.m = matrix;
        this.dict = dict;
    }

    public static void main(String[] args) {
        String[] dictionary = new String[]{"GEEKS", "FOR", "QUIZ", "GO", "SEE"};
        Trie dict = new Trie();
        for (String s : dictionary)
            dict.add(s);
        char [][] boggle = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}};
        Boggle bgl = new Boggle(boggle,dict);
        HashSet<String> words = bgl.findWords();
        for (String s : words)
            System.out.println(s + " ");
    }

    public HashSet<String> findWords() {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                String s = String.valueOf(m[i][j]);
                if (dict.prefixExist(s)) {
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
        if (dict.isWord(str))
            result.add(str);
        for (int k = 0; k < r.length; k++) {
            if (isValid(i + r[k], j + c[k])) {
                char s = m[i + r[k]][j + c[k]];
                if (dict.prefixExist(str + s))
                    dfs(i + r[k], j + c[k], str + s, visited);
                else
                    visited[i + r[k]][j + c[k]] = true;
            }
        }
    }

    private boolean isValid(int i, int j) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length)
            return false;
        return true;
    }
}
