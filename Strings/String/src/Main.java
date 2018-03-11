import java.util.HashMap;

public class Main {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = new Character(s.charAt(i));
            Integer n = m.get(c);
            if (n == null)
                m.put(c, 1);
            else
                m.put(c, n + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            Character c = new Character(s.charAt(i));
            Integer n = m.get(c);
            if (n == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        Main m = new Main();
        System.out.println(m.firstUniqChar(s));
    }
}
