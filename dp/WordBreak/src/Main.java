import java.util.*;

public class Main {

    // T - O(n^n)  S - O(n)
    public boolean wordBreak(String s, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        return helper(s, dict, 0);
    }

    private boolean helper(String s, Set dict, int start) {
        if (start == s.length()) return true;
        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end)) && helper(s, dict, end))
                return true;
        }
        return false;
    }

    // T - O(n^2)  S - O(n)
    public boolean wordBreakM(String s, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Boolean[] memo = new Boolean[s.length()];
        return helperM(s, dict, 0, memo);
    }

    private boolean helperM(String s, Set dict, int start, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];
        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end)) && helper(s, dict, end)) {
                memo[start] = true;
                return true;
            }
        }
        return false;
    }


    // T - O(n^2)  S - O(n)
    public boolean wordBreakDP(String s, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int end = 1; end < dp.length; end++) {
            for (int start = 0; start < end; start++) {
                if (dp[start] && dict.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // T - O(n^2)  S - O(n)
    public boolean wordBreakBFS(String s, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        q.add(0);
        while (!q.isEmpty()) {
            int start = q.poll();
            if (!visited[start]) {
                visited[start] = true;
                for (int end = start + 1; end <= s.length(); end++) {
                    if (dict.contains(s.substring(start, end))) {
                        if (end == s.length()) return true;
                        q.add(end);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        List<String> dict = Arrays.asList(new String[]{"CAT", "CATS", "AND", "SAND", "DOG"});
        String s = "CATSANDDOG";
        Main m = new Main();
        System.out.println(m.wordBreak(s, dict));
        System.out.println(m.wordBreakM(s, dict));
        System.out.println(m.wordBreakDP(s, dict));
        System.out.println(m.wordBreakBFS(s, dict));
    }
}
