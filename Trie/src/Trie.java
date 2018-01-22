import java.util.HashMap;
import java.util.Set;

public class Trie {

    TrieNode root;

    class TrieNode{
        char c ;
        HashMap<Character,TrieNode> map;
        boolean isWord;
        public TrieNode(char c)
        {
            this.c = c;
            map = new HashMap<Character, TrieNode>();
            //System.out.println("Created node for " + c);
        }

        private TrieNode appendChar(char c){
            TrieNode newnode;
            if (map.containsKey(c))
                newnode = map.get(c);
            else
                newnode =  new TrieNode(c);
            map.put(c, newnode);
            return newnode;
        }
        private TrieNode exists(char c){
            return map.get(c);
        }


        public String toString(){
            Set<Character> set = map.keySet();
            StringBuffer sb = new StringBuffer();
            for (char c : set)
                sb.append(c);
            return "C : " + c + " [" + sb.toString() + " ]";
        }

    }

    public Trie(){
        root = new TrieNode(' ');
    }

    public void add(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node = node.appendChar(Character.toUpperCase(c));
        }
        node.isWord = true;
    }

    public boolean prefixExist(String prefix){
        TrieNode node = root;
        boolean exists = false;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            node = node.exists(Character.toUpperCase(c));
            if (node == null) return false;
        }
        return true;
    }

    public boolean wordExist(String word){
        TrieNode node = root;
        boolean exists = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node = node.exists(Character.toUpperCase(c));
            if (node == null) return false;
        }
        return node.isWord ? true : false;
    }

    public static void main(String[] args) {
        Trie dict = new Trie();
        dict.add("APPLE");
        dict.add("APTECH");
        dict.add("CISCO");
        dict.add("CITRIX");
        dict.add("GOOGLE");
        dict.add("GOPRO");

        boolean exists = dict.prefixExist("APPL");
        boolean word = dict.wordExist("CISCO");
        System.out.println(word);
    }
}
