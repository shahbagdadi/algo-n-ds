import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    // T - O(n + m) where n is number of banned words, m is number of words in the paragraph
    // S - O(n + m)
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bwords = new HashSet<>();
        for (String w : banned)
            bwords.add(w);
        String bad = null;
        int bcnt = 0;
        HashMap<String, Integer> wcnt = new HashMap<>();
        StringTokenizer st = new StringTokenizer(paragraph," !?',;.");
        while (st.hasMoreTokens()) {
            String sw = sanitize(st.nextToken());
            if (sw.length() > 0 && !bwords.contains(sw)) {
                int cnt = wcnt.getOrDefault(sw, 0);
                cnt++;
                wcnt.put(sw, cnt);
                if (cnt + 1 > bcnt) {
                    bcnt = cnt;
                    bad = sw;
                }
            }
        }
        return bad;
    }

    private String sanitize(String s) {
        StringBuilder word = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (Character.isLetter(c))
                word.append(Character.toLowerCase(c));
        }
        return word.toString();
    }


    public static void main(String[] args) {
        Main m = new Main();
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(m.mostCommonWord(s,banned));
    }
}
