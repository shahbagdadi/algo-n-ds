import java.util.*;

public class Main {

    HashMap<Integer,List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s,0,new HashSet<String>(wordDict));
    }

    private List<String> wordBreak(String s, int start , HashSet<String> dict) {
        if (map.containsKey(start))
            return map.get(start);
        List<String> res = new ArrayList<>();
        if (start == s.length())
            res.add("");
        for (int end = start +1; end <= s.length() ; end++) {
            String ss = s.substring(start,end);
            if (dict.contains(ss)){
                List<String> lst = wordBreak(s,end,dict);
                for (String li : lst)
                    res.add(ss + (li.equals("") ? "" : " ") + li);
            }
        }
        map.put(start,res);
        return res;
    }

    public static void main(String[] args) {

        Main m = new Main();
        String[] wDict = {"apple", "pen", "applepen", "pine", "pineapple"};
        List<String> ans = m.wordBreak("pineapplepenapple", Arrays.asList(wDict));
        for (String s: ans)
            System.out.println(s);
    }
}
