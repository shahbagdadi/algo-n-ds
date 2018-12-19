import java.util.*;

public class Main {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if(words.length==0 || words[0].length()==0) return ret;
        Map<String, Set<String>> map = new HashMap<>();
        int wlen = words[0].length();
        // create all prefix
        for(int i=0;i<words.length;i++){
            for(int j=-1;j<words[0].length();j++){
                String s = words[i].substring(0, j+1);
                Set set = map.getOrDefault(s,new HashSet<String>());
//                System.out.println("adding " + s + "->" + words[i]);
                set.add(words[i]);
                map.put(s,set);
            }
        }
        helper(ret, new ArrayList<String>(), 0, wlen, map);
        return ret;
    }

    public void helper(List<List<String>> ret, List<String> tmp, int start, int wlen, Map<String, Set<String>> map){
        if(start == wlen)
        {
            ret.add(new ArrayList<String>(tmp));
            return;
        }

        // build search string
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=start-1;i++)
            sb.append(tmp.get(i).charAt(start));

//        System.out.println("BT " + sb.toString());
        // backtracking
        Set<String> cand = map.get(sb.toString());
        if(cand==null) return;
        for(String str:cand){
            tmp.add(str);
            helper(ret, tmp, start+1, wlen, map);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {

        Main m = new Main();
        String[] words = {"area","lead","wall","lady","ball"};
        List<List<String>> sq = m.wordSquares(words);
        for (List<String> ls: sq)
            for (String s : ls)
                System.out.println(s);
    }
}
