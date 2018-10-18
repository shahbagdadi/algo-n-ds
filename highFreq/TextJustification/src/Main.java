import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int idx = 0;
        while (idx < words.length) {
            int cnt = words[idx].length();
            int next = idx + 1;
            while (next < words.length) {
                if (words[next].length() + cnt + 1 > maxWidth) break;
                cnt += words[next].length() + 1;
                next++;
            }

            // Count the words to write
            int writeCnt = next - idx - 1;
            StringBuilder sb = new StringBuilder();

            // right justify for last line
            if (next == words.length || writeCnt == 0) {
                for (int i = idx; i < next; i++)
                    sb.append(words[i] + " ");

                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < maxWidth; i++)
                    sb.append(" ");

            }
            // middle justify
            else {
                int spaces = (maxWidth - cnt) / writeCnt;
                int r = (maxWidth - cnt) % writeCnt; // remainder spaces
                for (int i = idx; i < next; i++) {
                    sb.append(words[i]);
                    if (i < next - 1) {
                        int limit = spaces;
                        if ((i - idx) < r) limit = limit + 1;
                        for (int j = 0; j <= limit; j++)
                            sb.append(" ");
                    }
                }
            }
            ans.add(sb.toString());
            idx = next;
        }
        return ans;
    }

    public static void main(String[] args) {

        Main m = new Main();
        String[] ip = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        List<String> lst = m.fullJustify(ip, 20);
        for (String s : lst)
            System.out.println(s);
    }
}
