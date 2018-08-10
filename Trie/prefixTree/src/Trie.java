import java.util.HashMap;
import java.util.Set;

public class Trie {

    TrieNode root;

    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
        }

        private TrieNode appendChar(char c) {
            TrieNode n = children.get(c);
            if (n == null) {
                n = new TrieNode();
                children.put(c, n);
            }
            return n;
        }

        private TrieNode exists(char c) {
            return children.get(c);
        }

        @Override
        public String toString() {
            Set<Character> set = children.keySet();
            StringBuilder sb = new StringBuilder(set.size());
            for (char c : set)
                sb.append(c + ",");
            return sb.toString();
        }

    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node = node.appendChar(Character.toUpperCase(c));
        }
        node.isWord = true;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            node = node.exists(Character.toUpperCase(c));
            if (node == null) return false;
        }
        return true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node = node.exists(Character.toUpperCase(c));
            if (node == null) return false;
        }
        return node.isWord;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public static void main(String[] args) {
        Trie dict = new Trie();
        dict.insert("APPLE");
        dict.insert("APTECH");
        dict.insert("CISCO");
        dict.insert("CITRIX");
        dict.insert("GOOGLE");
        dict.insert("GOPRO");

        System.out.println(dict);
        System.out.println(dict.startsWith("GO"));
        System.out.println(dict.search("GOOG"));
        System.out.println(dict.search("GOOGLE"));
    }
}
