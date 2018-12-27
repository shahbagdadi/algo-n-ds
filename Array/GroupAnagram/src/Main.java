import java.util.*;

public class Main {

    public List<List<String>> groupAnagrams(String[] strs)
    {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s:strs) {
            char [] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = new String(ca);
            List<String> lst = map.getOrDefault(key,new ArrayList<String>());
            lst.add(s);
            map.put(key,lst);
        }
        List<List<String>> ans = new ArrayList<>();
        for ( List<String> l : map.values())
            ans.add(l);
        return ans;
    }

    public static void main(String[] args) {

        Main m = new Main();
        String[] ip = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = m.groupAnagrams(ip);
        for (List<String> lst:res)
            System.out.println(Arrays.toString(lst.toArray()));
    }
}
