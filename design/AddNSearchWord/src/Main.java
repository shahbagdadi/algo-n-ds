public class Main {

    class TrieNode{
        TrieNode[] children;
        boolean word;
        public TrieNode()
        {
            children = new TrieNode[26];
        }

        public TrieNode addChar(char c)
        {
            if (children[c - 'a'] == null)
                children[c - 'a'] = new TrieNode();
            return children[c - 'a'];
        }

        public TrieNode getTrieNode(char c)
        {
            return children[c - 'a'];
        }
    }

    TrieNode root ;
    /** Initialize your data structure here. */
    public Main() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] ca = word.toCharArray();
        TrieNode t = root;
        for (char c: ca)
            t = t.addChar(c);
        t.word = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(root, word, 0) ;
    }

    public boolean helper(TrieNode p, String word, int i) {
        if ( i == word.length()) return p.word;
        char c = word.charAt(i);
        if (c == '.') {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                TrieNode t = p.getTrieNode(ch);
                if (t != null)
                {
                    boolean found = helper(t,word,i+1);
                    if (found) return true;
                }
            }
        }
        else
        {
            TrieNode t = p.getTrieNode(c);
            if (t == null) return false;
            return helper(t,word,i+1);
        }
        return false;
    }
    public static void main(String[] args) {

        Main m = new Main();
        m.addWord("at");
        m.addWord("bat");
        m.addWord("dad");
        System.out.println(m.search(".at"));
    }
}
