import java.util.*;

public class StringConversion {


    public static LinkedList StringConv(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
        HashMap<String, String> path = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();
        qs.add(beginWord);
        if (dict.contains(endWord)) {
            qe.add(endWord); // all transformed words must be in dict (including endWord)
        }
        for (int len = 2; !qs.isEmpty(); len++) {
            Set<String> nq = new HashSet<>();
            for (String w : qs) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue; // beginWord and endWord not the same, so bypass itself
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (qe.contains(nb)) {
                            String parent = nb;
                            while (parent != null && !parent.equals(beginWord) && !parent.equals(endWord)) {
                                result.addFirst(parent);
                                parent = path.remove(parent);
                            }
                            if (parent.equals(beginWord))
                                result.addFirst(beginWord);
                            else
                                result.addFirst(endWord);
                            parent = w;
                            while (parent != null && !parent.equals(beginWord) && !parent.equals(endWord)) {
                                result.addLast(parent);
                                parent = path.remove(parent);
                            }
                            if (parent.equals(endWord))
                                result.addLast(endWord);
                            else {
                                result.addLast(beginWord);
                                // reverse the list
                                LinkedList<String> reverse = new LinkedList<>();
                                for (String s : result)
                                    reverse.addFirst(s);
                                return reverse;
                            }
                            return result;
                        }
                        if (dict.contains(nb) && vis.add(nb)) {
                            nq.add(nb);
                            path.put(nb, w);
                        }
                    }
                }
            }
            qs = (nq.size() < qe.size()) ? nq : qe; // switch to small one to traverse from other end
            qe = (qs == nq) ? qe : nq;
        }
        return result;
    }


    public static void main(String[] args) {
        String[] words = new String[]{"cat", "bat", "hat", "bad", "had", "mad", "dad", "dam", "tam"};
        List<String> wlist = new ArrayList<String>(Arrays.asList(words));
        LinkedList<String> result = StringConv("tam", "bat", wlist);
        for (String s : result)
            System.out.print(s + " -> ");
    }
}
