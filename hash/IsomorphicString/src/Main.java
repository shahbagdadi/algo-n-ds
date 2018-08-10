import java.util.HashMap;

public class Main {

    public boolean isIsomorphic(String s, String t) {
        int[] m = new int[256]; // 128 for character set of for each string
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != m[t.charAt(i)+128]) return false; // received something else for same char earlier
            System.out.println(s.charAt(i) + " = " + t.charAt(i) + " = " + (i+1));
            m[s.charAt(i)] = m[t.charAt(i)+128] = i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.isIsomorphic("acc", "cbd"));
    }
}
