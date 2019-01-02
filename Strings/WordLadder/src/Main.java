import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        LinkedList<String> q = new LinkedList<>();
        q.add(beginWord);
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int p = 0; p < size; p++) {
                String cur = q.poll();
                for (int i = 0; i < endWord.length(); i++) {
                    StringBuilder sb = new StringBuilder(cur);
                    for (char j = 'a'; j <= 'z'; j++) {
                        sb.setCharAt(i, j);
                        if (dict.contains(sb.toString())) {
                            if (sb.toString().equals(endWord)) return steps + 1;
                            dict.remove(sb.toString());
                            q.offer(sb.toString());
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    public static void main(String[] args) {

        Main m = new Main();
        List<String> dict = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(m.ladderLength("hit", "cog", dict));
    }
}
