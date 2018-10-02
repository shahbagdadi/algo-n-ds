import java.util.HashMap;
import java.util.HashSet;

public class Main {


    public int slidingWindow(String s)
    {
        int i=0,j=0, max =0, n=s.length();
        HashSet<Character> set = new HashSet<>();
        while (i < n && j < n)
        {
            if (!set.contains(s.charAt(j)))
            {
                max = Math.max(max,j-i+1);
                set.add(s.charAt(j++));
            }
            else
                set.remove(s.charAt(i++));
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, max = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)),i);
            }
            max = Math.max(max, j + 1 - i);
            map.put(s.charAt(j), j + 1);

        }
        return max;
    }


    public static void main(String[] args) {
        String s = "abcbccd";
        Main m = new Main();
        System.out.println(m.lengthOfLongestSubstring(s));
        System.out.println(m.slidingWindow(s));
    }
}
