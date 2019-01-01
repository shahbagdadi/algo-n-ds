import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 ) return 0;
        int max = 0;
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (i < s.length() && j < s.length()) {
            char ci = s.charAt(i);
            if (map.containsKey(ci) || map.size() < k) {
                int cnt = map.getOrDefault(ci, 0);
                map.put(ci, cnt + 1);
                i++;
                max = Math.max(i - j, max);
            } else if (map.size() >= k) {
                char cj = s.charAt(j);
                int cnt = map.get(cj);
                cnt--;
                j++;
                if (cnt > 0)
                    map.put(cj, cnt);
                else
                    map.remove(cj);
            }
            System.out.println("i=" + i + " j=" + j + " max=" + max + " size " + map.size());
        }
        return max;
    }

    public static void main(String[] args) {

        Main m = new Main();
        System.out.println(m.lengthOfLongestSubstringKDistinct("eceebbbba", 2));
    }
}
